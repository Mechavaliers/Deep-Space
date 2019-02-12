package frc.ca.team4519;

import frc.edu.wpi.first.wpilibj.Servo;
import frc.edu.wpi.first.wpilibj.networktables;

import frc.ca.team4519.lib.*;

public class Limelight extends Subsystem implements Thread{

    public static Limelight thisInstance = new Limelight();

    public static Limelight grabInstance() {
        return thisInstance;
    }
    public Limelight(){

    }

}