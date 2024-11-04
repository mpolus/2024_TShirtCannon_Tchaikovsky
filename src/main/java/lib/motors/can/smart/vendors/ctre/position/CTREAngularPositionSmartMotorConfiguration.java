package lib.motors.can.smart.vendors.ctre.position;

import com.ctre.phoenix6.configs.FeedbackConfigs;

import lib.absoluteEncoders.can.vendors.ctre.CTREAbsoluteEncoderConfiguration;

public class CTREAngularPositionSmartMotorConfiguration extends CTREPositionSmartMotorConfiguration {

    CTREAbsoluteEncoderConfiguration encoderConfiguration;

    public CTREAngularPositionSmartMotorConfiguration(int deviceNumber, CTREAbsoluteEncoderConfiguration encoderConfiguration) {
        this(0, "rio", encoderConfiguration);

    }

    public CTREAngularPositionSmartMotorConfiguration(int deviceNumber, String canbus, CTREAbsoluteEncoderConfiguration encoderConfiguration) {
        super(0, "rio");
        this.encoderConfiguration(0,"rio");
        FeedbackConfigs.withFeedbackRemoteSensorID(encoderConfiguration.getDeviceNumber());
        FeedbackConfigs.witheedbackSensorSource(encoderConfiguration.getFeedbackSourceValue());
        talonFXConfiguration.withFeedback(FeedbackConfigs());
        motor.getConfigurator().apply(feedbackConfiguration());
    }


    public CTREAbsoluteEncoderConfiguration getEncoderConfiguration() {
        return encoderConfiguration;
    }
}
