package lib.motors.control.requests;

import lib.motors.control.requests.parameters.InputType;
import lib.motors.control.requests.parameters.ProfileType;

public class MotorVelocityRequest {

    // TODO: Corbin: 01: create a double called velocity and make it private.
    public double velocity;
    // TODO: Corbin: 02: create a ProfileType called profileType and initialize to ProfileType.NONE
    // make it private
    private ProfileType profileType = ProfileType.NONE;
    // TODO: Corbin: 03: create an InputType called inputType and initialize to InputType.VOLTAGE
    // make it private
    private InputType inputType = InputType.VOLTAGE; 
    public MotorVelocityRequest withVelocity(double velocity) {
        // TODO: Corbin: 04: set this velocity to the velocity argument
        this.velocity = velocity;  
        // TODO: return this
        return this; //TODO: Corbin: 05: remove this placeholder.
    }

    public MotorVelocityRequest withNoProfile() {
        // TODO: Corbin: 06: set this profileType to ProfileType.NONE
        this.profileType = ProfileType.NONE;
        // TODO: return this
        return this; //TODO: Corbin: 07: remove this placeholder.
    }

    public MotorVelocityRequest withTrapezoidProfile() {
        // TODO: Corbin: 08: set this profileType to ProfileType.TRAPEZOID
        this.profileType = profileType.TRAPEZOID;
        // TODO: return this
        return this; //TODO: Corbin: 09: remove this placeholder.
    }

    public MotorVelocityRequest withInputType(InputType inputType) {
        // TODO: Corbin: 10: set this inputType to the inputType argument
        this.inputType = inputType;
        // TODO: return this
        return this; //TODO: Corbin: 11: remove this placeholder.
    }

    public double getVelocity() {
        // TODO: Corbin: 12: simply return the velocity
        return velocity; // TODO: Corbin: 13: remove this placeholder.
    }

    public ProfileType getProfileType() {
        // TODO: Corbin: 14: simply return the profileType
        return profileType; // TODO: Corbin: 15: remove this placeholder.
    }

    public InputType getInputType() {
        // TODO: Corbin: 16: simply return the inputType
        return inputType; // TODO: Corbin: 17: remove this placeholder.
    }
}
