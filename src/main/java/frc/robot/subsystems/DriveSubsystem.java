package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;

/* Subsystem to make the robot go vroom */
public class DriveSubsystem extends SubsystemBase {
  // These are the motors we will be using
  private WPI_VictorSPX m_left1, m_left2, m_right1, m_right2;

  // These are the speed values that will be used
  private double m_speed1 = 0.0, m_speed2 = 0.0;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // Create the motors with the assigned port that we listed in the constants file
    m_left1 = new WPI_VictorSPX(OperatorConstants.DRIVEL1);
    m_left2 = new WPI_VictorSPX(OperatorConstants.DRIVEL2);
    m_right1 = new WPI_VictorSPX(OperatorConstants.DRIVER1);
    m_right2 = new WPI_VictorSPX(OperatorConstants.DRIVER2);

    // This will ensure that the motors on the same side share power output
    // Prevents the possibility that programmers forget to power both sides
    m_left2.follow(m_left1);
    m_right2.follow(m_right1);
  }

  // Set the speed of the left side of the tank drive
  public void setLeftSpeed(double speed) {
    m_left1.set(speed);
  }

  // Set the speed of the right side of the tank drive
  public void setRightSpeed(double speed) {
    m_right1.set(speed);
  }

  // Once the left trigger changes values we acclerate
  // This will go faster or slower depending on how much we push
  public void setAcceleratingLeftMotors(double leftStickInput) {
    if (MathUtil.applyDeadband(leftStickInput, 0.01) == 0) {
      m_speed1 = 0;
    }
    m_speed1 += leftStickInput * DriveConstants.ACCELERATION_CONSTANT;
    System.out.println(m_speed1);
    m_left1.set(MathUtil.clamp(m_speed1, -1.0, 1.0) * -1);
  }

  // Once the right trigger changes values we acclerate
  // This will go faster or slower depending on how much we push
  public void setAcceleratingRightMotors(double rightStickInput) {
    if (MathUtil.applyDeadband(rightStickInput, 0.01) == 0) {
      m_speed2 = 0;
    }
    m_speed2 += rightStickInput * DriveConstants.ACCELERATION_CONSTANT;
    System.out.println(m_speed2);
    m_right1.set(MathUtil.clamp(m_speed2, -1.0, 1.0));
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
