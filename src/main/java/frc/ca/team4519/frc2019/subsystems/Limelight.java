package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.networktables.*;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

public class Limelight extends Subsystem implements Thread{

    public static Limelight thisInstance = new Limelight();

    public Servo pivot;

    public static Limelight grabInstance() {
        return thisInstance;
    }


    public Limelight(){
        pivot = new Servo(Constants.cameraPivot);

    }

    public void loops() {

    }

    @Override
    public void clearSensors() {

    }

    @Override
    public void disableSubsystem() {

    }

    @Override
    public void update() {

    }
}