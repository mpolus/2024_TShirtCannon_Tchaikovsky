package com.mechanisms.elevators;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Elevator {

    private final SmartMotor motor;

    public Elevator(SmartMotor motor) {
        this.motor = motor;
    }

    public double getPositionMeters() {
        return motor.getPosition();
    }

    public double getVelocityMetersPerSecond() {
        return motor.getVelocity();
    }

    public void accept(double positionMeters, PositionProfileType profileType, InputType inputType) {
        motor.accept(positionMeters, inputType);
    }

    public void accept(double velocityMetersPerSecond, VelocityProfileType profileType, InputType inputType) {
        motor.accept(velocityMetersPerSecond, inputType);
    }

    public void accept(double rawInput, InputType inputType) {
        motor.accept(rawInput, inputType);
    }

}
