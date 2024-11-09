package lib.motors.can.smart.vendors.ctre.position;

import lib.motors.can.smart.usages.position.AngularPositionSmartMotor;
import lib.absoluteEncoders.AbsoluteEncoder;
import lib.absoluteEncoders.can.vendors.ctre.CTREAbsoluteEncoder;

public class CTREAngularPositionSmartMotor extends CTREPositionSmartMotor implements AngularPositionSmartMotor {

    CTREAbsoluteEncoder ctreAbsoluteEncoder;

    public CTREAngularPositionSmartMotor(CTREAngularPositionSmartMotorConfiguration config) {
        super(config);
        this.ctreAbsoluteEncoder = new.CTREAbsoluteEncoder(config.getEncoderConfiguration());
    }

    @Override
    public AbsoluteEncoder getAbsoluteEncoder() {
        return ctreAbsoluteEncoder;
    }

    @Override
    public void setMotorEncoderFromAbsolute() {
        motor.setPosition(ctreAbsoluteEncoder.getAbsoluteAngleDegrees())

    }
}
