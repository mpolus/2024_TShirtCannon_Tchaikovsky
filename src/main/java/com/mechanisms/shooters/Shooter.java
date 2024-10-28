package com.mechanisms.shooters;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Shooter {

    // TODO: Malaika - Create a private final SmartMotor object called motor.

    public Shooter(SmartMotor motor) {
        // TODO: Malaika - initialize this.motor to the constructor parameter.
    }

    public double getVelocityMetersPerSecond() {
        // TODO: Malaika - Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public void accept(double velocityMetersPerSecond, VelocityProfileType profileType, InputType inputType) {
        // TODO: Malaika - Call motor's accept method passing in velocityMetersPerSecond.
    }

    public void accept(double rawInput, InputType inputType) {
        // TODO: Malaika - Call motor's accept method passing these parameters in.
    }

}
