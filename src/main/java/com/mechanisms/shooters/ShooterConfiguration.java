package com.mechanisms.shooters;

import com.control.ClosedLoopParameters;

public class ShooterConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The radius of the wheel in meters. */
    // TODO: Malaika - Initialize a double.  It should be public and should be named wheelRadiusMeters.

    /** The ClosedLoopParameters for velocity control via current. */
    public ClosedLoopParameters VelocityClosedLoopCurrentParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for velocity control via voltage. */
    // TODO: Malaika - Initialize a ClosedLoopParameters object.  It should be public and should be named VelocityClosedLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Malaika - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Malaika - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.

    /** The velocity profile parameters.*/
    // TODO: Malaika - Initialize a VelocityProfileParameters object.  It should be public and named VelocityProfileParams.

}
