/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.commands.DriveWithJoystick;



/**
* An example subsystem. You can replace me with your own Subsystem.
*/
public class DriveTrain extends Subsystem {
public SpeedControllerGroup left;
public SpeedControllerGroup right;

public DifferentialDrive drive;
// Put methods for controlling this subsystem
// here. Call these from Commands.
public DriveTrain (SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive) {
this.left = left;
this.right = right;
this.drive = drive;


}

public void stop() {
drive.stopMotor();

}
public void takeJoystickInputs(Joystick joy){
    drive.arcadeDrive(-joy.getY(), joy.getZ() * .75);
}
@Override
public void initDefaultCommand() {

setDefaultCommand(new DriveWithJoystick());
}
}