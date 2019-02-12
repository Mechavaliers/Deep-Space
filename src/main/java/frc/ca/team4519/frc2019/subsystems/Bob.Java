package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

//Ball Mechanism
public class Bob extends Subsystem implements Thread{

    public static Bob thisInstance = new Bob();

    public Solenoid indexer;
    
    public Talon leftWheel;
    public Talon rightWheel;

    public Bob() {
        thisInstance = this;

        leftWheel = new Talon(Constants.leftShooterWheel);
        rightWeel = new Talon(Constants.rightShooterWheel);
        indexer = new Solenoid(Constants.indexer);
    }

    public void disable() {
        leftWheel.set(0.0);
        rightWheel.set(0.0);
    }

    public void update() {

    }
}