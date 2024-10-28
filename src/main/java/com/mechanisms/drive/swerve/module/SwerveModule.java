package com.mechanisms.drive.swerve.module;

import com.control.position.PositionProfileType;
import com.control.velocity.VelocityProfileType;
import com.smartmotors.InputType;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule {
    // TODO: Robbie - Create a Steer field called steer.
    // TODO: Robbie - Create a Wheel field called wheel.
    // TODO: Robbie - Create a SwerveModulePosition field called position
    // TODO: Robbie - Create a SwerveModuleState field called state

    public SwerveModule (int moduleNumber) {
        // TODO: Robbie - initialize steer.
        // TODO: Robbie - initialize wheel.
        // TODO: Robbie - initialize position
        // TODO: Robbie - initialize state
    }

    // TODO: Robbie - create a method called getPosition that returns the SwerveModulePosition field

    // TODO: Robbie - create a method called getState that returns the SwerveModuleState field

    // TODO: Robbie - create a method called setSteerFromAbsolute that calls the setPositionFromAbsolute method of the steer field.

    public void accept(
            SwerveModuleState state,
            PositionProfileType steerProfileType,
            InputType steerInputType,
            VelocityProfileType wheelProfileType,
            InputType wheelInputType){
        // TODO: Robbie - call steer's accept method
        // TODO: Robbie - Call wheel's accept method.
    }

    public void update(){
        // TODO: Robbie - set position.angle to Rotation2d.fromDegrees() with the getPositionDegrees method of steer in the argument
        // TODO: Robbie - set position.distanceMeters to wheel's getDistanceMeters() method.
        // TODO: Robbie - set state.angle to position.angle (No need to recalculate)
        // TODO: Robbie - set state.speedMetersPerSecond to the getVelocity method from wheel.
    }
}
