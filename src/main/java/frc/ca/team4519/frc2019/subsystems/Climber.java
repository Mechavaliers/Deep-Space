package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//Paul wrote this so it might be garbage
public class Climber extends Subsystem implements Thread{

    public static Climber thisInstance = new Climber();

    public Solenoid frontClimber;
    public Solenoid rearClimber;

    public Climber() {
        thisInstance = this;

        frontClimber = new Solenoid(Constants.frontClimber);
        rearClimber = new Solenoid(Constants.rearClimber);
    }

    public void loops() {

    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        
    }

    public void update() {
        
    }
    
}