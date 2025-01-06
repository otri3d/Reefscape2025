package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;


/* Subsystem for the coral arm*/
public class ArmSubsystem extends SubsystemBase{

    // Variables
    private WPI_VictorSPX m_armMotor1;
    private WPI_VictorSPX m_armMotor2;
    private WPI_VictorSPX m_armMotorU;
    private DoubleSolenoid m_solenoid;
    private boolean m_isOpen = false;

    //private DoubleSolenoid m_solenoid;

    //Public constructor
    public ArmSubsystem(){
        m_armMotor1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORTA1);
        m_armMotor2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORTA2);

        m_armMotorU = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORTA3);

        m_solenoid = new DoubleSolenoid(9, PneumaticsModuleType.CTREPCM, OperatorConstants.PNEUMATICPORT1, OperatorConstants.PNEUMATICPORT2);

        m_armMotor1.setInverted(true);
        m_armMotor2.follow(m_armMotor1);
    }

    // Change Solenoid values to open/close arm 
    public void openArm(){
        m_solenoid.set(Value.kForward);
        m_isOpen = true;
    }

    public void closeArm(){
        m_solenoid.set(Value.kReverse);
        m_isOpen = false;
    }

    // Move the arm up and down
    public void moveArm(double value, double value2){
      //Stop if at min/max location
        m_armMotor1.set(value*DriveConstants.ARM_SPEED);
        m_armMotorU.set(value2*DriveConstants.ARM_SPEED);
    }

    //Check if system is open
    public boolean isOpen(){
        return m_isOpen;
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
