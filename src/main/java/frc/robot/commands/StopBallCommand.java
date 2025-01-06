// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.BallSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// Command to make the ball subsystem stationairy
public class StopBallCommand extends Command {
  
  // Reference the ball subsystem which will be used
  private final BallSubsystem m_subsystem;

  public StopBallCommand(BallSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Execute will run the code when the command is called
  // In this case we will stop the moving the claw motors
  @Override
  public void execute() {
    m_subsystem.stopClaw();
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
