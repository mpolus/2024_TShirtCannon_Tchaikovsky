package com.control;

import com.smartmotors.FeedforwardType;

public class OpenLoopParameters {

    /** The feedforward type. This can be SIMPLE, ELEVATOR, or ARM. */
    public FeedforwardType feedforwardType;

    /** The static friction gain. */
    public double kS;

    /** The gravity gain. */
    public double kG;

    /** The velocity gain. */
    public double kV;

    /** The acceleration gain. */
    public double kA;
}
