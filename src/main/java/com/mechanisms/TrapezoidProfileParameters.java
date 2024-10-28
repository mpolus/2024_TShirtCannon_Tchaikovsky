package com.mechanisms;

/**
 * Units are radians for angular motion and meters for linear motion.
 */
public class TrapezoidProfileParameters {

    /** The maximum velocity of the mechanism in units per second. */
    public double MaxVelocity;

    /** The maximum acceleration of the mechanism in units per second per second. */
    public double MaxAcceleration = Double.POSITIVE_INFINITY;

    /** The maximum jerk of the mechanism in units per second per second per second. */
    public double MaxJerk = Double.POSITIVE_INFINITY;

}
