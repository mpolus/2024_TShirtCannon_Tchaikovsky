// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubsystemsAndStuff;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.ExponentialProfile.Constraints;


public class steer {
private static final MotorType motortype = MotorType.kBrushless;
private static final double gearing = -150.0/7.0;
private static final double kS = 1;//placeholder change please!!!!!!!!!!!!
private static final double kV = 0.427607143;
private static final double kP = .001; //placeholder
private static final double kI = 0;
private static final double kD = .001; // placeholder


CANSparkMax canSparkMax;

private final TrapezoidProfile trapezoidProfile;
private final PIDController pidController;
private final SimpleMotorFeedforward simpleMotorFeedforward;


public steer(int motuleNumber) {
    canSparkMax = new CANSparkMax(motuleNumber + 10, motortype);
    simpleMotorFeedforward = new SimpleMotorFeedforward(kS, kV)
    pidController = new PIDController(kP, kI, kD);
    double maxVelocity = simpleMotorFeedforward.maxAchievableVelocity(12, 0);
    double maxAccerlation = simpleMotorFeedforward.maxAchievableAcceleration(12, 0)
    
}

public double getPositionDegrees() {
    double degrees = canSparkMax.getEncoder().getPosition() * 360 / gearing;
    degrees = MathUtil.inputModulus(degrees, 0, 360);
    return degrees;
}

public double getVelocityDegreesPerSecond() {
    double degreesPerSecond = canSparkMax.getEncoder().getVelocity() * 360 / 60 / gearing;
    return degreesPerSecond;
}

// under this is the monster of trying to set position.












}
// using a neo
// needs to control using position
// pid tuner