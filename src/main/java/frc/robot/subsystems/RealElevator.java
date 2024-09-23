package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RealElevator extends SubsystemBase {

  private final CANSparkMax motor;
  private final double gearing = 4d * 4 * 3 * 40 / 30;
  private final double drumRadius = Units.inchesToMeters(1.0);
  private final double factor = 2 * Math.PI * drumRadius / gearing;
  private final ElevatorFeedforward feedforward;

  public RealElevator(int deviceId) {
    motor = new CANSparkMax(deviceId, MotorType.kBrushless);
    motor.getEncoder().setPositionConversionFactor(factor);
    motor.getEncoder().setVelocityConversionFactor(factor / 60.0);
    motor.getEncoder().setAverageDepth(2);
    motor.getEncoder().setMeasurementPeriod(16);
    feedforward = new ElevatorFeedforward(0, 0, 0, 0);


  } 


  @Override
  public void periodic() {

  }
}