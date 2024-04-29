// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private WPI_TalonSRX leftIntake = new WPI_TalonSRX(Constants.IntakeConstants.LEFT_INTAKE_MOTOR_CANID);
  private WPI_TalonSRX rightIntake = new WPI_TalonSRX(Constants.IntakeConstants.RIGHT_INTAKE_MOTOR_CANID);
  private WPI_TalonSRX intakeRotator = new WPI_TalonSRX(Constants.IntakeConstants.INTAKE_ROTATOR_MOTOR_CANID);

  public IntakeSubsystem() {
    configureMotors();
    driveTrainBrakeMode();
  }

  public int getEncoder() {
    int encoderValue = (int) intakeRotator.getSelectedSensorPosition();
    System.out.println("********######*********ENCODER VALUE:" + encoderValue);
    return encoderValue;
  }

  private void configureMotors() {

    // reset all motors
    leftIntake.configFactoryDefault();
    rightIntake.configFactoryDefault();
    intakeRotator.configFactoryDefault();

    leftIntake.setInverted(false);
    rightIntake.setInverted(true);
    rightIntake.follow(leftIntake);

  }

  public void driveTrainBrakeMode() {
    leftIntake.setNeutralMode(NeutralMode.Brake);
    rightIntake.setNeutralMode(NeutralMode.Brake);
    intakeRotator.setNeutralMode(NeutralMode.Brake);
  }

  public void intakeSpeed(double power) {
    leftIntake.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
