
package frc.ca.team4519.frc2019;

import frc.ca.team4519.frc2019.subsystems.Drivebase;
import frc.ca.team4519.frc2019.subsystems.Ian;
import frc.ca.team4519.frc2019.subsystems.Bob;
import frc.ca.team4519.frc2019.subsystems.Harry;
//import frc.ca.team4519.Limelight;
import frc.ca.team4519.lib.*;

import edu.wpi.first.wpilibj.Joystick;

public class Robot extends MechaTimedRobot{

    Joystick driver = new Joystick(0);
    Joystick operator = new Joystick(1);


    public void autonomousInit() {

    }

    public void autonomousPeriodic() {

    }

    public void teleopInit() {

        Drivebase.grabInstance().clearSensors();
       // Limelight.grabInstance().vizunAWP
    }

    public void teleopPeriodic() {
        //Drivetrain Behaviour (THROTTLE, TURN)
        Drivebase.grabInstance().arcade(driver.getRawAxis(3), driver.getRawAxis(4));
        //Intake Behaviour (IN,OUT)
        Ian.grabInstance().bobsManipulation(operator.getRawButton(2), operator.getRawButton(3));

    }

    public void allPeriodic() {
        
    }

}
