package com.mechanisms.elevators;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Elevator {

    private final SmartMotor motor;
    public final double minPositionMeters;
    public final double maxPositionMeters;

    public Elevator(SmartMotor motor, ElevatorConfiguration config) {
        this.motor = motor;
        // TODO: ALLEN - set minPositionMeters to the one in the config
        // TODO: ALLEN - same for maxPositionMeters
    }

    public double getPositionMeters() {
        return motor.getPosition();
    }

    public double getVelocityMetersPerSecond() {
        return motor.getVelocity();
    }

    public void accept(double positionMeters, PositionProfileType profileType, InputType inputType) {
        // TODO: ALLEN - wrap the motor.accept method below in an if statement checking if positionMeters is between min and Max position.
        // TODO: ALLEN - please note we should do the same for accept velocity but since we want to hold we'll do that in the subsystem later on.
        motor.accept(positionMeters, inputType);
    }

    public void accept(double velocityMetersPerSecond, VelocityProfileType profileType, InputType inputType) {
        motor.accept(velocityMetersPerSecond, inputType);
    }

    public void accept(double rawInput, InputType inputType) {
        motor.accept(rawInput, inputType);
    }

}
