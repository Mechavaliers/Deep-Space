package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.frc2019.Gains;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

//The Intake
public class Ian extends Subsystem implements Thread{

    public static Ian thisInstance = new Ian();

    public Solenoid ian;
    public TalonSRX iansFriend;

    public boolean DEPLOY = true, RETRACT = false;

    public static Ian grabInstance() { return thisInstance; }

    public Ian() {
        thisInstance = this;

        ian = new Solenoid(Constants.ian);
        iansFriend = new TalonSRX(Constants.iansFriend);
    }

    public void wantIan() {
        ian.set(DEPLOY);
    }

    public void stowIan() {
        ian.set(RETRACT);
    }

    public void ianMindControl(boolean wantIan) {
        if (wantIan) {
            wantIan();
        }else{
            stowIan();
        }
    }

    public void inviteBobOver() {
        iansFriend.set(ControlMode.PercentOutput, Gains.iansIntakeSpeed);
    }

    public void kickBobOut() {
        iansFriend.set(ControlMode.PercentOutput, Gains.iansSpitSpeed);
    }

    public void killIan() {
        iansFriend.set(ControlMode.PercentOutput, Gains.killIan);
    }

    public void bobsManipulation(boolean inviteBobOver, boolean kickBobOut) {
        
        if(inviteBobOver){
            inviteBobOver();
        }else if(kickBobOut){
            kickBobOut();
        }else{
            killIan();
        }
    }

    public void ianControll(boolean state) {
        ian.set(state);
    }

    public void loops() {

    }

    public void disableSubsystem() {

    }
    public void clearSensors() {

    }

    public void update() {

    }
}   