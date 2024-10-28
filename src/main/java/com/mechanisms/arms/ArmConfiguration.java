package com.mechanisms.arms;

import com.control.ClosedLoopParameters;

public class ArmConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The minimum angle of the arm in radians. */
    // TODO: Corbin - Initialize a double.  It should be public and should be named MinAngle.

    /** The maximum angle of the arm in radians. */
    // TODO: Corbin - Initialize a double.  It should be public and should be named MaxAngle.

    /** The ClosedLoopParameters for position control via voltage. */
    public ClosedLoopParameters PositionClosedLoopVoltageParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for position control via current. */
    // TODO: Corbin - Initialize a ClosedLoopParameters object.  It should be public and should be named PositionClosedLoopCurrentParams.

    /** The ClosedLoopParameters for velocity control via voltage. */
    // TODO: Corbin - Initialize a ClosedLoopParameters object.  It should be public and should be named VelocityClosedLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Corbin - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Corbin - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.

    /** The trapezoid profile parameters. */
    // TODO: Corbin - Initialize a TrapezoidProfileParameters object.  It should be public and named TrapProfileParams.

    /** The velocity profile parameters.*/
    // TODO: Corbin - Initialize a VelocityProfileParameters object.  It should be public and named VelocityProfileParams.

    /** The exponential profile parameters via voltage. */
    // TODO: Corbin - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileVoltageParams.

    /** The exponential profile parameters via current. */
    // TODO: Corbin - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileCurrentParams.
}
