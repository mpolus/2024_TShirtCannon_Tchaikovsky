// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.LinearQuadraticRegulator;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N2;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Elevator extends SubsystemBase {

    private final ElevatorSim elevatorSim;
    private final ElevatorFeedforward feedforward;
    private final ProfiledPIDController feedback;
    private final double kv;
    private final double ka;
    private final double kg;
    private final double kp;
    private final double kd;
    private final double maxVelocity;
    private final double maxAcceleration;
    private double voltage;
    public final Trigger atGoal;
    private final DCMotor gearbox;
    private final double massKg;
    private final double drumRadiusMeters;
    private final double gearing;
    private final double Kt;

    public Elevator() {
        gearbox = DCMotor.getNEO(1);
        massKg = Units.lbsToKilograms(10);
        drumRadiusMeters = Units.inchesToMeters(1.0);
        gearing = 4.0 * 4.0 * 3.0 * 40.0 / 30.0;
        Kt = gearbox.KtNMPerAmp;
        var plant = LinearSystemId.createElevatorSystem(
                gearbox,
                massKg,
                drumRadiusMeters,
                gearing);
        kv = -plant.getA(1, 1) / plant.getB(1, 0);
        ka = 1.0 / plant.getB(1, 0);
        kg = 9.8 * ka;

        elevatorSim = new ElevatorSim(
                plant,
                gearbox,
                0,
                1,
                true,
                0.0);
        feedforward = new ElevatorFeedforward(
                0.0,
                0.081424,
                kv,
                ka);
        maxVelocity = feedforward.maxAchievableVelocity(12, 0);
        maxAcceleration = feedforward.maxAchievableAcceleration(12, 0);
        double positionQelm = 0.1;
        double velocityQelm = 0.25 * (12 - 0.0) / kv;
        LinearQuadraticRegulator<N2, N1, N1> controller = new LinearQuadraticRegulator<>(
                plant,
                VecBuilder.fill(positionQelm, velocityQelm),
                VecBuilder.fill(12.0),
                0.020);
        kp = controller.getK().get(0, 0);
        kd = controller.getK().get(0, 1);
        TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(
                maxVelocity,
                maxAcceleration);
        feedback = new ProfiledPIDController(
                kp,
                0,
                kd,
                constraints);
        atGoal = new Trigger(feedback::atGoal);
    }

    @Override
    public void simulationPeriodic() {
        if (RobotState.isDisabled()) {
            elevatorSim.setInputVoltage(voltage);
        }
        elevatorSim.update(0.020);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty(
                "HEIGHT",
                elevatorSim::getPositionMeters,
                null);
        builder.addDoubleProperty(
                "SPEED",
                elevatorSim::getVelocityMetersPerSecond,
                null);
        builder.addDoubleProperty(
                "ACCELERATION",
                () -> {
                    return -9.8 + elevatorSim.getCurrentDrawAmps() *
                            Kt * gearing /
                            drumRadiusMeters/ massKg ;
                },
                null);
        builder.addDoubleProperty(
                "kv",
                () -> kv,
                null);
        builder.addDoubleProperty(
                "ka",
                () -> ka,
                null);
        builder.addDoubleProperty(
                "kg",
                () -> kg,
                null);
        builder.addDoubleProperty(
                "kp",
                () -> kp,
                null);
        builder.addDoubleProperty(
                "kd",
                () -> kd,
                null);
        builder.addDoubleProperty(
                "maxVelocity",
                () -> maxVelocity,
                null);
        builder.addDoubleProperty(
                "maxAcceleration",
                () -> maxAcceleration,
                null);
        builder.addBooleanProperty(
                "At Goal",
                atGoal,
                null);
        builder.addDoubleProperty(
                "Goal Position",
                () -> feedback.getGoal().position, null);
        builder.addDoubleProperty(
                "Goal Velocity",
                () -> feedback.getGoal().velocity, null);
        builder.addDoubleProperty(
                "SetPoint Position",
                () -> feedback.getSetpoint().position, null);
        builder.addDoubleProperty(
                "SetPoint Velocity",
                () -> feedback.getSetpoint().velocity, null);
        builder.addDoubleProperty(
                "Voltage Input",
                () -> voltage, null);
        builder.addDoubleProperty(
                "Current",
                elevatorSim::getCurrentDrawAmps, null);
        builder.addStringProperty(
                "Current Command",
                () -> getCurrentCommand() != null ? getCurrentCommand().getName() : "none", null);
    }

    public Command setGoal(double meters) {
        return runOnce(() -> feedback.setGoal(meters))
                .andThen(controlLoopEnable()).withName("Control Loop Enabled");
    }

    public Command controlLoopEnable() {
        return run(
                () -> {
                    double voltageFB = feedback.calculate(elevatorSim.getPositionMeters());
                    double voltageFF = feedforward.calculate(
                            elevatorSim.getVelocityMetersPerSecond(),
                            feedback.getSetpoint().velocity,
                            0.020);
                    voltage = voltageFB + voltageFF;
                    voltage = MathUtil.clamp(voltage, -12.0, 12.0);
                    elevatorSim.setInputVoltage(voltage);
                }).withName("Control Loop Enabled");
    }

    public Command controlLoopDisable() {
        Command command = runOnce(() -> voltage = 0.0)
                .andThen(
                        run(
                                () -> {
                                    feedback.setGoal(elevatorSim.getPositionMeters());
                                    feedback.reset(elevatorSim.getPositionMeters());
                                }))
                .ignoringDisable(true)
                .withName("Control Loop Disabled");
        return command;
    }

    public Command manualControl(DoubleSupplier velocityPercent) {
        return run(
                () -> {
                    feedback.setGoal(elevatorSim.getPositionMeters());
                    feedback.reset(elevatorSim.getPositionMeters());
                    voltage = feedforward.calculate(
                            elevatorSim.getVelocityMetersPerSecond(),
                            velocityPercent.getAsDouble() * maxVelocity,
                            0.020);
                    voltage = MathUtil.clamp(voltage, -12.0, 12.0);
                    elevatorSim.setInputVoltage(voltage);
                })
                .withName("Manual Control");
    }

}
