package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
    SpeedController flywheelleft;
    SpeedController flywheelright;
    public Intake(SpeedController flywheelleft,SpeedController flywheelright){
        this.flywheelleft = flywheelleft;
        this.flywheelright = flywheelright;
    }




    protected void initDefaultCommand() 
	{	
		
	}
    public void stop(){
        flywheelleft.set(0.0);
        flywheelright.set(0.0);

    }

}