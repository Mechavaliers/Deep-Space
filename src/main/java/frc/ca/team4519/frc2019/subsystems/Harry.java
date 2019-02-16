package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Solenoid;
import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.lib.Subsystem;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//Hatch Mechanism
public class Harry extends Subsystem implements Thread{

    public static Harry thisInstance = new Harry();

    public Solenoid harry;
    public Solenoid yeeter;

    public boolean YEET = true, STOW = true, ENGAGED = false;

    public Harry() {
        thisInstance = this;

        harry = new Solenoid(Constants.harry);
        yeeter = new Solenoid(Constants.yeeter);
    }

    public void yeet() {
        yeeter.set(YEET);
    }

    public void loops() {

    }

    public void update() {

    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        harry.set(STOW);
        yeeter.set(!YEET);
    }
}