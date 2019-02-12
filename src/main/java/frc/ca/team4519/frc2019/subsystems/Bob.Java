package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

//Ball Mechanism
public class Bob extends Subsystem implements Thread{

    public static Bob thisInstance = new Bob();

    public Bob() {
        thisInstance = this;
    }
}