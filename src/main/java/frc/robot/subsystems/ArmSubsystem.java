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
private WPI_TalonSRX armMotor = new WPI_TalonSRX(Constants.ArmConstants.ARM_MOTOR_CANID);

double relativePosition = getAngleRelativeEncoder() - Constants.ArmConstants.absoluteEncoderZeroValue;

  public ArmSubsystem() {
    configureArmMotor();
  }


  public void configureArmMotor() {
    armMotor.configFactoryDefault();


        armMotor.setInverted(Constants.ArmConstants.armMotorInvert);


        armMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute,
            Constants.ArmConstants.PID_ARM,
            Constants.ArmConstants.configureTimeoutMs);


        armMotor.setSensorPhase(Constants.ArmConstants.armEncoderSensorPhase);


        armMotor.configPeakOutputForward(Constants.ArmConstants.PeakOutput,
            Constants.ArmConstants.configureTimeoutMs);
        armMotor.configPeakOutputReverse(Constants.ArmConstants.PeakOutput * (-1),
            Constants.ArmConstants.configureTimeoutMs);
        armMotor.configNominalOutputForward(0, Constants.ArmConstants.configureTimeoutMs);
        armMotor.configNominalOutputReverse(0, Constants.ArmConstants.configureTimeoutMs);


        armMotor.configAllowableClosedloopError(Constants.ArmConstants.SLOT_0,
            Constants.ArmConstants.armDefaultAcceptableError,
            Constants.ArmConstants.configureTimeoutMs);


        armMotor.config_kP(Constants.ArmConstants.SLOT_0, Constants.ArmConstants.P_ARM,
            Constants.ArmConstants.configureTimeoutMs);
        armMotor.config_kI(Constants.ArmConstants.SLOT_0, Constants.ArmConstants.I_ARM,
            Constants.ArmConstants.configureTimeoutMs);
        armMotor.config_kD(Constants.ArmConstants.SLOT_0, Constants.ArmConstants.D_ARM,
            Constants.ArmConstants.configureTimeoutMs);
        armMotor.config_kF(Constants.ArmConstants.SLOT_0, Constants.ArmConstants.F_ARM,
            Constants.ArmConstants.configureTimeoutMs);


        armMotor.setSelectedSensorPosition((getAngleAbsoluteEncoder()-Constants.ArmConstants.absoluteEncoderZeroValue));
  }

  public int getAngleRelativeEncoder() {
   // return (int) armMotor.getSelectedSensorPosition();
    return (int) armMotor.getSensorCollection().getPulseWidthPosition() & 0xFFF;
  }

  public void calibrateRelativeEncoder() {
    relativePosition = (Constants.ArmConstants.armMotorInvert^Constants.ArmConstants.armEncoderSensorPhase)?-relativePosition:relativePosition; 
    armMotor.setSelectedSensorPosition(relativePosition);
    System.out.println("*** Set relative encoder for Arm motor to " + relativePosition);
   }
  

  public double getAngleAbsoluteEncoder() {
    return relativePosition;
  }

  public void armMoveWithPower(double power) {
    armMotor.set(TalonSRXControlMode.PercentOutput, power);
  }

  public void holdArmAnglePosition(int position) {
    //armMotor.set(TalonSRXControlMode.Position, position);
    armMotor.set(TalonSRXControlMode.PercentOutput, Constants.ArmConstants.armHoldingPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}



