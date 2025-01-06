package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;

/* Subsystem for the coral arm */
public class ArmSubsystem extends SubsystemBase {

  // Define the motors we will be using
  // and the solenoids that will be needed
  // Solenoids are apart of the pneumatic system
  private WPI_VictorSPX m_armMotor1;
  private WPI_VictorSPX m_armMotor2;
  private Solenoid m_solenoid1;
  private Solenoid m_solenoid2;

  // This will save the state if the claw is open or claw
  private boolean m_isOpen = false;

  // Create the arm subsystem when called in RobotContainer.java
  public ArmSubsystem() {
    // Assign the ports that the motors are assigned (CAN ID in our case) from the
    // Constants.java
    m_armMotor1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT5);
    m_armMotor2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT6);

    // Assign our solenoids the values they require
    m_solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.PNEUMATICPORT1);
    m_solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.PNEUMATICPORT2);

    // This will have the second motor follow the first
    // Ensuring that they will match each other and not compete on direction or
    // speed
    m_armMotor2.follow(m_armMotor1);

    // This will turn the solenoid on when we start
    m_solenoid2.set(true);
  }

  // Change Solenoid values to open the arm
  public void openArm() {
    m_solenoid1.set(!m_isOpen);
    m_solenoid2.set(m_isOpen);
  }

  // Change Solenoid values to close the arm
  public void closeArm() {
    m_solenoid1.set(m_isOpen);
    m_solenoid2.set(!m_isOpen);
  }

  // Move the arm up and down
  public void moveArm(double value) {
    m_armMotor1.set(value * DriveConstants.ARM_SPEED);
  }

  // Check if system is open
  public boolean isOpen() {
    return m_solenoid1.get();
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
