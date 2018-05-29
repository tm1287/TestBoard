package org.usfirst.frc.team1100.robot.commands;

import java.text.DecimalFormat;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;


/**
 *
 */
public class PIDDrive extends PIDCommand {

	private PIDController pidController = getPIDController();
	private Encoder encoder = Drive.getInstance().getLeftEncoder();
	private int countOnTarget;
	
    public PIDDrive(double target, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);'
    	super(1.26,0.5,0.7875);
    	System.out.println("Testing");
    	requires(Drive.getInstance());
    	countOnTarget = 0;
    	setSetpoint(target);
    	
    	pidController.setOutputRange(-0.5*speed, 0.5*speed);
    	pidController.setAbsoluteTolerance(0.2);
    }
    
    protected double returnPIDInput() {
    	return encoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
    	Drive.getInstance().ArcadeDrive(output, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (pidController.onTarget()) {
    		if (countOnTarget == 3) {
    			return true;
    		}
    		countOnTarget++;
    		
    	} else {
    		countOnTarget = 0;
    	}
    	return false;
    }

}
