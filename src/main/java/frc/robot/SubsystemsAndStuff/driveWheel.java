package frc.robot.SubsystemsAndStuff;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class driveWheel {
    private static final double gearRatio = 50.0; //placeholder please replace later
    private static final double weelRadius = .2;//placeholder please replace later
    private static final double dtseconds = 0.02;

    private final TrapezoidProfile trapezoidProfile;
    private final SimpleMotorFeedforward simpleMotorFeedforward;

    private final TalonFX talonfx;
    
    

    public driveWheel(int moduleNumber) {
        talonfx = new TalonFX(moduleNumber + 20);
    }




}
// using a talonfx
// velocity based

/*
 * 
 * 
 * 
 */