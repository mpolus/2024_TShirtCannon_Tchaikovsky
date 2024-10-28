package com.mechanisms.intakes;

import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Intake {

    private final SmartMotor motor;

    public Intake(SmartMotor motor) {
        this.motor = motor; 
    }

    public double getVelocityDegreesPerSecond() {
        Math.toDegrees(this.motor.getVelocity());
        return this.motor.getVelocity(); 
    }

    public void accept(double velocityDegreesPerSecond, VelocityProfileType profileType, InputType inputType) {
        double velocityRadiansPerSecond = Math.toRadians(velocityDegreesPerSecond);
        motor.accept(velocityRadiansPerSecond, profileType, inputType);
    }

    public void accept(double rawInput, InputType inputType) {
        motor.accept(rawInput, inputType);
    }

}
