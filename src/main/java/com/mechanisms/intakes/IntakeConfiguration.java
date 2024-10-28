package com.mechanisms.intakes;

import com.control.ClosedLoopParameters;

public class IntakeConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The ClosedLoopParameters for velocity control via current. */
    public ClosedLoopParameters VelocityClosedLoopCurrentParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for velocity control via voltage. */
    // TODO: Angel - Initialize a ClosedLoopParameters object.  It should be public and should be named VelocityClosedLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Angel - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Angel - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.

    /** The velocity profile parameters.*/
    // TODO: Angel - Initialize a VelocityProfileParameters object.  It should be public and named VelocityProfileParams.

}
