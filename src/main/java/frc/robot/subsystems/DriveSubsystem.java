// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.MotorConstants.LEFT_MOTOR_FRONT_CANID);
  private WPI_TalonSRX leftCenter = new WPI_TalonSRX(Constants.MotorConstants.LEFT_MOTOR_CENTER_CANID);
  private WPI_TalonSRX leftRear = new WPI_TalonSRX(Constants.MotorConstants.LEFT_MOTOR_REAR_CANID);
  private WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.MotorConstants.RIGHT_MOTOR_FRONT_CANID);
  private WPI_TalonSRX rightCenter = new WPI_TalonSRX(Constants.MotorConstants.RIGHT_MOTOR_CENTER_CANID);
  private WPI_TalonSRX rightRear = new WPI_TalonSRX(Constants.MotorConstants.RIGHT_MOTOR_REAR_CANID);

  private DifferentialDrive drive;

  public DriveSubsystem() {

    configureMotors();

    driveTrainBrakeMode();

    drive = new DifferentialDrive(leftFront, rightFront);

  }

  private void configureMotors() {

    // reset all motors
    leftFront.configFactoryDefault();
    leftCenter.configFactoryDefault();
    leftRear.configFactoryDefault();
    rightFront.configFactoryDefault();
    rightCenter.configFactoryDefault();
    rightRear.configFactoryDefault();

    //setup left motors
    //lf
    leftFront.setInverted(Constants.OperatorConstants.LEFT_MOTOR_INVERSION);
    //lc
    leftCenter.follow(leftFront);
    leftCenter.setInverted(InvertType.FollowMaster);
    //lr
    leftRear.follow(leftFront);
    leftRear.setInverted(InvertType.FollowMaster);

    //setup right motors
    //rf
    rightFront.setInverted(Constants.OperatorConstants.RIGHT_MOTOR_INVERSION);
    //rc
    rightCenter.follow(rightFront);
    rightCenter.setInverted(InvertType.FollowMaster);
    //rr
    rightRear.follow(rightFront);
    rightRear.setInverted(InvertType.FollowMaster);
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

  public void manualDrive(double move, double turn) {

    drive.arcadeDrive(move, turn);

  }

  public void testLeftSide(double power) {
    leftFront.set(power);
  }

  public void testRightSide(double power) {
    rightFront.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
