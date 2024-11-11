package lib.motortypes.elevators;

import com.ctre.phoenix6.signals.InvertedValue;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.trajectory.ExponentialProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class REV_MAXElevatorMotor extends CANSparkMax implements ElevatorMotor {
    private final ElevatorFeedforward feedforward;
    private final TrapezoidProfile trapezoidProfile;
    private final ExponentialProfile exponentialProfile;
    private final SlewRateLimiter slewRateLimiter;
    private final TrapezoidProfile.State trapGoalState = new TrapezoidProfile.State();
    private final ExponentialProfile.State expoGoalState = new ExponentialProfile.State();
    private final TrapezoidProfile.State lastTrapState = new TrapezoidProfile.State();
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
        trapezoidProfile = new TrapezoidProfile(TrapezoidProfile.Constraints(config.maxVelocityMetersPerSec(), config.maxAccelerationMetersPerSecSquared());  
        exponentialProfile = new ExponentialProfile(ExponentialProfile.Constraints.fromCharacteristics(12.0, voltageKv, voltageKa);
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
        return getEncoder().getPosition;
    }

    @Override
    public void setLinearPosition(double positionMeters) {
        getEncoder(positionMeters).setPosition;
    }

    @Override
    public double getVelocityMetersPerSecond() {
        return getEncoder().getVelocity;
    }

    @Override
    public void accept(VoltageRequest request) {
        getPIDController().setReference;
        //passing in volts from request and ControlType.kVoltage
    }

    @Override
    public void accept(CurrentRequest request) {
        // TODO: call getPIDController().setReference passing in current from request and ControlType.kCurrent
    }

    @Override
    public void acceptPositionVoltage(LinearPositionRequest request) {
        // TODO: create a double feedforwardVoltage variable and initialize to feedfoward.calculate() passing in
        // getVelocityMetersPerSecond and 0.0 and 0.020
        // TODO: call getPIDController().setReference passing in position from request, ControlType.kPosition, 0, feedforwardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to getPositionMeters
        // TODO: set lastTrapState.velocity similarly to position but for velocity.
        // TODO: call trackExpoFromTrap()
    }


    @Override
    public void acceptTrapPositionVoltage(LinearPositionRequest request) {
        // TODO: set trapGoalState.position to the position stored in request.
        // TODO: set trapGoalState.velocity to 0.0;
        // TODO: set lastTrapState to trapezoidProfile.calculate(0.020, lastTrapState, trapGoalState)
        // TODO: create a double called feedForwardVoltage and get from feedfoward.calculate(getVelocity from request, lastTrapState.velocity, 0.020)
        // TODO: call getPIDController().setReference passing in lastTrapState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage
        // TODO: call trackExpoFromTrap()
    }

    @Override
    public void acceptExpoPositionVoltage(LinearPositionRequest request) {
        // TODO: set expoGoalState.position to position from request passing in angle from request
        // TODO: set expoGoalState.velocity to 0.0;
        // TODO: set lastExpoState to exponentialProfile.calculate(0.020, lastExpoState, expoGoalState)
        // TODO: create a double called feedForwardVoltage and get from feedfoward.calculate(getVelocity, lastTrapState.velocity, 0.020)
        // TODO: call getPIDController().setReference passing in lastExpoState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage
        // TODO: call trackTrapFromExpo()
    }


    @Override
    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        // TODO: create a double called feedforwardVoltage and get from feedforward.calculate(getVelocity, velocity from request, 0.020);
        // TODO: call getPIDController().setReference passing in velocity from request, ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to getPosition
        // TODO: repeat for lastTrapState.velocity using velocity
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState's velocity
        // TODO: call slewRateLimiter's reset method passing in lastTrapState.velocity
    }

    @Override
    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        // TODO: set lastTrapState.velocity to slewRateLimiter.calculate(passing in velocity from request.
        // TODO: create a double called feedfowardVoltage and get from feedfoward.calculate() passing getVelocity, velocity from request, 0.020
        // TODO: call getPIDController().setReference passing in lastTrapState.velocity, ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to getPosition
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState's velocity.
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
