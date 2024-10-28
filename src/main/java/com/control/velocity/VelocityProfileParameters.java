package com.control.velocity;

/**
 * Units are radians for angular motion and meters for linear motion.
 */
public class VelocityProfileParameters {

    /** The maximum acceleration of the mechanism in units per second per second. */
    public double MaxAcceleration;

    /** The maximum jerk of the mechanism in units per second per second per second. */
    public double MaxJerk = Double.POSITIVE_INFINITY;

}
