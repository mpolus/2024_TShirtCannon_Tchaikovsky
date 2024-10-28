package com.smartmotors;

public class SmartMotorConfiguration {

    /** The InputType either VOLTAGE or CURRENT */
    public InputType inputType = InputType.VOLTAGE;

    /** The FeedforwardType which is SIMPLE, ELEVATOR, or ARM */
    public FeedforwardType feedforwardType = FeedforwardType.SIMPLE;

}
