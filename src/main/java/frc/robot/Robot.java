/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  SpeedController left1;
  SpeedController left2;
  SpeedController right1;
  SpeedController right2;
  SpeedControllerGroup left;
  SpeedControllerGroup right;
  DifferentialDrive drive;

  public static DriveTrain driveTrain;

public static Subsystem m_subsystem;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  public void robotInit(){

  
    left1 = new PWMVictorSPX(1);
    left2 = new PWMVictorSPX(0);
    right1 = new PWMVictorSPX(3);
    right2 = new PWMVictorSPX(6);
    left = new SpeedControllerGroup(left1, left2);
    right = new SpeedControllerGroup(right1, right2);
    driveTrain = new DriveTrain(left, right, drive); 
    drive = new DifferentialDrive(left, right);  
    drive.setSafetyEnabled(false);
    m_oi = new OI();
}

public void disabledPeriodic(){
    Scheduler.getInstance().run();
}

public void autonomousInit(){
 
}

public void autonomousPeriodic(){
    Scheduler.getInstance().run();
}
public void telopInit(){
    if (m_autonomousCommand != null){
        m_autonomousCommand.cancel();
    }    
}
public void telopPeriodic(){
    Scheduler.getInstance().run();
}
}
