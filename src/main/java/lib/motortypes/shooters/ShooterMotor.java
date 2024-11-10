package lib.motortypes.shooters;

import lib.motortypes.MotorControllerType;
import lib.motormechanisms.controlrequests.linear.velocity.current.CurrentLinearVelocityRequest;
import lib.motormechanisms.controlrequests.linear.velocity.trapezoidal.CurrentTrapezoidLinearVelocityRequest;
import lib.motormechanisms.controlrequests.linear.velocity.trapezoidal.VoltageTrapezoidLinearVelocityRequest;
import lib.motormechanisms.controlrequests.linear.velocity.voltage.VoltageLinearVelocityRequest;
import lib.motormechanisms.controlrequests.motor.CurrentRequest;
import lib.motormechanisms.controlrequests.motor.VoltageRequest;

public interface ShooterMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getVelocityMetersPerSecond();

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void accept(VoltageLinearVelocityRequest request);

    public void accept(VoltageTrapezoidLinearVelocityRequest request);

    public void accept(CurrentLinearVelocityRequest request);

    public void accept(CurrentTrapezoidLinearVelocityRequest request);
}
