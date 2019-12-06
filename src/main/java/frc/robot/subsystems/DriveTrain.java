package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveForward;
import frc.robot.commands.DriveWithJoystick;

public class DriveTrain extends Subsystem {

    DifferentialDrive drive;
    SpeedControllerGroup left;
    SpeedControllerGroup right;
    public DriveTrain(SpeedControllerGroup left,SpeedControllerGroup right, DifferentialDrive drive) {
    this.left=left;
    this.right=right;
    this.drive=drive;

    }
   public void run(double speed)
    {
        left.set(speed);
        right.set(-speed);

    }
    public void stop()
    {
        drive.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    public void takeJoystickInputs(Joystick joy) {
		drive.arcadeDrive(-joy.getY(), joy.getZ()*.75);

	}
}