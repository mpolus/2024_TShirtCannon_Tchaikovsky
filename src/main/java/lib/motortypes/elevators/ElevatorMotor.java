package lib.motortypes.elevators;

import lib.motortypes.MotorControllerType;
import lib.motormechanisms.controlrequests.linear.position.current.CurrentLinearPositionRequest;
import lib.motormechanisms.controlrequests.linear.position.exponential.CurrentExponentialLinearPositionRequest;
import lib.motormechanisms.controlrequests.linear.position.exponential.VoltageExponentialLinearPositionRequest;
import lib.motormechanisms.controlrequests.linear.position.trapezoidal.CurrentTrapezoidLinearPositionRequest;
import lib.motormechanisms.controlrequests.linear.position.trapezoidal.VoltageTrapezoidLinearPositionRequest;
import lib.motormechanisms.controlrequests.linear.position.voltage.VoltageLinearPositionRequest;
import lib.motormechanisms.controlrequests.linear.velocity.current.CurrentLinearVelocityRequest;
import lib.motormechanisms.controlrequests.linear.velocity.trapezoidal.CurrentTrapezoidLinearVelocityRequest;
import lib.motormechanisms.controlrequests.linear.velocity.trapezoidal.VoltageTrapezoidLinearVelocityRequest;
import lib.motormechanisms.controlrequests.linear.velocity.voltage.VoltageLinearVelocityRequest;
import lib.motormechanisms.controlrequests.motor.CurrentRequest;
import lib.motormechanisms.controlrequests.motor.VoltageRequest;

public interface ElevatorMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getPositionMeters();

    public void setLinearPosition(double positionMeters);

    public double getVelocityMetersPerSecond();

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void accept(VoltageLinearPositionRequest request);

    public void accept(VoltageTrapezoidLinearPositionRequest request);

    public void accept(VoltageExponentialLinearPositionRequest request);

    public void accept(VoltageLinearVelocityRequest request);

    public void accept(VoltageTrapezoidLinearVelocityRequest request);

    public void accept(CurrentLinearPositionRequest request);

    public void accept(CurrentTrapezoidLinearPositionRequest request);

    public void accept(CurrentExponentialLinearPositionRequest request);

    public void accept(CurrentLinearVelocityRequest request);

    public void accept(CurrentTrapezoidLinearVelocityRequest request);
}
