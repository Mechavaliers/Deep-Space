package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

//Hatch Mechanism
public class Harry extends Subsystem implements Thread{

    public static Harry thisInstance = new Harry();

    public Harry() {
        thisInstance = this;
    }
}