package com.smartmotors.rev;

import com.revrobotics.CANSparkBase.IdleMode;

public class REVConfiguration {

    /** The can id of the REV smart motor. */
    public int deviceId;

    /** The SparkModel used. */
    // TODO: Zavian - create a SparkModel object called model and  initialize to SparkModel.NONE

    /** The MotorType used either kBrushless or kBrushed. */
    // TODO: Zavian create a MotorType object called type and initialize to MotorType.kBrushless

    /** The average sampling depth of the encoder. */
    // TODO: Zavian - create an int called depth.

    /** The time between samples in milliseconds. */
    // TODO: Zavian - create an int called period_ms.

    /** To invert the motor or not. */
    // TODO: Zavian - create a boolean called isInverted.

    /** To brake the motor when output is 0.0 */
    // TODO: Zavian create an IdleMode variable called mode and initialize to IdleMode.kBrake

    /** Feedforward period in seconds. */
    // TODO: Zavian create a double called feedforwardPeriodMs.




}
