package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForward extends Command
{
    public DriveForward(double time)
    {
        requires(Robot.driveTrain);
        setTimeout(time);
    }

    @Override
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    public void execute()
    {
        
        Robot.driveTrain.run(0.3);
    }

    public void end()
    {
       Robot.driveTrain.stop();
    }

    public void interrupted()
    {      end();
    }

}