
package frc.robot.commands;

import java.io.ObjectInputFilter.Config;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



public class MoveElevatorDown extends Command {

	public MoveElevatorDown() {}


	@Override
	protected void initialize() {
		this.setInterruptible(true);
		Robot.motorPWM_Elevator_Right.set(24);
		Robot.motorPWM_Elevator_Left.set(-24);
	}

	/**
	 * Scheduler continually calls this method. Does not do anything.
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	protected void execute() {}

	/**
	 * If lower limit switch is true, the robot is at its lowest height. Method
	 * returns true and calls end()
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	public boolean isFinished() {
		frc.robot.Robot.elevatorLimitSwitchDown.get(); 
		
		return (!Robot.m_oi.getJoy().getRawButton(200) || !Robot.elevatorLimitSwitchDown.get());
	}


	@Override
	protected void end() {
		frc.robot.Robot.motorPWM_Elevator_Right.set(0);
		frc.robot.Robot.motorPWM_Elevator_Left.set(0);
	}
	@Override
	protected void interrupted() {
		end();
	}
}