package com.mechanisms.elevators;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Elevator {

    // TODO: Allen - Create a private final SmartMotor object called motor.

    public Elevator(SmartMotor motor) {
        // TODO: Allen - initialize this.motor to the constructor parameter.
    }

    public double getPositionMeters() {
        // TODO: Allen - Get the Position from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public double getVelocityMetersPerSecond() {
        // TODO: Allen - Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public void accept(double positionMeters, PositionProfileType profileType, InputType inputType) {
        // TODO: Allen - Call motor's accept method passing in positionMeters.
    }

    public void accept(double velocityMetersPerSecond, VelocityProfileType profileType, InputType inputType) {
        // TODO: Allen - Call motor's accept method passing in velocityMetersPerSecond.
    }

    public void accept(double rawInput, InputType inputType) {
        // TODO: Allen - Call motor's accept method passing these parameters in.
    }

}
