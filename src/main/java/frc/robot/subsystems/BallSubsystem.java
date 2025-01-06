package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallSubsystem extends SubsystemBase {
  private WPI_VictorSPX claw;
  private double speedON = 1.0;

  /** Creates a new BallSubsystem. */

  public BallSubsystem() {
    claw = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
  }

  //sets the speed of the motor to the max
  public void claw() {
    claw.set(speedON);
  }

  //switches the direction of the motor, CW -> CCW or CCW -> CW
  public void invertClaw() {
    if(claw.get() == 0.0)
      claw();
    claw.setInverted(!claw.getInverted());
  }
}
