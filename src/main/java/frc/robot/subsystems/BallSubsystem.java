// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallSubsystem extends SubsystemBase {
  private WPI_VictorSPX claw;

  /** Creates a new Ball. */

  public BallSubsystem() {
    claw = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
  }

  public void invertClaw() {
    if(claw.get() == 0.0){
      claw.set(-1.0);
    }
    claw.setInverted(!claw.getInverted());
  }
}
