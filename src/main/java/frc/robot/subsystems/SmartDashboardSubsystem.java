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

  public void updateElevatorTelemetry() {
    SmartDashboard.putNumber("Elevator relative encoder value", RobotContainer.elevatorSubsystem.getElevatorRelativeEncoder());
    SmartDashboard.putNumber("Elevator absolute encoder value", RobotContainer.elevatorSubsystem.getElevatorAbsoluteEncoder());
    SmartDashboard.putNumber("Elevator Motor  Current Record", RobotContainer.elevatorSubsystem.getElevatorCurrentRecord());
  }

  public void updateArmTelemetry() {
    SmartDashboard.putNumber("Arm relative encoder value", RobotContainer.armSubsystem.getAngleRelativeEncoder());
    SmartDashboard.putNumber("Arm absolute encoder value", RobotContainer.armSubsystem.getAngleAbsoluteEncoder());
  }

  public void updateIntakeTelemetry() {
    SmartDashboard.putNumber("Intake Left encoder value", RobotContainer.intakeSubsystem.getLeftEncoderValue());
    SmartDashboard.putNumber("Intake Right encoder value", RobotContainer.intakeSubsystem.getRightEncoderValue());
  }

  public void updateAllDisplays() {
    updateArmTelemetry();
    updateElevatorTelemetry();
  }

  @Override
  public void periodic() {
    updateAllDisplays();
   }
}
