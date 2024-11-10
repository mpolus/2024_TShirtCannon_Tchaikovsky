package lib.motortypes.intakes;

import lib.motortypes.MotorControllerType;
import lib.motormechanisms.controlrequests.angular.velocity.current.CurrentAngularVelocityRequest;
import lib.motormechanisms.controlrequests.angular.velocity.trapezoidal.CurrentTrapezoidAngularVelocityRequest;
import lib.motormechanisms.controlrequests.angular.velocity.trapezoidal.VoltageTrapezoidAngularVelocityRequest;
import lib.motormechanisms.controlrequests.angular.velocity.voltage.VoltageAngularVelocityRequest;
import lib.motormechanisms.controlrequests.motor.CurrentRequest;
import lib.motormechanisms.controlrequests.motor.VoltageRequest;

public interface IntakeMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getAngularVelocityDegreesPerSecond();

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void accept(VoltageAngularVelocityRequest request);

    public void accept(VoltageTrapezoidAngularVelocityRequest request);

    public void accept(CurrentAngularVelocityRequest request);

    public void accept(CurrentTrapezoidAngularVelocityRequest request);
}
