package lib.motors.can.smart.vendors.ctre;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;

public abstract class CTRESmartMotorConfiguration {

    private final int deviceNumber;
    private final String canbus;
    protected final TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();
    private final MotorOutputConfigs motorOutputConfigs = new MotorOutputConfigs();
    protected final FeedbackConfigs feedbackConfigs = new FeedbackConfigs();


    public CTRESmartMotorConfiguration(int deviceNumber) {
        this.deviceNumber = deviceNumber;
        this.canbus = "rio";
    }

    public CTRESmartMotorConfiguration(int deviceNumber, String canbus) {
        this.deviceNumber = deviceNumber;
        this.canbus = canbus;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public String getCanbus() {
        return canbus;
    }

    public final TalonFXConfiguration getTalonFXConfiguration() {
        return talonFXConfiguration;
    }

    public final CTRESmartMotorConfiguration withNeutralModeValue(NeutralModeValue neutralModeValue) {
        motorOutputConfigs.withNeutralMode(neutralModeValue);
        talonFXConfiguration.withMotorOutput(motorOutputConfigs);
        return this;
    }

    public final CTRESmartMotorConfiguration withInvertedValue(InvertedValue invertedValue) {
        motorOutputConfigs.withInverted(invertedValue);
        talonFXConfiguration.withMotorOutput(motorOutputConfigs);
        return this;
    }

    public final CTRESmartMotorConfiguration withRotorToSensorRatio(double rotorToSensorRatio) {
        feedbackConfigs.withRotorToSensorRatio(rotorToSensorRatio);
        talonFXConfiguration.withFeedback(feedbackConfigs);
        return this;
    }

    public final CTRESmartMotorConfiguration withSensorToMechanismRatio(double sensorToMechanismRatio) {
        feedbackConfigs.withSensorToMechanismRatio(sensorToMechanismRatio);
        talonFXConfiguration.withFeedback(feedbackConfigs);
        return this;
    }
}
