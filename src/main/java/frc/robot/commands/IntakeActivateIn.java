package frc.robot.commands;
import java.io.ObjectInputFilter.Config;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class IntakeActivateIn extends Command  {

	public IntakeActivateIn() {
		requires(Robot.intakesubsystem);
	}


	@Override
	protected void initialize() {
		this.setInterruptible(true);
	}

	@Override
	protected void execute() {
		Robot.intakeSubsystem.setSpeed(1);
	
	}


	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}


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

