package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// Default Arm Command, goes up and down, coral pickup and dropoff in a different func
public class StopArmCommand extends Command{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    // Variables
    private final ArmSubsystem m_subsystem;


    public StopArmCommand(ArmSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute(){
        m_subsystem.moveArm(0.0,0.0);
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
