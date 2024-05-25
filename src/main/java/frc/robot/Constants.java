// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static class IntakeConstants {
		public static final int LEFT_INTAKE_MOTOR_CANID = 10;
		public static final int RIGHT_INTAKE_MOTOR_CANID = 12;
		// public static final int INTAKE_ROTATOR_MOTOR_CANID = 11;
		public static final double INTAKE_SPEED = 0.4;
	}

	public static class ArmConstants {
		public static final int ARM_MOTOR_CANID = 11;	//this will be the motor that controls the angular component of the GPM [changes the angle of the arm]

		public static final boolean armMotorInvert = true;	//anything that will control the arm angular changes
		public static final int PID_ARM = 0;
		public static final int configureTimeoutMs = 30;
		public static final boolean armEncoderSensorPhase = true;
		public static final double PeakOutput = 0.4;
		public static final int armDefaultAcceptableError = 1;
		public static final int SLOT_0 = 0;
		public static final double P_ARM = 0.8;
		public static final double I_ARM = 0.0002;
		public static final double D_ARM = 0.8;
		public final static double F_ARM = 0;
		public final static int absoluteEncoderZeroValue = 919;	//TODO : cross check this
		public final static double armFrontPosition = 20.0;
		public final static double armBackPosition = 1800;

		public static double armHoldingPower = 0.0;
	}

	public static class ShooterConstants {
		//public static final boolean tiltMotorInvert = true;
		//public static final int PID_TILT = 0;
		//public static final int configureTimeoutMs = 30;
		//public static final boolean tiltEncoderSensorPhase = true;
		//public static final double PeakOutput = 0.4;
		//public static final int tiltDefaultAcceptableError = 1;
		//public static final int SLOT_0 = 0;
		//public static final double P_TILT = 0.8;
		//public static final double I_TILT = 0.0002;
		//public static final double D_TILT = 0.8;
		//public final static double F_TILT = 0;
		//public final static int absoluteEncoderZeroValue = 2270;
	}

	public static class PneumaticConstants {
		public static final int COMPRESSOR_MODULE = 13;
		public static final int FORWARD_CHANNEL = 0;
		public static final int REVERSE_CHANNEL = 2;

	}

	public static class ControllerConstants {
		public static final int ABUTTON = 1;
		public static final int BBUTTON = 2;
		public static final int XBUTTON = 3;
		public static final int YBUTTON = 4;

		// L1 / R1 on ps controllers
		public static final int LTBUTTON = 5;
		public static final int RTBUTTON = 6;

		public static final int CHANGEVIEWBUTTON = 7;
		public static final int MENUBUTTON = 8;

		// L3 / R3 on ps controllers
		public static final int LSBUTTON = 9;
		public static final int RSBUTTON = 10;

		// define these triggers as new Trigger(() ->
		// driveController.getRawAxis(Constants.ControllerConstants.[constant]) > 0.3)
		// L2 / R2 on ps controllers
		public static final int LBBUTTON = 2;
		public static final int RBBUTTON = 3;
	}

	public static class DriveConstants {
		public static final int DRIVER_CONTROLLER_PORT = 5;
		public static final boolean LEFT_MOTOR_INVERSION = true;
		public static final boolean RIGHT_MOTOR_INVERSION = false;

		public static double turnAdjust = 1;
	}

	public static class MotorConstants {
		public static final int LEFT_MOTOR_FRONT_CANID = 1;
		public static final int LEFT_MOTOR_CENTER_CANID = 2;
		public static final int LEFT_MOTOR_REAR_CANID = 3;
		public static final int RIGHT_MOTOR_FRONT_CANID = 4;
		public static final int RIGHT_MOTOR_CENTER_CANID = 5;
		public static final int RIGHT_MOTOR_REAR_CANID = 6;
	}

	public static class ElevatorConstants {
		public static final int ELEVATORCANID = 8;
		public static final boolean elevatorMotorInvert = true;
		public static final int PID_ELEVATOR = 0;
		public static final int configureTimeoutMs = 30;
		public static final boolean elevatorEncoderSensorPhase = true;
		public static final double PeakOutput = 0.4;
		public static final double elevatorUp = 0.4;
		public static final double elevatorDown = -0.4;
		public static final double elevatorCalibrationZeroPosition = -270;
		public static final double tolerance = 100; 
		public static final double elevatorTopPosition = 14600;
		public static final double elevatorDownPosition = 0;
		public static final int elevatorDefaultAcceptableError = 1;
		public static final int SLOT_0 = 0;
		public static final double P_ELEVATOR = 0.8;
		public static final double I_ELEVATOR = 0.0;
		public static final double D_ELEVATOR = 0.8;
		public final static double F_ELEVATOR = 0;
		public final static int absoluteEncoderZeroValue = 2270;
		public static final double stallCurrent = 8;
	}

	public static final class OIConstants {
		public static final int driverControllerPort = 0;

		public static enum ControllerDeviceType {
			LOGITECH,
			PS5,
			XBOX, // RightJ F/B, LeftJ L/R, L2/R2 - rotation
			XBOX_ONEDRIVE // RIghtJ F/B/L/R, LeftJ - rotation
		}

		public static enum ControllerDevice {

			XBOX_CONTROLLER(
					0, // Port Number for Xbox controller
					ControllerDeviceType.XBOX,
					0.03, // deadband X for Xbox
					0.03, // deadband Y for Xbox //ALL DEADBAND FOR XBOX IS PLACEHOLDER
					0.03, // deadband Omega for Xbox
					false, // No cube controller configuration for Xbox yet
					false);

			private ControllerDeviceType controllerDeviceType;
			private int portNumber;
			private double deadbandX;
			private double deadbandY;
			private double deadbandOmega;
			private boolean cubeControllerLeftStick;
			private boolean cubeControllerRightStick;

			ControllerDevice(int pn, ControllerDeviceType cdt, double dx, double dy, double dm, boolean ccL,
					boolean ccR) {
				this.portNumber = pn;
				this.controllerDeviceType = cdt;
				this.deadbandX = dx;
				this.deadbandY = dy;
				this.deadbandOmega = dm;
				this.cubeControllerLeftStick = ccL;
				this.cubeControllerRightStick = ccR;
			}

			public ControllerDeviceType getControllerDeviceType() {
				return controllerDeviceType;
			}

			public int getPortNumber() {
				return portNumber;
			}

			public double getDeadbandX() {
				return deadbandX;
			}

			public double getDeadbandY() {
				return deadbandY;
			}

			public double getDeadbandOmega() {
				return deadbandOmega;
			}

			public boolean isCubeControllerLeftStick() {
				return cubeControllerLeftStick;
			}

			public boolean isCubeControllerRightStick() {
				return cubeControllerRightStick;
			}
		}
	}
}
