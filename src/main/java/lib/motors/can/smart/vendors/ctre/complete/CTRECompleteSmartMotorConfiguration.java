package lib.motors.can.smart.vendors.ctre.complete;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.configs.Slot2Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import lib.motors.can.smart.vendors.ctre.CTRESmartMotorConfiguration;

public class CTRECompleteSmartMotorConfiguration extends CTRESmartMotorConfiguration {

    Slot0Configs slot0Configs = new Slot0Configs();
    Slot1Configs slot1Configs = new Slot1Configs();
    Slot2Configs slot2ConfigsVoltage = new Slot2Configs();
    Slot2Configs slot2ConfigsCurrent = new Slot2Configs();
    MotionMagicConfigs motionMagicVoltageConfigs = new MotionMagicConfigs();
    MotionMagicConfigs motionMagicCurrentConfigs = new MotionMagicConfigs();



    public CTRECompleteSmartMotorConfiguration(int deviceNumber, GravityTypeValue gravityTypeValue) {
        this(deviceNumber, "rio", gravityTypeValue);
    }

    public CTRECompleteSmartMotorConfiguration(int deviceNumber, String canbus, GravityTypeValue gravityTypeValue) {
        super(deviceNumber, canbus)
        slot0Configs.withGravityType(gravityTypeValue);
        slot1Configs.withGravityType(gravityTypeValue);
        slot2ConfigsVoltage.withGravityType(gravityTypeValue);
        slot2ConfigsCurrent.withGravityType(gravityTypeValue);
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKs(double ks) {
        slot0Configs.withKS(ks);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKv(double kv) {
        slot0Configs.withKV(kv);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKa(double ka) {
        slot0Configs.withKA(ka);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKp(double kp) {
        slot0Configs.withKP(kp);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKi(double ki) {
        slot0Configs.withKI(ki);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKd(double kd) {
        slot0Configs.withKD(kd);
        talonFXConfiguration.withSlot0(slot0Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKs(double ks) {
        slot1Configs.withKS(ks);
        talonFXConfiguration.withSlot1(slot1Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKv(double kv) {
        slot1Configs.withKV(kv);
        talonFXConfiguration.withSlot1(slot1Configs);
        return this;        
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKa(double ka) {
        slot1Configs .withKA(ka);
        talonFXConfiguration.withSlot1(slot1Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKp(double kp) {
        slot1Configs.withKP(kp);
        talonFXConfiguration.withSlot1(slot1Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKi(double ki) {
        slot1Configs.withKI(ki);
        talonFXConfiguration.withSlot1(slot1Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKd(double kd) {
        slot1Configs.withKD(kd);
        talonFXConfiguration.withSlot1(slot1Configs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKs(double ks) {
        slot2ConfigsVoltage.withKS(ks);
        talonFXConfiguration.withSlot2(slot2ConfigsVoltage);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKv(double kv) {
        slot2ConfigsVoltage.withKV(kv);
        talonFXConfiguration.withSlot2(slot2ConfigsVoltage);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKa(double ka) {
        slot2ConfigsVoltage.withKA(ka);
        talonFXConfiguration.withSlot2(slot2ConfigsVoltage);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKp(double kp) {
        slot2ConfigsVoltage.withKP(kp);
        talonFXConfiguration.withSlot2(slot2ConfigsVoltage);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKi(double ki) {
        slot2ConfigsVoltage.withKI(ki);
        talonFXConfiguration.withSlot2(slot2ConfigsVoltage);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKd(double kd) {
        slot2ConfigsVoltage.withKD(kd);
        talonFXConfiguration.withSlot2(slot2ConfigsVoltage);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKs(double ks) {
        slot2ConfigsCurrent.withKS(ks);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKv(double kv) {
        slot2ConfigsCurrent.withKV(kv);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKa(double ka) {
        slot2ConfigsCurrent.withKA(ks);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKp(double kp) {
        slot2ConfigsCurrent.withKP(kp);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKi(double ki) {
        slot2ConfigsCurrent.withKI(ki);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKd(double kd) {
        slot2ConfigsCurrent.withKD(kd);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withMaxVelocity(double maxVelocity) {
        motionMagicVoltageConfigs.withMotionMagicCruiseVelocity(maxVelocity);
        motionMagicCurrentConfigs.withMotionMagicCruiseVelocity(maxVelocity);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withMaxAcceleration(double maxAcceleration) {
        motionMagicVoltageConfigs.withMotionMagicAcceleration(maxAcceleration);
        motionMagicCurrentConfigs.withMotionMagicAcceleration(maxAcceleration);
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withMaxJerk(double maxJerk) {
        motionMagicVoltageConfigs.withMotionMagicJerk(maxJerk);
        motionMagicCurrentConfigs.withMotionMagicJerk(maxJerk);    
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withExpoKvVoltage(double kv) {
        motionMagicVoltageConfigs.withMotionMagicExpo_kV(kv);   
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withExpoKaVoltage(double ka) {
        motionMagicVoltageConfigs.withMotionMagicExpo_kA(ka);   
        talonFXConfiguration.withMotionMagic(motionMagicVoltageConfigs);
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withExpoKvCurrent(double kv) {
        motionMagicCurrentConfigs.withMotionMagicExpo_kV(kv);   
        return this;
    }

    public CTRECompleteSmartMotorConfiguration withExpoKaCurrent(double ka) {
        motionMagicCurrentConfigs.withMotionMagicExpo_kA(ka);   
        return this;
    }

    public Slot2Configs getSlot2ConfigsVoltage(){
        return slot2ConfigsVoltage;
    }

    public Slot2Configs getSlot2ConfigsCurrent(){
        return slot2ConfigsCurrent;
    }

    public MotionMagicConfigs getMotionMagicVoltageConfigs() {
        return motionMagicVoltageConfigs;
    }

    public MotionMagicConfigs getMotionMagicCurrentConfigs() {
        return motionMagicCurrentConfigs;
    }
}
