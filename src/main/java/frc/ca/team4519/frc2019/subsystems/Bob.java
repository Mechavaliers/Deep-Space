package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.frc2019.Gains;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//Ball Mechanism
public class Bob extends Subsystem implements Thread{

    public static Bob thisInstance = new Bob();

    public static Bob grabnstance() {return thisInstance;}

    public Solenoid indexer;
    
    public TalonSRX leftWheel;
    public TalonSRX rightWheel;

    public Bob() {
        thisInstance = this;

        leftWheel = new TalonSRX(Constants.leftShooterWheel);
        rightWheel = new TalonSRX(Constants.rightShooterWheel);
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
        leftWheel.set(ControlMode.PercentOutput, speed);
        rightWheel.set(ControlMode.PercentOutput, -speed);
    }

    public void loops() {

    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        leftWheel.set(ControlMode.PercentOutput, 0.0);
        rightWheel.set(ControlMode.PercentOutput, 0.0);
    }

    public void update() {

    }
}