package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveForward;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot{
    public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
    public static OI m_oi;
    SpeedController left1;
    SpeedController left2;
    SpeedController right1;
    SpeedController right2;

    SpeedControllerGroup left;
    SpeedControllerGroup right;
    DifferentialDrive drive;

        public static DriveTrain driveTrain;
        
    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    public void robotInit(){
        m_oi = new OI();
        m_chooser.setDefaultOption("Default Auto",new ExampleCommand());
        
        SmartDashboard.putData("Auto mode",m_chooser);

        left1 = new PWMVictorSPX(1);
        left2 = new PWMVictorSPX(0);
        right1 = new PWMVictorSPX(3);
        right2 = new PWMVictorSPX(6);
        left = new SpeedControllerGroup(left1, left2);
        right = new SpeedControllerGroup(right1, right2);
        driveTrain = new DriveTrain(left, right, drive)
        drive.setSafetyEnabled(false);

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