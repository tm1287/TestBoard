package org.usfirst.frc.team1100.robot.commands;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.Extreme3DPro;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class DefaultDrive extends Command {
	
	double x, y, z;

    public DefaultDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Drive.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//x = OI.getInstance().getExtreme().getAxis(Joystick.AxisType.kX);
    	y = OI.getInstance().getExtreme().getAxis(Joystick.AxisType.kY);
    	z = OI.getInstance().getExtreme().getAxis(Joystick.AxisType.kZ);
    	
    	Drive.getInstance().ArcadeDrive(-y, z);
    	SmartDashboard.putNumber("Speed", y);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
