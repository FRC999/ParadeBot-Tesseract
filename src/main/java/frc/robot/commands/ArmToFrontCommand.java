// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ArmToFrontCommand extends Command {
  /** Creates a new ArmToFrontCommand. */
  private double tolerance = 100;
  public ArmToFrontCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.armSubsystem.holdArmAnglePosition(Constants.ArmConstants.armFrontPosition);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ArmToFrontCommand finished: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(RobotContainer.armSubsystem.getAngleRelativeEncoder()-Constants.ArmConstants.armFrontPosition)<=tolerance;
  }
}
