// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class IntakeConstants {
	public static final int LEFT_INTAKE_MOTOR_CANID = 10;
	public static final int RIGHT_INTAKE_MOTOR_CANID = 11;
	public static final int INTAKE_ROTATOR_MOTOR_CANID = 12;
	public static final double INTAKE_SPEED = 0.4;
  }
  public static class PneumaticConstants {
	public static final int COMPRESSOR_MODULE = 13;
	public static final int FORWARD_CHANNEL = 0;
	public static final int REVERSE_CHANNEL = 2;
	
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
					5, // Port Number for Xbox controller
					ControllerDeviceType.XBOX,
					0.03, // deadband X for Xbox
					0.03, // deadband Y for Xbox //TODO: ALL DEADBAND FOR XBOX IS PLACEHOLDER
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
