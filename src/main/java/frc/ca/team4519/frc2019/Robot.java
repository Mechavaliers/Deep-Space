
package frc.ca.team4519.frc2019;

//import frc.ca.team4519.frc2019.subsystems.Drivebase;
import frc.ca.team4519.frc2019.subsystems.*;
//import frc.ca.team4519.frc2019.subsystems.Ian;
//import frc.ca.team4519.frc2019.subsystems.Bob;
import frc.ca.team4519.frc2019.subsystems.Harry;
import frc.ca.team4519.frc2019.subsystems.Drivebase;
import frc.ca.team4519.frc2019.subsystems.Ian;
import frc.ca.team4519.frc2019.subsystems.Bob;
import frc.ca.team4519.frc2019.subsystems.Harry;
import frc.ca.team4519.frc2019.subsystems.Limelight;
import frc.ca.team4519.lib.*;

import edu.wpi.first.wpilibj.Joystick;

public class Robot extends MechaTimedRobot{

    Joystick driver = new Joystick(0);
    Joystick operator = new Joystick(1);


    public void main(String[] args){

    }

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
        //Drivebase.grabInstance().setLeftRightPower(Drivebase.grabInstance().arcade(driver.getRawAxis(1), driver.getRawAxis(4)));
        Drivebase.grabInstance().arcade(driver.getRawAxis(1), driver.getRawAxis(4), driver.getRawButton(5));
        Drivebase.grabInstance().shift(driver.getRawButton(6));

        Limelight.grabInstance().direction(Drivebase.grabInstance().invertedState());

        //Intake Behaviour (IN,OUT)
        Ian.grabInstance().bobsManipulation(operator.getRawButton(7), operator.getRawButton(6));
        //Intake up/down
        Ian.grabInstance().ianMindControl(operator.getRawButton(2));

        //Shooter Flywheel behavior (SHOTSPEED, INTAKE, )
        Bob.grabnstance().shotLogic(operator.getRawButton(1), operator.getRawButton(7));

        Bob.grabnstance().shoot(operator.getRawButton(3));
        //Hatch Mech (EXTEND, YEET)
        Harry.grabInstance().welcomeToTheYeetOlympics(operator.getRawButton(4), operator.getRawButton(8));
        //Climber
        Climber.grabInstance().frontToggle(operator.getRawButton(11));
        Climber.grabInstance().backToggle(operator.getRawButton(10));
    }

    public void allPeriodic() {
        
    }

}
