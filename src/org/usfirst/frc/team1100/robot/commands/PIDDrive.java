package org.usfirst.frc.team1100.robot.commands;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;


/**
 *This command uses the Drive subsytem to turn the motors to the encoder value of 15 
 */
public class PIDDrive extends PIDCommand {

	private PIDController pidController = getPIDController();
	private Encoder encoder = Drive.getInstance().getLeftEncoder();
	private int targetCount;
	
	
	/**
	 * Uses the Drive subsystem and sets up a PID controller to drive both motors to a certain encoder value;
	 * @param target desired encoder value to turn the motors to
	 * @param speed limited turning speed of the motors
	 */
    public PIDDrive(double target, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);'
    	super(1.26,0.5,0.7875);
    	requires(Drive.getInstance());
    	targetCount = 0;
    	setSetpoint(target);
    	
    	pidController.setOutputRange(-speed, speed);
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
    		if (targetCount == 3) {
    			return true;
    		}
    		targetCount++;
    		
    	} else {
    		targetCount = 0;
    	}
    	return false;
    }

}
