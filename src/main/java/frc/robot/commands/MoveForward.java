package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveForward extends Command {

    public MoveForward(double time){
        requires(Robot.driveTrain);
        setTimeout(time);

    }
    public void execute(){
        Robot.driveTrain.left.set(.3);
        Robot.driveTrain.right.set(-.3);
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