// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubsystemsAndStuff;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;

/** Add your docs here. */
public class steer {
private static final MotorType motortype = MotorType.kBrushless;
private static final double gearing = -150/7;
CANSparkMax canSparkMax;


public steer(int motuleNumber) {
    canSparkMax = new CANSparkMax(motuleNumber + 10, motortype);
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