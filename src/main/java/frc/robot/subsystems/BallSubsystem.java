// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallSubsystem extends SubsystemBase {
  private WPI_VictorSPX ball1, ball2, claw1, claw2;
  private double speedON = 1.0;
  private double clawConstant = 0.4;

  /** Creates a new ExampleSubsystem. */

  public BallSubsystem() {
    ball1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
    ball2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT8);
    claw1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT9);
    claw2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT10);
  }

  public void intake() {
    ball1.set(-speedON);
    ball2.set(speedON);
  }

  public void claw() {
    claw1.set(-speedON * clawConstant);
    claw2.set(speedON * clawConstant);
  }

  public void invertClaw() {
    if(claw1.get() == 0.0 || claw2.get() == 0.0)
      claw();
    claw1.setInverted(!claw1.getInverted());
    claw2.setInverted(!claw2.getInverted());
  }


  public void invertIntake() {
    if(ball1.get() == 0.0 || ball2.get() == 0.0)
      intake();
    ball1.setInverted(!ball1.getInverted());
    ball2.setInverted(!ball2.getInverted());
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
