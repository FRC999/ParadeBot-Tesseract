// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(Constants.ElevatorConstants.ELEVATORCANID);

  public ElevatorSubsystem() {
    configureElevatorMotor();
  }

  public void configureElevatorMotor() {
    elevatorMotor.configFactoryDefault();

    elevatorMotor.setInverted(ElevatorConstants.elevatorMotorInvert);

    elevatorMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute,
        ElevatorConstants.PID_ELEVATOR,
        ElevatorConstants.configureTimeoutMs);

    elevatorMotor.setSensorPhase(ElevatorConstants.elevatorEncoderSensorPhase);

    elevatorMotor.configPeakOutputForward(ElevatorConstants.PeakOutput,
        Constants.ElevatorConstants.configureTimeoutMs);
    elevatorMotor.configPeakOutputReverse(ElevatorConstants.PeakOutput * (-1),
        Constants.ElevatorConstants.configureTimeoutMs);
    elevatorMotor.configNominalOutputForward(0, ElevatorConstants.configureTimeoutMs);
    elevatorMotor.configNominalOutputReverse(0, ElevatorConstants.configureTimeoutMs);

    elevatorMotor.configAllowableClosedloopError(ElevatorConstants.SLOT_0,
        ElevatorConstants.elevatorDefaultAcceptableError,
        ElevatorConstants.configureTimeoutMs);

    elevatorMotor.config_kP(ElevatorConstants.SLOT_0, ElevatorConstants.P_ELEVATOR,
        ElevatorConstants.configureTimeoutMs);
    elevatorMotor.config_kI(Constants.ElevatorConstants.SLOT_0, ElevatorConstants.I_ELEVATOR,
        ElevatorConstants.configureTimeoutMs);
    elevatorMotor.config_kD(ElevatorConstants.SLOT_0, ElevatorConstants.D_ELEVATOR,
        ElevatorConstants.configureTimeoutMs);
    elevatorMotor.config_kF(ElevatorConstants.SLOT_0, ElevatorConstants.F_ELEVATOR,
        ElevatorConstants.configureTimeoutMs);

    // elevatorMotor.setSelectedSensorPosition((getTiltAbsoluteEncoder()-Constants.ElevatorConstants.absoluteEncoderZeroValue));
  }

  
  public int getElevatorRelativeEncoder() {
   return (int) elevatorMotor.getSelectedSensorPosition();
  }
   
  public int getElevatorAbsoluteEncoder() {
   return (int) elevatorMotor.getSensorCollection().getPulseWidthPosition() &
   0xFFF;
  }
   
  public void elevatorMoveWithPower(double power) {
   elevatorMotor.set(TalonSRXControlMode.PercentOutput, power);
  }
   
  public void elevatorHoldPosition(int position) {
   elevatorMotor.set(TalonSRXControlMode.Position, position);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
