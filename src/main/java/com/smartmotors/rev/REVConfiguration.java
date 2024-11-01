package com.smartmotors.rev;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class REVConfiguration {

    /** The can id of the REV smart motor. */
    public int deviceId;

    /** The SparkModel used. */
    // TODO: Zavian - create a SparkModel object called model and  initialize to SparkModel.NONE
        public SparkModel model = SparkModel.NONE;
    /** The MotorType used either kBrushless or kBrushed. */
    // TODO: Zavian create a MotorType object called type and initialize to MotorType.kBrushless
    MotorType type = MotorType.kBrushless;
    /** The average sampling depth of the encoder. */
    // TODO: Zavian - create an int called depth.
    public int depth;
    /** The time between samples in milliseconds. */
    // TODO: Zavian - create an int called period_ms.
    public int period_ms;
    /** To invert the motor or not. */
    // TODO: Zavian - create a boolean called isInverted.
    boolean isInverted;
    /** To brake the motor when output is 0.0 */
    // TODO: Zavian create an IdleMode variable called mode and initialize to IdleMode.kBrake
    IdleMode mode = IdleMode.kBrake;
    /** Feedforward period in seconds. */
    // TODO: Zavian create a double called feedforwardPeriodMs.
    double feedforwardPeriodMs;



}
