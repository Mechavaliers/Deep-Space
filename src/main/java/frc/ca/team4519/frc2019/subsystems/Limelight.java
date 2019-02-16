package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.networktables.*;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.frc2019.Gains;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

public class Limelight extends Subsystem implements Thread{

    public static Limelight thisInstance = new Limelight();

    public Servo pivot;

    public static Limelight grabInstance() {
        return thisInstance;
    }

    public static double facingForwards = Gains.limelightForward;
    public static double facingBackwards = Gains.limelightReverse;


    public Limelight(){
        pivot = new Servo(Constants.cameraPivot);
        pivot.setName("LimeLight", "Pivot");
        pivot.setAngle(0);

    }

    public void direction(boolean invert){
        if (invert){
            pivot.setAngle(facingBackwards);
        }else {
            pivot.setAngle(facingForwards);
        }
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