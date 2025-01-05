package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;


/* Subsystem for the coral arm*/
public class ArmSubsystem extends SubsystemBase{

    // Variables
    private WPI_VictorSPX m_armMotor1;
    private WPI_VictorSPX m_armMotor2;
    private Solenoid m_solenoid;

    //private DoubleSolenoid m_solenoid;

    //Public constructor
    public ArmSubsystem(){
        m_armMotor1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT5);
        m_armMotor2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT6);

        m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.SOLENOID);
        //m_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    }

    // Change Solenoid values to open/close arm 
    public void liftArm(){
        m_solenoid.set(true);
    }

    // Move the arm up and down
    public void moveArm(double speed){
        m_armMotor1.set(speed);
        m_armMotor2.set(speed);
    }

    //Check if system is open
    public boolean isOpen(){
        return m_solenoid.get();
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
