// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeTakeCubeJoystickPower extends Command {
  /** Creates a new RotateDynamicForward. */
  private DoubleSupplier xAxis;

  public IntakeTakeCubeJoystickPower(DoubleSupplier x) {
    addRequirements(RobotContainer.intakeSubsystem);
    xAxis = x;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.intakeSubsystem.setIntakePower(-(xAxis.getAsDouble()/2));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.intakeSubsystem.setIntakePower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(RobotContainer.driveController.getRawAxis(Constants.ControllerConstants.LBBUTTON) < 0.1) {
      return true;
    }
    return false;
  }
}
