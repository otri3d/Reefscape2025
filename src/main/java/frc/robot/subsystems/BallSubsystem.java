// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/* Subsystem for the algee  */
public class BallSubsystem extends SubsystemBase {
  // Define the motor that we will use for the claw
  private WPI_VictorSPX claw;

  /** Creates a new subsystem for the ball to use. */
  public BallSubsystem() {
    // Assign the port for the claw from the Constants.java file
    claw = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
  }

  // We invert the claw
  public void invertClaw() {
    if (claw.get() == 0.0) {
      claw.set(-1.0);
    }
    claw.setInverted(!claw.getInverted());
  }

  // This will stop the claw
  public void stopClaw() {
    claw.set(0.0);
  }
}
