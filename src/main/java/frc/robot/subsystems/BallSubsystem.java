// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallSubsystem extends SubsystemBase {
  // Define the motors we will be using
  private WPI_VictorSPX claw1;

  private double speedON = 1.0;

  /** Subsystem for the big balls. */

  public BallSubsystem() {
    // Set the motor to the port as specified in the Constants.java file
    claw1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
  }

  // Move the claw
  public void claw() {
    claw1.set(speedON);
  }

  public void invertClaw() {
    if (claw1.get() == 0.0)
      claw();
    claw1.setInverted(!claw1.getInverted());
  }
}
