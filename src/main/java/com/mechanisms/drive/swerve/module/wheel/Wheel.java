package com.mechanisms.drive.swerve.module.wheel;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Wheel {

    // TODO: Braden - Create a private final SmartMotor object called motor.

    public Wheel(SmartMotor motor) {
        // TODO: Braden - initialize this.motor to the constructor parameter.
    }

    public double getPositionMeters() {
        // TODO: Braden - Get the Position from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public double getVelocityMetersPerSecond() {
        // TODO: Braden - Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public void accept(double velocityMetersPerSecond, VelocityProfileType profileType, InputType inputType) {
        // TODO: Braden - Call motor's accept method passing in velocityMetersPerSecond.
    }

    public void accept(double rawInput, InputType inputType) {
        // TODO: Braden - Call motor's accept method passing these parameters in.
    }

}
