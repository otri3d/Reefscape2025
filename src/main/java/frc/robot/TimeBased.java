// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class,
 * specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class TimeBased extends TimedRobot {
  private final DifferentialDrive m_robotDrive;

  private final WPI_VictorSPX m_leftMotor1 = new WPI_VictorSPX(9);
  private final WPI_VictorSPX m_leftMotor2 = new WPI_VictorSPX(1);
  private final WPI_VictorSPX m_rightMotor1 = new WPI_VictorSPX(3);
  private final WPI_VictorSPX m_rightMotor2 = new WPI_VictorSPX(4);

  private final WPI_VictorSPX m_intake = new WPI_VictorSPX(6);

  private final WPI_VictorSPX m_rotateLowerLeft = new WPI_VictorSPX(8);
  private final WPI_VictorSPX m_rotateLowerRight = new WPI_VictorSPX(10);

  private final WPI_VictorSPX m_rorateUpeer = new WPI_VictorSPX(2);

  private final DoubleSolenoid m_ClawSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  private final PS5Controller m_DriverController;
  private final PS4Controller m_OperatorController;

  /** Called once at the beginning of the robot program. */
  public TimeBased() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_ClawSolenoid.set(Value.kForward);
    m_OperatorController = new PS4Controller(1);
    m_DriverController = new PS5Controller(0);

    m_leftMotor2.follow(m_leftMotor1);
    m_rightMotor2.follow(m_rightMotor1);

    m_rotateLowerLeft.follow(m_rotateLowerRight);
    m_rotateLowerLeft.setInverted(true);

    m_robotDrive = new DifferentialDrive(m_leftMotor1::set, m_rightMotor1::set);
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.tankDrive(-m_DriverController.getLeftY(), -m_DriverController.getRightY());

    m_rotateLowerLeft.set(m_OperatorController.getLeftY());
    m_rorateUpeer.set(m_OperatorController.getRightY() * 0.4);

    if (m_OperatorController.getL2ButtonPressed()) {
      m_intake.set(0.8);
    }
    if (m_OperatorController.getR2ButtonPressed()) {
      m_intake.set(-0.8);
    }
    if (m_OperatorController.getR2Button() == m_OperatorController.getL2Button()) {
      m_intake.set(0);
    }

    if (m_OperatorController.getR1ButtonPressed()) {
      if (m_ClawSolenoid.get() == Value.kForward) {
        m_ClawSolenoid.set(Value.kReverse);
      } else {
        m_ClawSolenoid.set(Value.kForward);
      }
    }
  }
}
