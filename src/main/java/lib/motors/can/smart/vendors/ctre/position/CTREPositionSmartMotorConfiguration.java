package lib.motors.can.smart.vendors.ctre.position;

import com.ctre.phoenix6.configs.ClosedLoopGeneralConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import lib.motors.can.smart.vendors.ctre.CTRESmartMotorConfiguration;

public class CTREPositionSmartMotorConfiguration extends CTRESmartMotorConfiguration {

    Slot0Configs slot0Configs = slot0Configs();
    Slot1Configs slot1Configs = slot1Configs();
    MotionMagicConfigs motionMagicVoltageConfigs = MotionMagicConfigs();
    MotionMagicConfigs motionMagicCurrentConfigs = MotionMagicConfigs();

    public CTREPositionSmartMotorConfiguration(int deviceNumber) {
        this(0, "rio");
    }

    public CTREPositionSmartMotorConfiguration(int deviceNumber, String canbus) {
        super(deviceNumber, canbus);
        ClosedLoopGeneralConfigs closedLoopGeneralConfigs = ClosedLoopGeneralConfigs();
        closedLoopGeneralConfigs.ContinuousWrap = true;
        talonFXConfiguration.withClosedLoopGeneral(closedLoopGeneralConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
    }

    public CTREPositionSmartMotorConfiguration withMaxVelocity(double maxVelocity) {
        motionMagicVoltageConfigs.withMotionMagicCruiseVelocity(maxVelocity);
        motionMagicCurrentConfigs.withMotionMagicCruiseVelocity(maxVelocity);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
        return this;
    }

    public CTREPositionSmartMotorConfiguration withMaxAcceleration(double maxAcceleration) {
        motionMagicVoltageConfigs.withMotionMagicAcceleration(maxAcceleration);
        motionMagicCurrentConfigs.withMotionMagicAcceleration(maxAcceleration);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
        return this;
    }

    public CTREPositionSmartMotorConfiguration withMaxJerk(double maxJerk) {
        motionMagicVoltageConfigs.withMotionMagicMaxJerk(maxJerk);
        motionMagicCurrentConfigs.withMotionMagicMaxJerk(maxJerk);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
        return this;
    }

    public CTREPositionSmartMotorConfiguration withExpoKvVoltage(double kv) {
        motionMagicVoltageConfigs.withMotionMagicExpo_kV(kv);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
        return this;
    }

    public CTREPositionSmartMotorConfiguration withExpoKaVoltage(double ka) {
        motionMagicVoltageConfigs.withMotionMagicExpo_kA(ka);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
        return this;
    }

    public CTREPositionSmartMotorConfiguration withExpoKvCurrent(double kv) {
        motionMagicCurrentConfigs.withMotionMagicExpo_kV(kv);
        return this;
    }

    public CTREPositionSmartMotorConfiguration withExpoKaCurrent(double ka) {
        motionMagicCurrentConfigs.withMotionMagicExpo_kA(ka);
        return this;
    }

    public MotionMagicConfigs getMotionMagicVoltageConfigs() {
        return motionMagicVoltageConfigs;
    }

    public MotionMagicConfigs getMotionMagicCurrentConfigs() {
        return motionMagicVoltageConfigs;
    }
}
