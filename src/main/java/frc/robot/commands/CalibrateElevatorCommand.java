// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class CalibrateElevatorCommand extends Command {
  /** Creates a new CalibrateElevatorCommand. */
  public CalibrateElevatorCommand() {
    addRequirements(RobotContainer.elevatorSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.elevatorSubsystem.elevatorMoveWithPower(-0.4);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.elevatorSubsystem.elevatorMoveWithPower(0);
    RobotContainer.elevatorSubsystem.resetElevatorEncoder();
    System.out.println("Calibrate Elevator Command Ended:" + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return  (Math.abs(RobotContainer.elevatorSubsystem
    .getElevatorCurrentRecord()) > Constants.ElevatorConstants.stallCurrent) ;
  }
}
