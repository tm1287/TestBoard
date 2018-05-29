package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.DefaultDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static Drive drive;
	private Talon left, right;
	private Encoder encoderLeft, encoderRight;
	private static DifferentialDrive drivetrain;
	final double PULSE_PER_FOOT = 4090;
	
	public static Drive getInstance() {
		if (drive == null) {
			drive = new Drive();
		}
		return drive;
	}
	
	private Drive() {
		left = new Talon(RobotMap.M_LEFT);
		right = new Talon(RobotMap.M_RIGHT);
		left.setInverted(true);
		
		encoderLeft = new Encoder(RobotMap.E_LEFT_A, RobotMap.E_LEFT_B);
		encoderRight = new Encoder(RobotMap.E_RIGHT_A, RobotMap.E_RIGHT_B);
		encoderLeft.setDistancePerPulse(1/PULSE_PER_FOOT);
		encoderRight.setDistancePerPulse(1/PULSE_PER_FOOT);
		
		drivetrain = new DifferentialDrive(left, right);
	}

	public void ArcadeDrive(double speed, double angle) {
		drivetrain.arcadeDrive(speed, angle);
	}
	
	public Encoder getLeftEncoder() {
		return encoderLeft;
	}
	
	public Encoder getRightEncoder() {
		return encoderRight;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DefaultDrive());
    }
}

