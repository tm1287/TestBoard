package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.DefaultDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *This subsystem is the two cims on the test board
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static Drive drive;
	private Talon left, right;
	private static DifferentialDrive drivetrain;
	
	//Sensors
	private Encoder encoderLeft, encoderRight;
	final double PULSE_PER_FOOT = 4090;
	
	/**
	 * Gets the singular instance of the Drive subsystem.
	 * @return the singular instance of the drive subsystem.
	 */
	public static Drive getInstance() {
		if (drive == null) {
			drive = new Drive();
		}
		return drive;
	}
	
	/**
	 * Sets up Talons, encoders and the drivetrain.
	 */
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

	/**
	 * Plugs Joystick value into Arcade Drive. Used cause I only have one joystick at home.
	 * @param speed Joystick Y axis value -> Speed of robot
	 * @param angle Joystick Z axis value -> Angle that robot turns at while driving
	 */
	public void ArcadeDrive(double speed, double angle) {
		drivetrain.arcadeDrive(speed, angle);
	}
	
	/**
	 * Returns the singular instance of the left encoder
	 * @return the singular instance of the left encoder.
	 */
	public Encoder getLeftEncoder() {
		return encoderLeft;
	}
	
	/**
	 * Returns the singular instance of the left encoder
	 * @return the singular instance of the left encoder
	 */
	public Encoder getRightEncoder() {
		return encoderRight;
	}
	
	/**
	 * Sets the default command for the Drive subsystem to the user drive command.
	 */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DefaultDrive());
    }
}

