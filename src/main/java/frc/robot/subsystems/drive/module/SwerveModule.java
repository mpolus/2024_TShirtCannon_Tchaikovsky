package frc.robot.subsystems.drive.module;

import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule {
    private final Steer steer;
    private final Wheel wheel;
    // TODO: create a SwerveModulePosition field called position
    // TODO: create a SwerveModuleState field called state

    public SwerveModule (int moduleNumber) {
        steer = new Steer(moduleNumber);
        wheel = new Wheel(moduleNumber);
        // TODO: initialize position
        // TODO: initialize state
    }

    // TODO: create a method called getPosition that returns the SwerveModulePosition field

    // TODO: create a method called getState that returns the SwerveModuleState field

    // TODO: create a method called setSteerFromAbsolute that calls the setPositionFromAbsolute method of the steer field.

    public void apply(SwerveModuleState state){
        steer.accept(state.angle.getDegrees());
        wheel.accept(state.speedMetersPerSecond);
    }

    public void update(){
        // TODO: set position.angle to Rotation2d.fromDegrees() with the getPositionDegrees method of steer in the argument
        // TODO: set position.distanceMeters to wheel's getDistanceMeters() method.
        // TODO: set state.angle to position.angle (No need to recalculate)
        // TODO: set state.speedMetersPerSecond to the getVelocity method from wheel.
    }
}
