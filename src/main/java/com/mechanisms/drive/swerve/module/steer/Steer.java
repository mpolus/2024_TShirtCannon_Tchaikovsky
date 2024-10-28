package com.mechanisms.drive.swerve.module.steer;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Steer {

    // TODO: Robbie - Create a private final SmartMotor object called motor.

    public Steer(SmartMotor motor) {
        // TODO: Robbie - initialize this.motor to the constructor parameter.
    }

    public double getAngleDegrees() {
        // TODO: Robbie - Use Math.toDegrees.  Get the Position from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public double getAngularVelocityDegreesPerSecond() {
        // TODO: Robbie - Use Math.toDegrees. Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public void accept(double positionDegrees, PositionProfileType profileType, InputType inputType) {
        // TODO: Robbie - Use Math.toRadians.  Convert positionDegrees to positionRadians, call motor's accept method passing in position in radians.
    }

    public void accept(double rawInput, InputType inputType) {
        // TODO: Robbie - Call motor's accept method passing these parameters in.
    }


}
