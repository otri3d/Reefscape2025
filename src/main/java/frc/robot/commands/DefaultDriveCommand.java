package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.RobotContainer;

//Default Drive Command via PlayStation 5 Controller
public class DefaultDriveCommand extends Command {
  // This references the DriveSubsystem.java to control the motors assigned
  private final DriveSubsystem m_subsystem;

  // Reference the controller in the RobotContainer.java file
  // This is what is used to get the values of speed
  private final CommandPS5Controller m_controller = RobotContainer.getDriverController();

  private boolean modeSwitch = false;

  public DefaultDriveCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Check the state for use of  modeSwitch
    if (m_controller.cross().getAsBoolean()) {
      modeSwitch = !modeSwitch;
    }

    // Once we checked the state, we now move robot based on it
    if (!modeSwitch) {
      m_subsystem.setLeftSpeed(-m_controller.getLeftY());
      m_subsystem.setRightSpeed(m_controller.getRightY());
    } else {
      m_subsystem.setAcceleratingLeftMotors(-1 * (m_controller.getLeftY() + m_controller.getLeftX()));
      m_subsystem.setAcceleratingRightMotors(-1 * (m_controller.getLeftY() - m_controller.getLeftX()));
    }
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
