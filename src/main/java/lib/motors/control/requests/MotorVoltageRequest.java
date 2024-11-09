package lib.motors.control.requests;

public class MotorVoltageRequest {

    public double volts;

    public double getVolts() {
        return volts;
    }

    public MotorVoltageRequest withVoltage(double volts) {
        this.volts = volts;
        return this;
    }
}
