package frc.robot.commands;

import frc.robot.subsystems.PneumaticSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// Open Arm Command, goes up and down, coral pickup and dropoff in a different func
public class CloseArmCommand extends Command {

    // Variables
    private final PneumaticSubsystem m_subsystem;


    public CloseArmCommand(PneumaticSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Execute will run the code when the command is called
    // This closes the arm and stops the motor
    @Override
    public void execute() {
        m_subsystem.closeArm();
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
