// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix6.sim.ChassisReference;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveSubsystem extends SubsystemBase {

  private final SwerveDriveKinematics kinematics;
  private final SwerveModule module0;
  private final SwerveModule module1;
  private final SwerveModule module2;
  private final SwerveModule module3;


  /** Creates a new SwerveDriveSubsystem. */
  public SwerveDriveSubsystem() {
    Translation2d frontLeftPosition = new Translation2d(3, 4);
    Translation2d frontRightPosition = new Translation2d(-3, 4);
    Translation2d backLeftPosition = new Translation2d(3, -4);
    Translation2d backRightPosition = new Translation2d(-3, -4);
    kinematics = new SwerveDriveKinematics(frontLeftPosition, frontRightPosition, backLeftPosition, backRightPosition);

    module0 = new SwerveModule(0);
    module1 = new SwerveModule(1);
    module2 = new SwerveModule(3);
    module3 = new SwerveModule(3);
  };

  private void apply(SwerveModuleState[] states){
    module0.apply(states[0]);
    module1.apply(states[1]);
    module2.apply(states[2]);
    module3.apply(states[3]);

  }

  private void apply(ChassisSpeeds speeds){
    SwerveModuleState[] states = kinematics.toSwerveModuleStates(speeds);
    apply(states);
  }







  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
