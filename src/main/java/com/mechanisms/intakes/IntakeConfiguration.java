package com.mechanisms.intakes;

import com.control.ClosedLoopParameters;
import com.control.OpenLoopParameters;
import com.control.velocity.VelocityProfileParameters;

public class IntakeConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The ClosedLoopParameters for velocity control via current. */
    public ClosedLoopParameters VelocityClosedLoopCurrentParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for velocity control via voltage. */
    public ClosedLoopParameters VelocityClosedLoopVoltageParams  = new ClosedLoopParameters();

    /** The OpenLoopParameters for this mechanism via voltage. */
    public OpenLoopParameters OpenLoopVoltageParams = new OpenLoopParameters();

    /** The OpenLoopParameters for this mechanism via current. */
    public OpenLoopParameters OpenLoopCurrentParams = new OpenLoopParameters();

    /** The velocity profile parameters.*/
    public VelocityProfileParameters velocityProfileParams = new VelocityProfileParameters();


