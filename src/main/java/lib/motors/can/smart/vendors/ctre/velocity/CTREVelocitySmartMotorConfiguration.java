package lib.motors.can.smart.vendors.ctre.velocity;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import lib.motors.can.smart.vendors.ctre.CTRESmartMotorConfiguration;

public class CTREVelocitySmartMotorConfiguration extends CTRESmartMotorConfiguration {

    // TODO: Keith: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    Slot0Configs slot0Configs = new Slot0Configs();
    Slot1Configs slot1Configs = new Slot1Configs();
    MotionMagicConfigs motionMagicConfigs = new MotionMagicConfigs();

    public CTREVelocitySmartMotorConfiguration(int deviceNumber) {
        this(deviceNumber, "rio");
    }

    public CTREVelocitySmartMotorConfiguration(int deviceNumber, String canbus) {
        super(deviceNumber, canbus);
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKs(double ks) {
        slot0Configs.withKS(ks);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKv(double kv) {
        slot0Configs.withKV(kv);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKa(double ka) {
        slot0Configs.withKA(ka);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
        
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKp(double kp) {
        slot0Configs.withKP(kp);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKi(double ki) {
        slot0Configs.withKI(ki);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKd(double kd) {
        slot0Configs.withKD(kd);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKs(double ks) {
        slot1Configs.withKS(ks);
        talonFXConfiguration.withSlot0(slot1Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKv(double kv) {
        slot1Configs.withKV(kv);
        talonFXConfiguration.withSlot0(slot1Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKa(double ka) {
        slot1Configs.withKA(ka);
        talonFXConfiguration.withSlot0(slot1Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKp(double kp) {
        slot1Configs.withKP(kp);
        talonFXConfiguration.withSlot0(slot1Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKi(double ki) {
        slot1Configs.withKI(ki);
        talonFXConfiguration.withSlot0(slot1Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKd(double kd) {
        slot1Configs.withKD(kd);
        talonFXConfiguration.withSlot0(slot1Configs);
        return this;
    }

    public CTREVelocitySmartMotorConfiguration withMaxAcceleration(double maxAcceleration) {
        motionMagicConfigs.withMotionMagicAcceleration(maxAcceleration);
        talonFXConfiguration.withMotionMagic(motionMagicConfigs);
        return this;
    }    

    public CTREVelocitySmartMotorConfiguration withMaxJerk(double maxJerk) {
        motionMagicConfigs.withMotionMagicJerk(maxJerk);
        talonfxconfiguration.withMotionMagic(motionMagicConfigs);
        return this;
    }
}
