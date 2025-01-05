// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallSubsystem extends SubsystemBase {
  private DoubleSolenoid arm;
  private WPI_VictorSPX ball1, ball2;
  private double speedON = 1.0;
  private double clawConstant = 0.4;

  /** Creates a new ExampleSubsystem. */

  public BallSubsystem() {
    ball1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
    ball2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT8);
    ball2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT9);
    ball2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT10);

    arm = new DoubleSolenoid(PneumaticsModuleType.REVPH,OperatorConstants.PNEUMATICPORT1,OperatorConstants.PNEUMATICPORT2);//Change the PORT once created
  }

  public void intake() {
    ball1.set(-speedON);
    ball2.set(speedON);
  }

  public void claw() {
    ball1.set(-speedON * clawConstant);
    ball2.set(speedON * clawConstant);
  }


  public void invertIntake() {
    if(ball1.get() == 0.0 || ball2.get() == 0.0)
      intake();
    ball1.setInverted(!ball1.getInverted());
    ball2.setInverted(!ball2.getInverted());
  }

  public void extendArm(){
    arm.set(Value.kForward);
  }

  public void retractArm(){
    arm.set(Value.kReverse);
  }

  public void toggleArm(){
    arm.toggle();
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
