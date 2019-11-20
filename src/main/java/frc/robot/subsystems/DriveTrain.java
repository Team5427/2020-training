/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  SpeedControllerGroup left, right;
  DifferentialDrive driveBase;
  
  public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive driveBase){
    this.left = left;
    this.right = right;
    this.driveBase = driveBase;


  }
  public void run(double speed){
    left.set(speed);
    right.set(-speed);

  }
  public void stop(){
    left.set(0);
    right.set(0);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
