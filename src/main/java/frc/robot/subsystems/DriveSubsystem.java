// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.MotorConstants.LEFTFRONT);
  private WPI_TalonSRX leftCenter = new WPI_TalonSRX(Constants.MotorConstants.LEFTCENTER);
  private WPI_TalonSRX leftRear = new WPI_TalonSRX(Constants.MotorConstants.LEFTREAR);
  private WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.MotorConstants.RIGHTFRONT);
  private WPI_TalonSRX rightCenter = new WPI_TalonSRX(Constants.MotorConstants.RIGHTCENTER);
  private WPI_TalonSRX rightRear = new WPI_TalonSRX(Constants.MotorConstants.RIGHTREAR);

  private DifferentialDrive drive;

  public DriveSubsystem() {

    driveTrainBrakeMode();

  }

  private void driveTrainBrakeMode() {
      //_this will make the robot brake when no command is given. !!very important!!
      leftFront.setNeutralMode(NeutralMode.Brake);
      leftCenter.setNeutralMode(NeutralMode.Brake);
      leftRear.setNeutralMode(NeutralMode.Brake);
      rightFront.setNeutralMode(NeutralMode.Brake);
      rightCenter.setNeutralMode(NeutralMode.Brake);
      rightRear.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
