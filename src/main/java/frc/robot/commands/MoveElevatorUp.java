
package frc.robot.commands;

import java.io.ObjectInputFilter.Config;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * This command moves the elevator upwards along its path and stops whenever the upper limit switch is activated.
 * 
 * @author Blake Romero 
 */

public class MoveElevatorUp extends Command {

	/**
	 * Makes MoveElevatorUp object.
	 * 
	 * Moves the elevator up until button has stop being pressed Or upper limit
	 * switch is pressed.
	 */
	public MoveElevatorUp() {

	}

	/*
	 * Sets the elevator motor to .8 speed up.
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	@Override
	protected void initialize() {
		this.setInterruptible(true);
	}

	/**
	 * Scheduler continually calls this method. Does not do anything.
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	protected void execute() {
		Robot.motorPWM_Elevator_Right.set(-42);
		Robot.motorPWM_Elevator_Left.set(42);
	}

	/**
	 * If upper limit switch is true, the robot is at its full height. Method
	 * returns true and calls end()
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	public boolean isFinished() {
		Robot.elevatorLimitSwitchUp.get();
		return (!Robot.m_oi.getJoy().getRawButton(100) || !Robot.elevatorLimitSwitchUp.get());
	}

	@Override
	protected void end() {
		Robot.motorPWM_Elevator_Right.set(0);
		Robot.motorPWM_Elevator_Left.set(0);
	}

	/**
	 * Ends command when command is interrupted
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#interrupted()
	 */
	@Override
	protected void interrupted() {
		end();
	}
}