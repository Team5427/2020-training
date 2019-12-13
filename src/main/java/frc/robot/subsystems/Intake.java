
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private SpeedController leftFlywheel;
	
	private SpeedController rightFlywheel;




	public Intake(SpeedController leftFlywheel, SpeedController rightFlywheel) {
		this.leftFlywheel = leftFlywheel;
		this.rightFlywheel = rightFlywheel;
	}

	public void setSpeed(double speed) {
    	if (speed < 0) {
			leftFlywheel.set(speed * 1 + 0);
			rightFlywheel.set(speed *1 + 0);
		}
		else if (speed > 0) {
			leftFlywheel.set(speed * 1 +0);
			rightFlywheel.set(speed * 1 + 0);
		}
		else {
			leftFlywheel.set(0);
			rightFlywheel.set(0);
		}
		}
	


	@Override
	public void initDefaultCommand() {
	}

	public void stop() {
		setSpeed(0);
	}

}

