// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private WPI_TalonSRX intakeRotator = new WPI_TalonSRX(Constants.IntakeConstants.INTAKE_ROTATOR_MOTOR_CANID);

  public ArmSubsystem() {
    configureRotatorMotor();
  }


  public void configureRotatorMotor() {
    intakeRotator.configFactoryDefault();


        intakeRotator.setInverted(Constants.ShooterConstants.tiltMotorInvert);


        intakeRotator.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute,
            Constants.ShooterConstants.PID_TILT,
            Constants.ShooterConstants.configureTimeoutMs);


        intakeRotator.setSensorPhase(Constants.ShooterConstants.tiltEncoderSensorPhase);


        intakeRotator.configPeakOutputForward(Constants.ShooterConstants.PeakOutput,
            Constants.ShooterConstants.configureTimeoutMs);
        intakeRotator.configPeakOutputReverse(Constants.ShooterConstants.PeakOutput * (-1),
            Constants.ShooterConstants.configureTimeoutMs);
        intakeRotator.configNominalOutputForward(0, Constants.ShooterConstants.configureTimeoutMs);
        intakeRotator.configNominalOutputReverse(0, Constants.ShooterConstants.configureTimeoutMs);


        intakeRotator.configAllowableClosedloopError(Constants.ShooterConstants.SLOT_0,
            Constants.ShooterConstants.tiltDefaultAcceptableError,
            Constants.ShooterConstants.configureTimeoutMs);


        intakeRotator.config_kP(Constants.ShooterConstants.SLOT_0, Constants.ShooterConstants.P_TILT,
            Constants.ShooterConstants.configureTimeoutMs);
        intakeRotator.config_kI(Constants.ShooterConstants.SLOT_0, Constants.ShooterConstants.I_TILT,
            Constants.ShooterConstants.configureTimeoutMs);
        intakeRotator.config_kD(Constants.ShooterConstants.SLOT_0, Constants.ShooterConstants.D_TILT,
            Constants.ShooterConstants.configureTimeoutMs);
        intakeRotator.config_kF(Constants.ShooterConstants.SLOT_0, Constants.ShooterConstants.F_TILT,
            Constants.ShooterConstants.configureTimeoutMs);


        intakeRotator.setSelectedSensorPosition((getTiltAbsoluteEncoder()-Constants.ShooterConstants.absoluteEncoderZeroValue));
  }

  public int getTiltRelativeEncoder() {
    return (int) intakeRotator.getSelectedSensorPosition();
  }

  public int getTiltAbsoluteEncoder() {
    return (int) intakeRotator.getSensorCollection().getPulseWidthPosition() & 0xFFF;
  }

  public void tiltMoveWithPower(double power) {
    intakeRotator.set(TalonSRXControlMode.PercentOutput, power);
  }

  public void tiltHoldPosition(int position) {
    intakeRotator.set(TalonSRXControlMode.Position, position);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}



