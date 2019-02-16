package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//Paul wrote this so it might be garbage
public class Climber extends Subsystem implements Thread{

    public static Climber thisInstance = new Climber();

    public static Climber grabInstance() {return thisInstance;}

    public boolean toggleFront = false;
    public boolean toggleBack = false;

    public Solenoid frontClimber;
    public Solenoid rearClimber;

    public Climber() {
        thisInstance = this;

        frontClimber = new Solenoid(Constants.frontClimber);
        rearClimber = new Solenoid(Constants.rearClimber);
    }

    public void loops() {

    }

    public void frontToggle(boolean button) {
        if(!button){
            toggleFront=true;
        }else if(toggleFront){
            frontClimber.set(!frontClimber.get());
            toggleFront=false;
        }
    }

    public void backToggle(boolean button) {
        if(!button) {
            toggleBack = true;
        }else if (toggleBack) {
            rearClimber.set(!rearClimber.get());
            toggleBack = false;
        }
    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        
    }

    public void update() {
        
    }
    
}