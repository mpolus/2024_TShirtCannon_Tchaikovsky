package lib.motormechanisms.controlrequests.linear.position;

public abstract class LinearPositionRequest {

    private double positionMeters;

    public LinearPositionRequest withPosition(double positionMeters) {
        this.positionMeters = positionMeters;
        return this;
    }

    public double getPositionMeters() {
        return positionMeters;
    }
}
