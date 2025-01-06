package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;


/* Subsystem for the coral arm*/
public class ArmSubsystem extends SubsystemBase{

    // Variables
    private WPI_VictorSPX m_armMotor1;
    private WPI_VictorSPX m_armMotor2;

    //private DoubleSolenoid m_solenoid;

    //Public constructor
    public ArmSubsystem(){
        m_armMotor1 = new WPI_VictorSPX(OperatorConstants.ARM1);
        m_armMotor2 = new WPI_VictorSPX(OperatorConstants.ARM2);

        m_armMotor1.setInverted(true);
        m_armMotor2.follow(m_armMotor1);
    }

    // Move the arm up and down
    public void moveArm(double value){
      //Stop if at min/max location
        m_armMotor1.set(value*DriveConstants.ARM_SPEED);
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
