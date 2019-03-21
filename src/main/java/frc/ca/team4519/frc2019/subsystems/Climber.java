package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//Paul wrote this so it might be garbage
public class Climber extends Subsystem implements Thread{

    public static Climber thisInstance = new Climber();

    public static Climber grabInstance() {return thisInstance;}

    public boolean toggleFront = false;
    public boolean toggleRear = false;

    public Solenoid frontClimberUP;
   // public Solenoid frontClimberDN;
    public Solenoid rearClimberUP;
    //public Solenoid rearClimberDN;

    public Climber() {
        thisInstance = this;

        frontClimberUP = new Solenoid(6);//change all these
        //frontClimberDN = new Solenoid(7);
        rearClimberUP = new Solenoid(5);
       // rearClimberDN = new Solenoid(5);

        frontClimberUP.set(false);
        //frontClimberDN.set(false);
        rearClimberUP.set(false);
        //rearClimberDN.set(false);
    }

    public void loops() {

    }

    public void frontToggle(boolean button) {
        if(!button){
            toggleFront=true;
        }else if(toggleFront){
            frontClimberUP.set(!frontClimberUP.get());
            //frontClimberDN.set(!frontClimberDN.get());
            toggleFront=false;
        }
    }

    public void backToggle(boolean button) {
        if(!button) {
            toggleRear = true;
        }else if (toggleRear) {
            rearClimberUP.set(!rearClimberUP.get());
            //rearClimberDN.set(!rearClimberDN.get());
            toggleRear = false;
        }
    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        
    }

    public void update() {
        SmartDashboard.putBoolean("Back Climb",rearClimberUP.get());
    }
    
}