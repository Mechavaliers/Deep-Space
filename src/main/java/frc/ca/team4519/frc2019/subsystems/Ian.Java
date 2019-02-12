package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

//The Intake
public class Ian extends Subsystem implements Thread{

    public static Ian thisInstance = new Ian();

    public Ian() {
        thisInstance = this;
    }
}   