package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveForward extends Command {

    public MoveForward(double time){
        requires(Robot.driveTrain);
        setTimeout(time);

    }
    public void execute(double speed){
        Robot.driveTrain.left.set(speed);
        Robot.driveTrain.right.set(-speed);
    }
   
    @Override
    protected boolean isFinished() {
        return this.isTimedOut();
    }
    public void end(){
        Robot.driveTrain.left.set(0.0);
        Robot.driveTrain.right.set(0.0);

    }
    public void interupted(){
        Robot.driveTrain.left.set(0.0);
        Robot.driveTrain.right.set(0.0);
        end();

    }

}