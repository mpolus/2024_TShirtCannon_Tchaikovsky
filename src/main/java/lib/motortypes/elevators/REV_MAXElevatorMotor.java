package lib.motortypes.elevators;

import com.ctre.phoenix6.signals.InvertedValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController.ArbFFUnits;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.trajectory.ExponentialProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;
import pabeles.concurrency.ConcurrencyOps.Reset;

public class REV_MAXElevatorMotor extends CANSparkMax implements ElevatorMotor {
    private final ElevatorFeedforward feedforward;
    private final TrapezoidProfile trapezoidProfile;
    private final ExponentialProfile exponentialProfile;
    private final SlewRateLimiter slewRateLimiter;
    private final TrapezoidProfile.State trapGoalState = new TrapezoidProfile.State();
    private final ExponentialProfile.State expoGoalState = new ExponentialProfile.State();
    private TrapezoidProfile.State lastTrapState = new TrapezoidProfile.State();
    private final TrapezoidProfile.State lastExpoState = new TrapezoidProfile.State();

    public REV_MAXElevatorMotor(REV_MAXElevatorMotorConfig config) {
        super(config.deviceNumber(), MotorType.kBrushless);
        setInverted(config.invertedValue());
        setIdleMode(config.idleMode());
        getEncoder().setAverageDepth(config.averageDepth());
        getEncoder().setMeasurementPeriod(config.samplePeriodMs());
        getEncoder().setPositionConversionFactor(2 * Math.PI / config.sensorToMechanismRatio());
        getEncoder().setVelocityConversionFactor(2 * Math.PI / config.sensorToMechanismRatio() / 60.0);
        getPIDController().setP(config.voltagePositionKp(), 0);
        getPIDController().setI(config.voltagePositionKi(), 0);
        getPIDController().setD(config.voltagePositionKd(), 0);
        getPIDController().setP(config.voltageVelocityKp(), 1);
        getPIDController().setP(config.voltageVelocityKi(), 1);
        getPIDController().setP(config.voltageVelocityKd(), 1);
        feedforward = new ElevatorFeedforward(config.voltageKs(), config.voltageKg(), config.voltageKa());
        trapezoidProfile = new TrapezoidProfile(new TrapezoidProfile.Constraints(config.maxVelocityMetersPerSec(), config.maxAccelerationMetersPerSecSquared()));  
        exponentialProfile = new ExponentialProfile(ExponentialProfile.Constraints.fromCharacteristics(12.0, config.voltageKv(), config.voltageKa()));
        slewRateLimiter = new SlewRateLimiter(config.maxAccelerationMetersPerSecSquared());   
    }

    @Override
    public int getCanId() {
        return getDeviceId();
    }

    @Override
    public String getCanNetworkName() {
        return "rio";
    }

    @Override
    public MotorControllerType getMotorControllerType() {
        return MotorControllerType.REV_SPARK_MAX;
    }

    @Override
    public double getCurrentAmps() {
        return getOutputCurrent();
    }

    @Override
    public double getVoltageVolts() {
        return getAppliedOutput() * getBusVoltage();
    }

    @Override
    public double getPositionMeters() {
        return getEncoder().getPosition();
    }

    @Override
    public void setLinearPosition(double positionMeters) {
        getEncoder().setPosition(positionMeters);
    }

    @Override
    public double getVelocityMetersPerSecond() {
        return getEncoder().getVelocity();
    }

    @Override
    public void accept(VoltageRequest request) {
        getPIDController().setReference(request.getVolts(), ControlType.kVoltage);
    }

    @Override
    public void accept(CurrentRequest request) {
        getPIDController().setReference(request.getCurrentAmps(), ControlType.kCurrent);
    }

    @Override
    public void acceptPositionVoltage(LinearPositionRequest request) {
        double feedforwardVoltage = feedforward.calculate(getVelocityMetersPerSecond(), 0.0, 0.020);
        getPIDController().setReference(request.getPositionMeters(), ControlType.kPosition, 0, feedforwardVoltage, ArbFFUnits.kVoltage );
        lastTrapState.position = getPositionMeters();
        lastTrapState.velocity = getVelocityMetersPerSecond();
        trackExpoFromTrap();
    }


    @Override
    public void acceptTrapPositionVoltage(LinearPositionRequest request) {
        trapGoalState.position = request.getPositionMeters();
        trapGoalState.velocity = 0.0;
        lastTrapState = trapezoidProfile.calculate(0.020, lastTrapState, trapGoalState);
        double feedforwardVoltage= feedforward.calculate(getVelocityMetersPerSecond(), lastTrapState.velocity, 0.020);
        getPIDController().setReference(lastTrapState.position, ControlType.kPosition, 0, feedforwardVoltage, ArbFFUnits.kVoltage);
        trackExpoFromTrap();
    }

    @Override
    public void acceptExpoPositionVoltage(LinearPositionRequest request) {
        expoGoalState.position = //position from request passing in angle from request
        expoGoalState.velocity = 0.0;
        lastExpoState = exponentialProfile.calculate(0.020, lastExpoState, expoGoalState);
        double feedForwardVoltage = feedfoward.calculate(getVelocity, lastTrapState.velocity, 0.020);
        getPIDController().setReference(lastExpoState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage);
        trackTrapFromExpo();
    }


    @Override
    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        double feedforwardVoltage = feedforward.calculate(request.getVelocityMetersPerSecond(), 0.020);
        getPIDController().setReference(LinearVelocityRequest, ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage);
        lastTrapState.position = getPositionMeters();
        lastTrapState.velocity = getVelocityMetersPerSecond();
        lastExpoState.position = lastTrapState.position;
        lastExpoState.velocity = lastExpoState.velocity;
        slewRateLimiter.reset(lastTrapState.velocity);
    }

    @Override
    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        lastTrapState.velocity = slewRateLimiter.calculate(request.getVelocityMetersPerSecond());
        double feedfowardVoltage = feedforward.calculate(getVelocityMetersPerSecond(), lastTrapState.velocity, 0.020);
        getPIDController().setReference(lastTrapState.velocity, ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage);
        lastTrapState.position = getPositionMeters();
        lastExpoState.position = lastTrapState.position;
        lastTrapState.velocity = getVelocityMetersPerSecond();
        lastExpoState.velocity = lastTrapState.velocity;

    }

    @Override
    public void acceptPositionCurrent(LinearPositionRequest request) {
        acceptTrapPositionVoltage(request);
    }

    @Override
    public void acceptTrapPositionCurrent(LinearPositionRequest request) {
        acceptTrapPositionVoltage(request);
    }


    @Override
    public void acceptExpoPositionCurrent(LinearPositionRequest request) {
        acceptExpoPositionCurrent(request);
    }

    @Override
    public void acceptVelocityCurrent(LinearVelocityRequest request) {
        acceptVelocityVoltage(request);
    }

    @Override
    public void acceptTrapVelocityCurrent(LinearVelocityRequest request) {
        acceptTrapVelocityVoltage(request);
    }

    private void trackExpoFromTrap() {
        lastExpoState.position = lastTrapState.position;
        lastExpoState.velocity = lastTrapState.velocity;
        slewRateLimiter.reset(lastTrapState.velocity);
    }

    private void trackTrapFromExpo() {
        lastTrapState.position = lastExpoState.position;
        lastTrapState.velocity = lastExpoState.velocity;
        slewRateLimiter.reset(lastExpoState.velocity);
    }
}
