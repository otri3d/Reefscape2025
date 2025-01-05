package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.RobotContainer;

// Default Arm Command, goes up and down, coral pickup and dropoff in a different func
public class DefaultArmCommand extends Command{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    // Reference the arm subsystem and controller
    private final ArmSubsystem m_subsystem;
    private final CommandPS4Controller m_controller = RobotContainer.getOperatorController();

    // This is to save the state of the arms current position
    private boolean isArmOpened = false;

    public DefaultArmCommand(ArmSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute(){
        // Open or close the arm based on the state
        if (m_controller.cross().getAsBoolean()){
            if (isArmOpened){
                isArmOpened = false;
            } else {
                isArmOpened = true;
            }
            m_subsystem.openArm(isArmOpened);
        }

        // If L1 is pressed move the arm at 40% speed
        if (m_controller.L1().getAsBoolean()){
            m_subsystem.moveArm(-0.4);
        }

        // If R1 is pressed move the arm at 40% speed in the other direction
        if (m_controller.R1().getAsBoolean()){
            m_subsystem.moveArm(0.4);
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
