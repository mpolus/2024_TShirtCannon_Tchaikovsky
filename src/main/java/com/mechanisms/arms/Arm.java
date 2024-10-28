package com.mechanisms.arms;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Arm {

    // TODO: Keith - Create a private final SmartMotor object called motor.

    public Arm(SmartMotor motor) {
        // TODO: Keith - initialize this.motor to the constructor parameter.
    }

    public double getAngleDegrees() {
        // TODO: Keith - Use Math.toDegrees.  Get the Position from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public double getAngularVelocityDegreesPerSecond() {
        // TODO: Keith - Use Math.toDegrees. Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public void accept(double positionDegrees, PositionProfileType profileType, InputType inputType) {
        // TODO: Keith - Use Math.toRadians.  Convert positionDegrees to positionRadians, call motor's accept method passing in position in radians.
    }

    public void accept(double velocityDegreesPerSecond, VelocityProfileType profileType, InputType inputType) {
        // TODO: Keith - Use Math.toRadians.  Convert velocityDegreesPerSecond to velocityRadiansPerSecond, call motor's accept method passing in velocity in radpersec.
    }

    public void accept(double rawInput, InputType inputType) {
        // TODO: Keith - Call motor's accept method passing these parameters in.
    }


}
