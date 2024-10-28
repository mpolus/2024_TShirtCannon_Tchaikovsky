package com.mechanisms.drive.swerve.module.wheel;

import com.control.ClosedLoopParameters;

public class WheelConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The radius of the wheel in meters. */
    // TODO: Braden - Initialize a double.  It should be public and should be named drumRadiusMeters.

    /** The ClosedLoopParameters for velocity control via current. */
    public ClosedLoopParameters VelocityClosedLoopCurrentParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for velocity control via voltage. */
    // TODO: Braden - Initialize a ClosedLoopParameters object.  It should be public and should be named VelocityClosedLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Braden - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Braden - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.

    /** The velocity profile parameters.*/
    // TODO: Braden - Initialize a VelocityProfileParameters object.  It should be public and named VelocityProfileParams.

}
