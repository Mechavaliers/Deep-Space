package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

//The Intake
public class Ian extends Subsystem implements Thread{

    public static Ian thisInstance = new Ian();

    public Solenoid ian;
    public CANTalon iansFriend;

    public boolean DEPLOY = true, RETRACT = false;

    public Ian() {
        thisInstance = this;

        ian = new Solenoid(Constants.ian);
        iansFriend = new CANTalon(Constants.iansFriend);
    }

    public void wantIan() {
        ian.set(DEPLOY)
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
        iansFriend.set(Gains.iansIntakeSpeed);
    }

    public void kickBobOut() {
        iansFriend.set(Gains.iansSpitSpeed);
    }

    public void killBob() {
        iansFriend.set(Gains.killBob);
    }

    public void bobsManipulation(boolean inviteBobOver, boolean kickBobOut) {
        
        if(inviteBobOver){
            inviteBobOver();
        }else if(kickBobOut){
            kickBobOut();
        }else{
            killBob();
        }
    }
}   