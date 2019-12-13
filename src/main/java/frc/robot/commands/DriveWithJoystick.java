package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveWithJoystick extends Command {

    public DriveWithJoystick(){
        requires(Robot.driveTrain);
    }
    public void execute(){
        Robot.driveTrain.takeJoystickInputs(Robot.m_oi.getjoy());

    }
   
    @Override
    protected boolean isFinished() {
        return this.isTimedOut();
    }
    public void end(){
        Robot.driveTrain.stop();

    }
    public void interupted(){
        end();

    }

}