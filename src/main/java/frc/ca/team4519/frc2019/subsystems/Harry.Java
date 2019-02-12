package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

//Hatch Mechanism
public class Harry extends Subsystem implements Thread{

    public static Harry thisInstance = new Harry();

    public Solenoid harr;
    public Solenoid yeeter;

    public boolen YEET = true;

    public Harry() {
        thisInstance = this;

        harry = new Solenoid(Constants.harry);
        yeeter = new Solenoid(Constants.yeeter);
    }

    public void yeet() {
        yeeter.set(YEET);
    }

    public void update() {

    }

    public void disableSubsystem() [

    ]
}