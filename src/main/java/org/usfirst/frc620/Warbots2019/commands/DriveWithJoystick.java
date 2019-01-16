// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc620.Warbots2019.commands;

import org.usfirst.frc620.Warbots2019.Robot;
import org.usfirst.frc620.Warbots2019.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveWithJoystick() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    private DriveTrain getDriveTrain()
    {
        return Robot.driveTrain;
    }

    private XboxController getOperatorController()
    {
        return Robot.oi.getOperatorController();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //Read the vertical axis of the left joystick on the controller
        double speed = getOperatorController().getY(Hand.kLeft);

        //Read the horizontal axis of the left joystick on the controller
        double turnRate = getOperatorController().getX(Hand.kLeft);

        getDriveTrain().drive(speed, turnRate);

        //Vibrate the driver controller after large acceleration
        if (getDriveTrain().getAcceleration() > 7)
        {
            getOperatorController().setRumble(RumbleType.kLeftRumble, 1);
            getOperatorController().setRumble(RumbleType.kRightRumble, 1);
        }
        else //Stop vibrating the controller when not accelerating
        {
            getOperatorController().setRumble(RumbleType.kLeftRumble, 0);
            getOperatorController().setRumble(RumbleType.kRightRumble, 0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        //Ends this command after the driver travels a certain total distance
        //This is not really useful, only here as an example.
        return getDriveTrain().getTotalDistanceTravelled() > 1000;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        //Shut the entire robot down for the rest of the match as revenge against
        //whichever command had the gaul to interrupt this precious work of art
        System.exit((int) (Math.random() * Integer.MAX_VALUE));
    }
}
