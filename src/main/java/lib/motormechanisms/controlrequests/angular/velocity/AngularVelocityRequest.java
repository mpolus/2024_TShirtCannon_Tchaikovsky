package lib.motormechanisms.controlrequests.angular.velocity;

public abstract class AngularVelocityRequest {

    private double angularVelocityDegreesPerSecond;

    public AngularVelocityRequest withVelocity(double angularVelocityDegreesPerSecond) {
        this.angularVelocityDegreesPerSecond = angularVelocityDegreesPerSecond;
        return this;
    }

    public double getAngularVelocityDegreesPerSecond() {
        return angularVelocityDegreesPerSecond;
    }
}
