package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.networktables.*;

import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

public class Limelight extends Subsystem implements Thread{

    public static Limelight thisInstance = new Limelight();

    public static Limelight grabInstance() {
        return thisInstance;
    }

    public Limelight(){

    }

    public void loops() {

    }

}