package com.mechanisms.arms;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Arm {


    private final SmartMotor motor;

    public Arm(SmartMotor motor) {
        
        this.motor = motor;
    }

    public double getAngleDegrees() {
        
        Math.toDegrees(this.motor.getPosition());
        return this.motor.getPosition(); 
    }

    public double getAngularVelocityDegreesPerSecond() {
        
        Math.toDegrees(this.motor.getVelocity());
        return this.motor.getVelocity(); 
    }

    public void accept(double positionDegrees, PositionProfileType profileType, InputType inputType) {
    
        double positionRadians = Math.toRadians(positionDegrees);
        motor.accept(positionRadians, profileType, inputType);
    }

    public void accept(double velocityDegreesPerSecond, VelocityProfileType profileType, InputType inputType) {
        
        double velocityRadiansPerSecond = Math.toRadians(velocityDegreesPerSecond);
        motor.accept(velocityRadiansPerSecond, profileType, inputType);
    }

    public void accept(double rawInput, InputType inputType) {
        motor.accept(rawInput, inputType);
    }


}
