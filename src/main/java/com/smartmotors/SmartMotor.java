package com.smartmotors;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;

public abstract class SmartMotor {

    public abstract double getPosition();

    public abstract double getVelocity();

    public abstract void setPosition(double position);

    public abstract void accept(double position, PositionProfileType profileType, InputType inputType);

    public abstract void accept(double velocity, VelocityProfileType profileType, InputType inputType);

    public abstract void accept(double rawInput, InputType inputType);
}
