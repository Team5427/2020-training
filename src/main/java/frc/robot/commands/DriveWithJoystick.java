package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class DriveWithJoystick extends Command {

	/**
	 * DriveWithJoystick requires the drive train subsystem.
	 */
	public DriveWithJoystick() {
		requires(Robot.driveTrain);
	}


	@Override
	protected void execute() {
		Robot.driveTrain.takeJoystickInputs(Robot.m_oi.getJoy());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}


	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
    protected void interrupted()
     {
		end();
	}
}

