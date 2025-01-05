// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.BallSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class DefaultBallCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final BallSubsystem m_subsystem;
  private final CommandPS4Controller m_controller = RobotContainer.getOperatorController();

  /**
   * Creates a new DefaultBallCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public DefaultBallCommand(BallSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_controller.square().getAsBoolean()){
      m_subsystem.invertIntake();
    }
    
    if(m_controller.triangle().getAsBoolean()){
      m_subsystem.invertClaw();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}