//TODO: retest the code since i added some constants and commented out some stuff ^_^

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class PneumaticSubsystem {
    // private static final Value Forward = null;
    // private static final Value Reverse = null;
    private Compressor compressor;
    private static DoubleSolenoid solenoid;

    public PneumaticSubsystem() {
        compressor = new Compressor(Constants.PneumaticConstants.COMPRESSOR_MODULE, PneumaticsModuleType.CTREPCM);
        solenoid = new DoubleSolenoid(Constants.PneumaticConstants.COMPRESSOR_MODULE, PneumaticsModuleType.CTREPCM, Constants.PneumaticConstants.FORWARD_CHANNEL, Constants.PneumaticConstants.REVERSE_CHANNEL);
        activateCompressor();
      } 
    public void activateCompressor() {
        compressor.enableDigital();
      }
    
      public void deactivateCompressor() {
        compressor.disable();
      }
    
      public void extendCylinder() {
        solenoid.set(Value.kForward);
      }
    
      public void retractCylinder() {
        solenoid.set(Value.kReverse);
      }
    
      public void toggleCylinder() {
        solenoid.toggle();
      }
    
}