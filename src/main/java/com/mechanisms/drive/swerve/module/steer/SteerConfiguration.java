package com.mechanisms.drive.swerve.module.steer;

import com.control.ClosedLoopParameters;

public class SteerConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The ClosedLoopParameters for position control via voltage. */
    public ClosedLoopParameters PositionClosedLoopVoltageParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for position control via current. */
    // TODO: Robbie - Initialize a ClosedLoopParameters object.  It should be public and should be named PositionClosedLoopCurrentParams.

    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Robbie - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Robbie - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.

    /** The trapezoid profile parameters. */
    // TODO: Robbie - Initialize a TrapezoidProfileParameters object.  It should be public and named TrapProfileParams.

    /** The exponential profile parameters via voltage. */
    // TODO: Robbie - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileVoltageParams.

    /** The exponential profile parameters via current. */
    // TODO: Robbie - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileCurrentParams.
}
