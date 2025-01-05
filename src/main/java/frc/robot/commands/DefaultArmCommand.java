package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.RobotContainer;

// Default Arm Command, goes up and down, coral pickup and dropoff in a different func
public class DefaultArmCommand extends Command{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    // Variables
    private final ArmSubsystem m_subsystem;
    private final CommandPS4Controller m_controller = RobotContainer.getOperatorController();
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
        // Open arm
        if (m_controller.cross().getAsBoolean()){
            if (isArmOpened){
                isArmOpened = false;
            } else {
                isArmOpened = true;
            }
            m_subsystem.openArm(isArmOpened);
        }

        if (m_controller.L1().getAsBoolean()){
            m_subsystem.moveArm(-0.4);
        }

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
