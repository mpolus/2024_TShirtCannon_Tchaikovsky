package com.mechanisms.arms;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import com.smartmotors.SmartMotor;

public class Arm {

    private final SmartMotor motor;
    public final double minAngleRadians;
    public final double maxAngleRadians;

    public Arm(SmartMotor motor, ArmConfiguration config) {
        this.motor = motor;
        // TODO: Keith - set minAngleRadians to the one in the config
        // TODO: Keith - Same for maxAngleRadians
    }

    public double getAngleDegrees() {
        return Math.toDegrees(this.motor.getPosition());
    }

    public double getAngularVelocityDegreesPerSecond() {
        return Math.toDegrees(this.motor.getVelocity());
    }

    public void accept(double positionDegrees, PositionProfileType profileType, InputType inputType) {
        double positionRadians = Math.toRadians(positionDegrees);
        // TODO: KEITH - wrap the motor.accept method below in an if statement checking if positionRadians is between min and Max Angle.
        // TODO: KEITH - please note we should do the same for accept velocity but since we want to hold we'll do that in the subsystem later on.
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
