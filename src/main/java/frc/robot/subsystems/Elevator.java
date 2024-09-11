// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

  private final ElevatorSim elevatorSim;
  private final ElevatorFeedforward feedforward;
  private final ProfiledPIDController feedback;

  public Elevator() {
    var plant = LinearSystemId.createElevatorSystem(
        DCMotor.getNEO(1),
        Units.lbsToKilograms(10),
        Units.inchesToMeters(1.0),
        4.0 * 4.0 * 3.0 * 40.0 / 30.0);
    elevatorSim = new ElevatorSim(
        plant,
        DCMotor.getNEO(1),
        0,
        1,
        true,
        0.5);
    feedforward  = new ElevatorFeedforward(
      0.0, 
      0.08, 
      0.001,
      0.001);
    TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(
      0, 
      0); 
    feedback = new ProfiledPIDController(
      0, 
      0, 
      0, 
      constraints);
    feedback.setGoal(new State(0.5, 0));
  }

  @Override
  public void simulationPeriodic() {
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
  }

  @Override
  public void periodic() {
      double voltageFB = feedback.calculate(elevatorSim.getPositionMeters());
      double voltageFF = feedforward.calculate(
        elevatorSim.getVelocityMetersPerSecond(), 
        feedback.getSetpoint().velocity, 
        0.020);
      double voltage = voltageFB + voltageFF;
      elevatorSim.setInputVoltage(voltage);
  }



}
