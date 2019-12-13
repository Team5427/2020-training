package org.usfirst.frc.team5427.robot.subsystems;
import org.usfirst.frc.team5427.util.SameLine;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
public class Intake extends Subsystem{
    private SpeedController leftFlywheel;
    private SpeedController rightFlywheel;
    public static final double LEFT_FLYWHEEL_BIASFORWARD =1;
    public static final double LEFT_FLYWHEEL_BIASBACKWARD=1;
    public static final double RIGHT_FLYWHEEL_BIASFORWARD=1;
    public static final double RIGHT_FLYWHEEL_BIASBACKWARD=1;
    public static final double LEFT_FLYWHEEL_OFFSET_FORWARD=0;
    public static final double LEFT_FLYWHEEL_OFFSET_BACKWARD=0;
    public static final double RIGHT_FLYWHEEL_OFFSET_FORWARD=0;
    public static final double RIGHT_FLYWHEEL_OFFSET_BACKWARD=0;
    public Intake(SpeedController leftFlywheel,SpeedController rightFlywheel)
    this.leftFlywheel=leftFlywheel;
    this.rightFlywheel=rightFlywheel;
}
public void setSpeed(double speed){
    if(speed<0){
        leftFlywheel.set(speed*LEFT_FLYWHEEL_BIASFORWARD+LEFT_FLYWHEEL_OFFSET_BACKWARD);
        rightFlywheel.set(speed*RIGHT_FLYWHEEL_OFFSET_FORWARD+RIGHT_FLYWHEEL_OFFSET_BACKWARD);
    }
    else if(speed>0){
        leftFlywheel.set(speed * LEFT_FLYWHEEL_BIASFORWARD + LEFT_FLYWHEEL_OFFSET_FORWARD);
			rightFlywheel.set(speed * RIGHT_FLYWHEEL_BIASBACKWARD + RIGHT_FLYWHEEL_OFFSET_BACKWARD);
    }
    else{
            leftFlywheel.set(0);
            rightFlywheel.set(0);
    }
}
public void initDefaultCommand(){

}
public void stop(){
    setSpeed(0);
}
}

