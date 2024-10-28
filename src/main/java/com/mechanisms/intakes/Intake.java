package com.mechanisms.intakes;

import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Intake {

    // TODO: Angel - Create a private final SmartMotor object called motor.

    public Intake(SmartMotor motor) {
        // TODO: Angel - Create a private final SmartMotor object called motor. - initialize this.motor to the constructor parameter.
    }

    public double getVelocityDegreesPerSecond() {
        // TODO: Angel - Use Math.toDegrees.  Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public void accept(double velocityDegreesPerSecond, VelocityProfileType profileType, InputType inputType) {
        // TODO: Angel - Use Math.toRadians.  Convert velocityDegreesPerSecond to velocityRadiansPerSecond, call motor's accept method passing in velocity in radpersec.
    }

    public void accept(double rawInput, InputType inputType) {
        // TODO: Angel - Call motor's accept method passing these parameters in.
    }

}
