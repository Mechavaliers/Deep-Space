package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.frc2019.Gains;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//Ball Mechanism
public class Bob extends Subsystem implements Thread{

    public static Bob thisInstance = new Bob();

    public static Bob grabnstance() {return thisInstance;}

    public Solenoid indexer;
    
    public Talon leftWheel;
    public Talon rightWheel;

    public Bob() {
        thisInstance = this;

        leftWheel = new Talon(Constants.leftShooterWheel);
        rightWheel = new Talon(Constants.rightShooterWheel);
        indexer = new Solenoid(Constants.indexer);
    }

    public void shotLogic(boolean wantSpinUp, boolean wantIntake){
        if(wantSpinUp){
            wheelControl(Gains.bobShotSpeed);
        }else if(wantIntake) {
            wheelControl(Gains.bobIntakeSpeed);
        }else{
            wheelControl(0.0);
        }
    }

    public void wheelControl(double speed){
        leftWheel.set(speed);
        rightWheel.set(speed);
    }

    public void loops() {

    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        leftWheel.set(0.0);
        rightWheel.set(0.0);
    }

    public void update() {

    }
}