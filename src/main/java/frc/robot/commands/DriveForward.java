package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class DriveForward extends Command {
    public DriveForward(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveTrain);
        setTimeout(time);
}
    public void execute(){
        Robot.driveTrain.run(.3);



    }
@Override
protected void initialize(){
}

@Override
protected boolean isFinished(){
    return this.isTimedOut();
}
@Override
  protected void end() {
    Robot.driveTrain.stop();
  }
  @Override
  protected void interrupted() {
  }





}