// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants.ControllerDevice;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ClawCloseCommand;
import frc.robot.commands.ClawOpenCommand;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommandSequence;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.IntakeStopCommand;
import frc.robot.commands.OuttakeCommandSequence;
import frc.robot.commands.RobotIntakeReverseCommand;
import frc.robot.commands.RotateIntakeCommand;
import frc.robot.commands.RotateIntakeStopCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
import frc.robot.subsystems.SmartDashboardSubsystem;

import java.util.function.DoubleSupplier;

//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

//TODO: Fix contant names for PID
//Fix keybinds according to guide [done!]
//TODO: Fix variable names according to Alex
//TODO: Polish Code

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public final static PneumaticSubsystem pneumaticSubsystem = new PneumaticSubsystem();
  public final static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final static SmartDashboardSubsystem smartDashboardSubsystem = new SmartDashboardSubsystem();
  public final static ArmSubsystem armSubsystem = new ArmSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(DriveConstants.DRIVER_CONTROLLER_PORT);

  public static Controller driveController;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureDriverInterface();
    configureBindings();
    //testClaw();
    //testIntake();
    //testRotator();
    driveSubsystem.setDefaultCommand(
      new DriveManuallyCommand(
        () -> getDriverXAxis(),
        () -> getDriverYAxis()));

    paradeCommandGroup();
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
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  private void configureDriverInterface() {
    driveController = new Controller(ControllerDevice.XBOX_CONTROLLER);
  }


  // look at me !! ->
  private void paradeCommandGroup() {
    // robot intake when lt button is pressed
    new JoystickButton(driveController, ControllerConstants.LTBUTTON)
      .onTrue(new IntakeCommandSequence());

    // robot outtake when rt button is pressed
    new JoystickButton(driveController, ControllerConstants.RTBUTTON)
      .onTrue(new OuttakeCommandSequence());

    //primal version of touch-sensitive thing
    new Trigger(() -> (driveController.getRawAxis(Constants.ControllerConstants.RBBUTTON) > 0.3))
      .onTrue(new RotateIntakeCommand())
      .onFalse(new RotateIntakeStopCommand());
    new Trigger(() -> (driveController.getRawAxis(Constants.ControllerConstants.LBBUTTON) > 0.3))
      .onTrue(new RobotIntakeReverseCommand())
      .onFalse(new RotateIntakeStopCommand());
    /*
    new Trigger(() -> (driveController.getRawAxis(Constants.ControllerConstants.RBBUTTON) > 0))
      .onTrue(new RotateIntakeCommand(  ()-> driveController.getRawAxis(Constants.ControllerConstants.RBBUTTON)));
    */
  }

  //test commands (ignore for parade lol)

/*
  private void testClaw() {
    new JoystickButton(driveController, 2)
      .onTrue(new ClawOpenCommand());
    new JoystickButton(driveController, 3)
      .onTrue(new ClawCloseCommand());
  }

  public void testIntake() {
    new JoystickButton(driveController, 1)
      .onTrue(new IntakeInCommand())
      .onFalse(new IntakeStopCommand());
    new JoystickButton(driveController, 4)
      .onTrue(new IntakeOutCommand())
      .onFalse(new IntakeStopCommand());
    new JoystickButton(driveController, 5)
      .onTrue(new RotateIntakeCommand())
      .onFalse(new IntakeStopCommand());
    new JoystickButton(driveController, 6)
      .onTrue(new RobotIntakeReverseCommand())
      .onFalse(new IntakeStopCommand());
  }

  public void testRotator() {
    new JoystickButton(driveController, 7)
      .onTrue(new InstantCommand(() -> RobotContainer.armSubsystem.tiltHoldPosition(1825)))
      .onFalse(new InstantCommand(() -> RobotContainer.armSubsystem.tiltMoveWithPower(0.0)));

    new JoystickButton(driveController, 8)
      .onTrue(new InstantCommand(() -> RobotContainer.armSubsystem.tiltHoldPosition(0)))
      .onFalse(new InstantCommand(() -> RobotContainer.armSubsystem.tiltMoveWithPower(0.0)));
  }
*/

  private double getDriverXAxis() {
    return driveController.getLeftStickY();
  }

  private double getDriverYAxis() {
    return driveController.getRightStickX();
  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
