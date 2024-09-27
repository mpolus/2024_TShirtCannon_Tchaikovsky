package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.CAN;

public class driveWheel {
    private static final double gearRatio = 5.0; // placeholder please replace later
    private static final double weelRadius = Units.inchesToMeters(2.0);
    private static final double dtseconds = 0.02;

    // wooo this chunk is all placeholder values!!!!!
    private static final double kS = 1;
    private static final double kV = 2.6158;
    private static final double kA = 0.054006;
    private static final double kP = .001;
    private static final double kI = 0.0;
    private static final double kD = 0.0;

    private final TalonFX talonfx;
    private final TalonFXConfiguration talonConfigs = new TalonFXConfiguration();
    private final VelocityVoltage controlRequest;

    public driveWheel(int moduleNumber) {
        talonfx = new TalonFX(moduleNumber + 20);



        talonConfigs.Feedback.SensorToMechanismRatio = gearRatio;
        talonConfigs.MotionMagic.MotionMagicAcceleration = 10; //wonderfull placeholder
        talonConfigs.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        talonConfigs.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        talonConfigs.Slot0.kS = kS;
        talonConfigs.Slot0.kV = kV;
        talonConfigs.Slot0.kA = kA;
        talonConfigs.Slot0.kP = kP;
        talonConfigs.Slot0.kI = kI;
        talonConfigs.Slot0.kD = kD;
        talonfx.getConfigurator().apply(talonConfigs);

        controlRequest = new VelocityVoltage(0.0);

    }

    public double getVelocityMetersPerSecond() {
        double somthing = 3434343443.0;// dothis
        return somthing;
    }

    public void setVelocityMetersPerSecond(double velocity) {
        // TODO do this
    }

}
// using a talonfx
// velocity based

/*
 * 
 * 
 * 
 */