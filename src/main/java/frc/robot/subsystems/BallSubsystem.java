// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallSubsystem extends SubsystemBase {
  private WPI_VictorSPX claw1;
  private double speedON = 1.0;

  /** Creates a new Ball. */

  public BallSubsystem() {
    claw1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
  }

  public void claw() {
    claw1.set(speedON);
  }

  public void invertClaw() {
    if(claw1.get() == 0.0)
      claw();
    claw1.setInverted(!claw1.getInverted());
  }
}
