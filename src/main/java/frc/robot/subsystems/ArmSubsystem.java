package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.OperatorConstants;

/* Subsystem for the coral arm*/
public class ArmSubsystem extends SubsystemBase {

  // The motors used in the arm subsystem
  private WPI_VictorSPX m_armMotor1;
  private WPI_VictorSPX m_armMotor2;

  // These are our 2 solenoids tht are in the pneumatics
  private Solenoid m_solenoid1;
  private Solenoid m_solenoid2;

  // private DoubleSolenoid m_solenoid;

  // Constructor of the subsystem
  public ArmSubsystem() {
    // Define the motors to the ports that are listed in the Constants.java file
    m_armMotor1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT5);
    m_armMotor2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT6);

    // Define the solenoids to the ports that are listed in the Constants.java file
    m_solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.PNEUMATICPORT1);
    m_solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.PNEUMATICPORT2);

    // Make second motor follow the first
    // This ensures that they are the same speed
    m_armMotor2.follow(m_armMotor1);
  }

  // Change Solenoid values to open/close arm
  public void openArm(boolean value) {
    m_solenoid1.set(value);
    m_solenoid2.set(!value);
  }

  // Move the arm up and down
  public void moveArm(double speedConst) {
    m_armMotor1.set(speedConst);
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
