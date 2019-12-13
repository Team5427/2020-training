package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.DriveForward;
import frc.robot.commands.IntakeActivateIn;
import frc.robot.commands.IntakeActivateOut;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
  Button motorIntakeIn;
	Button motorIntakeOut;
  public Joystick joy;
  Button elevatorUp;
	Button elevatorDown;

  public OI(){

     joy = new Joystick(0);
     elevatorUp = new JoystickButton(joy, 100);
		elevatorDown = new JoystickButton(joy, 20);
    Button button = new JoystickButton(joy, 11);
    button.whenPressed(new DriveForward(1));
    elevatorUp.whenPressed(Robot.mou);
		elevatorDown.whenPressed(Robot.mod);
    motorIntakeIn.whenPressed(new IntakeActivateIn());
    motorIntakeOut.whenPressed(new IntakeActivateOut());
    




  }
  public Joystick getJoy()

  {
  return joy;
  }
  
}