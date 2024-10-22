package frc.robot.subsystems.drive;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.util.Units;

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

    private final TalonFX motor;
    private final TalonFXConfiguration talonConfigs = new TalonFXConfiguration();
    private final VelocityVoltage controlRequest;

    public driveWheel(int moduleNumber) {
        motor = new TalonFX(moduleNumber + 20);



        talonConfigs.Feedback.SensorToMechanismRatio = gearRatio * 2 * Math.PI * weelRadius;
        talonConfigs.MotionMagic.MotionMagicAcceleration = 10; //wonderfull placeholder
        talonConfigs.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        talonConfigs.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        talonConfigs.Slot0.kS = kS;
        talonConfigs.Slot0.kV = kV;
        talonConfigs.Slot0.kA = kA;
        talonConfigs.Slot0.kP = kP;
        talonConfigs.Slot0.kI = kI;
        talonConfigs.Slot0.kD = kD;
        motor.getConfigurator().apply(talonConfigs);

        controlRequest = new VelocityVoltage(0.0);

    }


    public double getVelocityMetersPerSecond() {
        return motor.getVelocity().getValueAsDouble();
    }


    public void setVelocityMetersPerSecond(double velocity) {
        motor.setControl(controlRequest.withVelocity(velocity));
    }

}
// using a talonfx
// velocity based
