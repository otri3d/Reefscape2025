// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// Default
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;

//  Drive Subsystem
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

//  Arm Subsystem
import frc.robot.commands.DefaultArmCommand;
import frc.robot.commands.CloseArmCommand;
import frc.robot.commands.OpenArmCommand;
import frc.robot.commands.StopArmCommand;
import frc.robot.subsystems.ArmSubsystem;

//  Ball Mechanism
import frc.robot.commands.DefaultBallCommand;
import frc.robot.commands.StopBallCommand;
import frc.robot.subsystems.BallSubsystem;

//  Control System
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.Command;
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

    // Create the controllers
    private static CommandPS5Controller driver;
    private static CommandPS4Controller operator;

    // Triggers
    private Trigger crossTrigger;
    private Trigger squareTrigger;
    private Trigger circleTrigger;
    private Trigger triangleTrigger;
  
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {  
      // Assign the controllers to port number as stated in the Constants.java file
      driver = new CommandPS5Controller(OperatorConstants.DRIVERCONTROLLERPORT);
      operator = new CommandPS4Controller(OperatorConstants.OPERATORCONTROLLERPORT);

      //Triggers
      crossTrigger = operator.cross();
      squareTrigger = operator.square();
      circleTrigger = operator.circle();
      triangleTrigger = operator.triangle();

      // Configure the trigger bindings
      configureBindings();
  
      // The base command that is always running is the moving command
      CommandScheduler.getInstance().setDefaultCommand(m_driveSubsystem, new DefaultDriveCommand(m_driveSubsystem));
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
      // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
      new Trigger(m_driveSubsystem::exampleCondition)
          .onTrue(new DefaultDriveCommand(m_driveSubsystem));

      crossTrigger.whileTrue(new OpenArmCommand(m_armSubsystem));
      crossTrigger.whileFalse(new CloseArmCommand(m_armSubsystem));

      squareTrigger.whileTrue(new DefaultArmCommand(m_armSubsystem));
      squareTrigger.whileFalse(new StopArmCommand(m_armSubsystem));

      triangleTrigger.whileTrue(new DefaultBallCommand(m_ballSubsystem));

      circleTrigger.whileTrue(new StopBallCommand(m_ballSubsystem));
  
      // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
      // cancelling on release.
      //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    }
  
    // This returns the driver controller objects, allowing our commands to use them
    public static CommandPS5Controller getDriverController() {
      return driver;
    }

    // This returns the operator controller objects, allowing our commands to use them
    public static CommandPS4Controller getOperatorController() {
      return operator;
    }

    public Command getAutonomousCommand() {
      // An example command will be run in autonomous
      return Autos.exampleAuto(null);
    }
}
