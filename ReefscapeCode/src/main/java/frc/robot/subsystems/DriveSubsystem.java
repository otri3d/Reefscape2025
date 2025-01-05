package frc.robot.subsystems;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private WPI_VictorSPX m_left1, m_left2, m_right1, m_right2;
  private double m_speed1 = 0.0, m_speed2 = 0.0;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    m_left1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT3);
    m_left2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT2);
    m_right1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT1);
    m_right2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT4);
  }

  public void setLeftSpeed(double speed) {
    m_left1.set(speed);
    m_left2.set(speed);
  }

  public void setRightSpeed(double speed) {
    m_right1.set(speed);
    m_right2.set(speed);
    
  }
  public void setAcceleratingLeftMotors(double leftStickInput)
  {
    if(MathUtil.applyDeadband(leftStickInput,0.01 ) == 0) {m_speed1 = 0;}
    m_speed1 += leftStickInput*DriveConstants.ACCELERATION_CONSTANT;
    m_left1.set(MathUtil.clamp(m_speed1,-1.0,1.0)*-1);
    m_left2.set(MathUtil.clamp(m_speed1,-1.0,1.0)*-1);
   }
  public void setAcceleratingRightMotors(double rightStickInput)
  {  
    if(MathUtil.applyDeadband(rightStickInput,0.01 ) == 0) {m_speed2 = 0;}
    m_speed2 += rightStickInput*DriveConstants.ACCELERATION_CONSTANT;
    m_right1.set(MathUtil.clamp(m_speed2,-1.0,1.0));
    m_right2.set(MathUtil.clamp(m_speed2,-1.0,1.0));
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
