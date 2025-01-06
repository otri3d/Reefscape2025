package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;

public class ClawSubsystem extends SubsystemBase{
    // Variables
    private WPI_VictorSPX m_armMotorU;
    private DoubleSolenoid m_solenoid;

    //private DoubleSolenoid m_solenoid;

    //Public constructor
    public ClawSubsystem(){
        m_armMotorU = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORTA3);

        m_solenoid = new DoubleSolenoid(9, PneumaticsModuleType.CTREPCM, OperatorConstants.PNEUMATICPORT1, OperatorConstants.PNEUMATICPORT2);
        m_solenoid.set(Value.kForward);
    }

    // Change Solenoid values to open/close arm 
    public void openArm(){
        m_solenoid.set(Value.kForward);
    }

    public void closeArm(){
        m_solenoid.set(Value.kReverse);
    }

    public void moveWrist(double value){
        m_armMotorU.set(value*DriveConstants.WRIST_SPEED);
    }
    
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
