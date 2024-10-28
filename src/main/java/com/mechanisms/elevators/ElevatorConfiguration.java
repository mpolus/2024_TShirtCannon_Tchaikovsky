package com.mechanisms.elevators;

import com.control.ClosedLoopParameters;
import com.control.position.ExponentialProfileParameters;
import com.control.position.TrapezoidProfileParameters;
import com.control.velocity.VelocityProfileParameters;

public class ElevatorConfiguration {

    public double Reduction;

    public double drumRadiusMeters;

    public double MinPosition;
    
    public double MaxPosition;

    public ClosedLoopParameters PositionClosedLoopVoltageParams = new ClosedLoopParameters();

    public ClosedLoopParameters PositionClosedLoopCurrentParams;

    public ClosedLoopParameters VelocityClosedLoopVoltageParams;

    public ClosedLoopParameters OpenLoopVoltageParams;

    public ClosedLoopParameters OpenLoopCurrentParams;

    public TrapezoidProfileParameters TrapProfileParams;

    public VelocityProfileParameters VelocityProfileParams;

    public ExponentialProfileParameters ExpoProfileVoltageParams;

    public ExponentialProfileParameters ExpoProfileCurrentParams;
}
