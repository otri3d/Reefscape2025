// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// Default
import frc.robot.Constants.OperatorConstants;

//  Drive Subsystem
import frc.robot.commands.TankDriveCommand;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

//  Arm Subsystem
import frc.robot.commands.MoveArmCommand;
import frc.robot.commands.CloseArmCommand;
import frc.robot.commands.OpenArmCommand;
import frc.robot.commands.StopArmCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClawSubsystem;

//  Ball Mechanism
import frc.robot.commands.DefaultBallCommand;
import frc.robot.commands.StopBallCommand;
import frc.robot.subsystems.BallSubsystem;

//  Control System
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here
    public final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
    public final ArmSubsystem m_armSubsystem = new ArmSubsystem();
    public final BallSubsystem m_ballSubsystem = new BallSubsystem();
    public final ClawSubsystem m_clawSubsystem = new ClawSubsystem();

    // Create the controllers
    private static CommandPS5Controller driver;
    private static CommandPS4Controller operator;

    // Triggers
    private Trigger crossTankTrigger;
    private Trigger circleArcadeTrigger;
    private Trigger crossTrigger;
    private Trigger squareTrigger;
    private Trigger circleTrigger;
    private Trigger triangleTrigger;
    private Trigger l1Trigger;
  
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {  
      // Assign the controllers to port number as stated in the Constants.java file
      driver = new CommandPS5Controller(OperatorConstants.DRIVERCONTROLLERPORT);
      operator = new CommandPS4Controller(OperatorConstants.OPERATORCONTROLLERPORT);

      //Triggers
      crossTankTrigger = driver.cross();
      circleArcadeTrigger = driver.circle();

      crossTrigger = operator.cross();
      squareTrigger = operator.square();
      circleTrigger = operator.circle();
      triangleTrigger = operator.triangle();
      l1Trigger = operator.L1();

      // Configure the trigger bindings
      configureBindings();
  
      // The base command that is always running is the moving command
      // Default is Tank
      CommandScheduler.getInstance().setDefaultCommand(m_driveSubsystem, new TankDriveCommand(m_driveSubsystem));
    }
  
    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
     * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
      // Button bindings for commands

      crossTankTrigger.onTrue(new TankDriveCommand(m_driveSubsystem));
      circleArcadeTrigger.onTrue(new ArcadeDriveCommand(m_driveSubsystem));
      
      crossTrigger.whileTrue(new OpenArmCommand(m_clawSubsystem));
      crossTrigger.whileFalse(new CloseArmCommand(m_clawSubsystem));

      squareTrigger.whileTrue(new MoveArmCommand(m_armSubsystem));
      squareTrigger.whileFalse(new StopArmCommand(m_armSubsystem));

      l1Trigger.whileTrue(new DefaultBallCommand(m_ballSubsystem));
      l1Trigger.whileFalse(new MoveArmCommand(m_armSubsystem));

      triangleTrigger.whileTrue(new DefaultBallCommand(m_ballSubsystem));

      circleTrigger.whileTrue(new StopBallCommand(m_ballSubsystem));
    }
  
    // This returns the driver controller objects, allowing our commands to use them
    public static CommandPS5Controller getDriverController() {
      return driver;
    }

    // This returns the operator controller objects, allowing our commands to use them
    public static CommandPS4Controller getOperatorController() {
      return operator;
    }
}
