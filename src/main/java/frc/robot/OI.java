package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.DriveForward;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
  public Joystick joy;
  public OI(){

     joy = new Joystick(0);
   
    Button button = new JoystickButton(joy, 11);
    button.whenPressed(new DriveForward(1));
  

  }
  public Joystick getJoy()

  {
  return joy;
  }
}