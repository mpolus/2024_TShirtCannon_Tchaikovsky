package frc.robot.SubsystemsAndStuff;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class driveWheel {
    private static final double gearRatio = 50.0; //placeholder please replace later
    private static final double weelRadius = .2;//placeholder please replace later
    private static final double dtseconds = 0.02;

    // wooo this chunk is all placeholder values!!!!!
    private static final double kS = 1;
    private static final double kV = 2.6158;
    private static final double kA = 0.054006;
    private static final double kP = .001;
    private static final double kI = 0.0;
    private static final double kD = 0.0;

    private final TrapezoidProfile trapezoidProfile;
    private final SimpleMotorFeedforward simpleMotorFeedforward;
    private final PIDController pidController;

    private final TalonFX talonfx;
    
    

    public driveWheel(int moduleNumber) {
        talonfx = new TalonFX(moduleNumber + 20);
        simpleMotorFeedforward = new SimpleMotorFeedforward(kS, kV, kA);
        pidController = new PIDController(kP, kI, kD);
        double maxVelocity = simpleMotorFeedforward.maxAchievableVelocity(12, 0);
        double maxAccerlation = simpleMotorFeedforward.maxAchievableAcceleration(12, 0);
        var constraints = new TrapezoidProfile.Constraints(maxVelocity, maxAccerlation);
        trapezoidProfile = new TrapezoidProfile(constraints);

    }

    public double getVelocityMetersPerSecond() {
        double somthing = 3434343443.0;//dothis
        return somthing;
    }

    public void setVelocityMetersPerSecond(double velocity) {
        //TODO do this
    }

}
// using a talonfx
// velocity based

/*
 * 
 * 
 * 
 */