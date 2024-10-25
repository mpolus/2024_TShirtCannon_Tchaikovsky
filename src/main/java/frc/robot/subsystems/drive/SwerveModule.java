package frc.robot.subsystems.drive;

import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule {
// need a steer and a drive to make a module, use in drive subsystem.
    private Steer steer;
    private DriveWheel wheel;


    public SwerveModule (int motuleNumber) {
        steer = new Steer(motuleNumber);
        wheel = new DriveWheel(motuleNumber);
    }

    public void apply(SwerveModuleState state){
        steer.SetMotorToPosition(state.angle.getDegrees);
        wheel.setVelocityMetersPerSecond(state.speedMetersPerSecond);
    }


}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */