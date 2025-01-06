package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.RobotContainer;

// Default Drive Command via PlayStation 5 Controller
public class TankDriveCommand extends Command {
  // This references the DriveSubsystem.java to control the motors assigned
  private final DriveSubsystem m_subsystem;

  // Reference the controller in the RobotContainer.java file
  // This is what is used to get the values of speed
  private final CommandPS5Controller m_controller = RobotContainer.getDriverController();

  public TankDriveCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Execute will run the code when the command is called
  // This will set the speed of our drivetrain motors to move
  @Override
  public void execute() {
    m_subsystem.setLeftSpeed(-m_controller.getLeftY());
    m_subsystem.setRightSpeed(m_controller.getRightY());
  }

  // Called once finished
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
