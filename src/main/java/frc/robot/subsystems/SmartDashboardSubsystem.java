// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class SmartDashboardSubsystem extends SubsystemBase {
  /** Creates a new SmartDashboardSubsystem. */
  public SmartDashboardSubsystem() {
  }

  public void updateEncoder() {
    SmartDashboard.putNumber("relative encoder value", RobotContainer.intakeSubsystem.getEncoder());
    SmartDashboard.putNumber("absolute encoder value", RobotContainer.armSubsystem.getTiltAbsoluteEncoder());
  }

  public void updateAllDisplays() {
    updateEncoder();
  }

  @Override
  public void periodic() {
    updateAllDisplays();
    SmartDashboard.putNumber("relative encoder value", RobotContainer.intakeSubsystem.getEncoder());
    SmartDashboard.putNumber("absolute encoder value", RobotContainer.armSubsystem.getTiltAbsoluteEncoder());
  }
}
