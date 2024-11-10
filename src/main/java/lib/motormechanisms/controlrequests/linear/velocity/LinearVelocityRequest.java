package lib.motormechanisms.controlrequests.linear.velocity;

public abstract class LinearVelocityRequest {

    private double velocityMetersPerSecond;

    public LinearVelocityRequest withVelocity(double velocityMetersPerSecond) {
        this.velocityMetersPerSecond = velocityMetersPerSecond;
        return this;
    }

    public double getVelocityMetersPerSecond() {
        return velocityMetersPerSecond;
    }
}
