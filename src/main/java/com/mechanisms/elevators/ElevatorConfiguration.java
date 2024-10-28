package com.mechanisms.elevators;

import com.control.ClosedLoopParameters;

public class ElevatorConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The radius of the elevators drum in meters. */
    // TODO: Jacob - Initialize a double.  It should be public and should be named drumRadiusMeters.

    /** The minimum position of the elevator in meters. */
    // TODO: Jacob - Initialize a double.  It should be public and should be named MinPosition.

    /** The maximum position of the elevator in meters. */
    // TODO: Jacob - Initialize a double.  It should be public and should be named MaxPosition.

    /** The ClosedLoopParameters for position control via voltage. */
    public ClosedLoopParameters PositionClosedLoopVoltageParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for position control via current. */
    // TODO: Jacob - Initialize a ClosedLoopParameters object.  It should be public and should be named PositionClosedLoopCurrentParams.

    /** The ClosedLoopParameters for velocity control via voltage. */
    // TODO: Jacob - Initialize a ClosedLoopParameters object.  It should be public and should be named VelocityClosedLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Jacob - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.

    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Jacob - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.

    /** The trapezoid profile parameters. */
    // TODO: Jacob - Initialize a TrapezoidProfileParameters object.  It should be public and named TrapProfileParams.

    /** The velocity profile parameters.*/
    // TODO: Jacob - Initialize a VelocityProfileParameters object.  It should be public and named VelocityProfileParams.

    /** The exponential profile parameters via voltage. */
    // TODO: Jacob - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileVoltageParams.

    /** The exponential profile parameters via current. */
    // TODO: Jacob - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileCurrentParams.
}
