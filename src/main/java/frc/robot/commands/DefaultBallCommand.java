// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.BallSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;

/** This is the default command for the ball subsystem */
public class DefaultBallCommand extends Command {
  // Reference the ball subsystem which we will be using
  private final BallSubsystem m_subsystem;

  // These are used for saving the invert state and invert timer
  private boolean inv = false;
  private double invTime = 0;

  public DefaultBallCommand(BallSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Execute will run the code when the command is called
  // In this case checks when to invert the ball subsystem
  @Override
  public void execute() {
    if (!inv) {
      inv = true;
      invTime = Timer.getFPGATimestamp();
      m_subsystem.invertClaw();
    }
    if (inv && Timer.getFPGATimestamp() - invTime >= 0.2) {
      inv = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
