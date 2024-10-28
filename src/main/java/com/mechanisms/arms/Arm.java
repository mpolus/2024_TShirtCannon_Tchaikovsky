package com.mechanisms.arms;

import com.smartmotors.SmartMotor;

public class Arm {

    // TODO: Keith - Create a private final SmartMotor object called motor.

    public Arm(SmartMotor motor, ArmConfiguration config){
        // TODO: Keith set config.MotorConfig.FeedforwardType to FeedforwardType.ARM
        // TODO: Keith - intialize this.motor to the constructor parameter.
    }

    public double getAngleDegrees(){
        // TODO: Keith - Use Math.toDegrees.  Get the Position from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

    public double getAngularVelocityDegreesPerSecond(){
        // TODO: Keith - Use Math.toDegrees. Get the Velocity from the SmartMotor object and return.
        return 0.0; // TODO: Remove or replace this.  Actually return what was asked.
    }

}
