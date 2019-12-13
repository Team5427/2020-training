
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeActivateOut extends Command {


	public IntakeActivateOut() {
		requires(Robot.intakesubsystem);
	}


	@Override
	protected void initialize() {
		this.setInterruptible(true);
	}


	@Override
	protected void execute() {
		Robot.intakeSubsystem.setSpeed(-1);
	}

	/**
	 * Called periodically while the command is running.
	 * 
	 * @return if the intake button is released
	 */
	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
			
	}

	/**
	 * Called once when the isFinished method returns true. Sets the intake motors
	 * to 0 power in order to stop them from moving.
	 */
	@Override
	protected void end() {
		Robot.intakeSubsystem.stop();
	}

	/**
	 * Called once when the command is interrupted. Calls the end method in order to
	 * stop the intake motors from moving.
	 */
	@Override
	protected void interrupted() {
		end();
	}
}
