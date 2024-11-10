package lib.motortypes.swervesteers;

import lib.motortypes.MotorControllerType;
import lib.motormechanisms.controlrequests.angular.position.current.CurrentAngularPositionRequest;
import lib.motormechanisms.controlrequests.angular.position.exponential.CurrentExponentialAngularPositionRequest;
import lib.motormechanisms.controlrequests.angular.position.exponential.VoltageExponentialAngularPositionRequest;
import lib.motormechanisms.controlrequests.angular.position.trapezoidal.CurrentTrapezoidAngularPositionRequest;
import lib.motormechanisms.controlrequests.angular.position.trapezoidal.VoltageTrapezoidAngularPositionRequest;
import lib.motormechanisms.controlrequests.angular.position.voltage.VoltageAngularPositionRequest;
import lib.motormechanisms.controlrequests.motor.CurrentRequest;
import lib.motormechanisms.controlrequests.motor.VoltageRequest;

public interface SwerveSteerMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getAngleDegrees();

    public void setAngleDegrees(double angleDegrees);

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void accept(VoltageAngularPositionRequest request);

    public void accept(VoltageTrapezoidAngularPositionRequest request);

    public void accept(VoltageExponentialAngularPositionRequest request);

    public void accept(CurrentAngularPositionRequest request);

    public void accept(CurrentTrapezoidAngularPositionRequest request);

    public void accept(CurrentExponentialAngularPositionRequest request);

}
