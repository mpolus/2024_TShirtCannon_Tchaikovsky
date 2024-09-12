// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Elevator;

public class RobotContainer {

  private final CommandXboxController controller = new CommandXboxController(0);
  private final Elevator elevator = new Elevator();

  public RobotContainer() {
    configureBindings();
    SmartDashboard.putData("ELEVATOR", elevator);
  }

  private void configureBindings() {
    // Runs the provided control loop command when robot is enabled.
    new Trigger(RobotState::isEnabled).whileTrue(elevator.controlLoopEnable());
    // Runs the provided disable loop when robot is disabled.
    new Trigger(RobotState::isEnabled).whileFalse(elevator.controlLoopDisable());
    // Runs the provided setGoal command when the a button.
    controller.a().onTrue(elevator.setGoal(0.5));
    new Trigger(() -> MathUtil.applyDeadband(controller.getLeftY(), 0.1) != 0.0)
        .whileTrue(elevator.manualControl(() -> MathUtil.applyDeadband(-controller.getLeftY(), 0.1)));
    new Trigger(() -> MathUtil.applyDeadband(controller.getLeftY(), 0.1) != 0.0)
        .onFalse(elevator.controlLoopEnable());

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
