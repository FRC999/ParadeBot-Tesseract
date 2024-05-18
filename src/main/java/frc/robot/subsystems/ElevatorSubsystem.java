// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(Constants.ElevatorConstants.ELEVATORCANID);

  public ElevatorSubsystem() {
    configureElevatorMotor();
  }


  public void configureElevatorMotor() {
    elevatorMotor.configFactoryDefault();


        elevatorMotor.setInverted(Constants.ElevatorConstants.tiltMotorInvert);


        elevatorMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute,
            Constants.ElevatorConstants.PID_TILT,
            Constants.ElevatorConstants.configureTimeoutMs);


        elevatorMotor.setSensorPhase(Constants.ElevatorConstants.tiltEncoderSensorPhase);


        elevatorMotor.configPeakOutputForward(Constants.ElevatorConstants.PeakOutput,
            Constants.ElevatorConstants.configureTimeoutMs);
        elevatorMotor.configPeakOutputReverse(Constants.ElevatorConstants.PeakOutput * (-1),
            Constants.ElevatorConstants.configureTimeoutMs);
        elevatorMotor.configNominalOutputForward(0, Constants.ElevatorConstants.configureTimeoutMs);
        elevatorMotor.configNominalOutputReverse(0, Constants.ElevatorConstants.configureTimeoutMs);


        elevatorMotor.configAllowableClosedloopError(Constants.ElevatorConstants.SLOT_0,
            Constants.ElevatorConstants.tiltDefaultAcceptableError,
            Constants.ElevatorConstants.configureTimeoutMs);


        elevatorMotor.config_kP(Constants.ElevatorConstants.SLOT_0, Constants.ElevatorConstants.P_TILT,
            Constants.ElevatorConstants.configureTimeoutMs);
        elevatorMotor.config_kI(Constants.ElevatorConstants.SLOT_0, Constants.ElevatorConstants.I_TILT,
            Constants.ElevatorConstants.configureTimeoutMs);
        elevatorMotor.config_kD(Constants.ElevatorConstants.SLOT_0, Constants.ElevatorConstants.D_TILT,
            Constants.ElevatorConstants.configureTimeoutMs);
        elevatorMotor.config_kF(Constants.ElevatorConstants.SLOT_0, Constants.ElevatorConstants.F_TILT,
            Constants.ElevatorConstants.configureTimeoutMs);


      //  elevatorMotor.setSelectedSensorPosition((getTiltAbsoluteEncoder()-Constants.ElevatorConstants.absoluteEncoderZeroValue));
  }
  /* 
  public int getTiltRelativeEncoder() {
    return (int) elevatorMotor.getSelectedSensorPosition();
  }

  public int getTiltAbsoluteEncoder() {
    return (int) elevatorMotor.getSensorCollection().getPulseWidthPosition() & 0xFFF;
  }

  public void tiltMoveWithPower(double power) {
    elevatorMotor.set(TalonSRXControlMode.PercentOutput, power);
  }

  public void tiltHoldPosition(int position) {
    elevatorMotor.set(TalonSRXControlMode.Position, position);
  }
*/
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}



