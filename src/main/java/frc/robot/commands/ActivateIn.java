package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class ActivateIn {
    public ActivateIn(double time){
        requires(Robot.intake);
        setTimeout(time);
    }

    private void setTimeout(double time) {
    }

    private void requires(Subsystem intake) {
    }
    public void move() {      
        Robot.intake.flywheelleft.set(-0.3);
        Robot.intake.flywheelright.set(0.3);

}

}