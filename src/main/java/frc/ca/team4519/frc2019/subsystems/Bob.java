package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    public DigitalInput leftWheelEncoder;
    public Counter leftFlwheel;
    public DigitalInput rightWheelEncoder;
    public Counter rightFlywheel;

    public Bob() {
        thisInstance = this;

        leftWheel = new TalonSRX(Constants.leftShooterWheel);
        rightWheel = new TalonSRX(Constants.rightShooterWheel);

        leftWheelEncoder = new DigitalInput(Constants.leftShooterWheelEncoder);
        rightWheelEncoder = new DigitalInput(Constants.rightShooterWheelEncoder);

        rightFlywheel = new Counter(rightWheelEncoder);
        leftFlwheel = new Counter(leftWheelEncoder);

        indexer = new Solenoid(Constants.indexer);
    }

    public void shotLogic(boolean wantSpinUp, boolean wantIntake){
        if(wantSpinUp){
            wheelControl(-Gains.bobShotSpeed);
        }else if(wantIntake) {
            wheelControl(Gains.bobIntakeSpeed);
        }else{
            wheelControl(0.0);
        }
    }

    public void shoot(boolean wantShot){
        indexer.set(wantShot);
    }

    public void wheelControl(double speed){
        leftWheel.set(ControlMode.PercentOutput, speed);
        rightWheel.set(ControlMode.PercentOutput, -speed);
    }

    public void loops() {
    }

    public void ways() {
        leftFlwheel.getRate();
    }

    public void clearSensors() {

    }

    public void disableSubsystem() {
        leftWheel.set(ControlMode.PercentOutput, 0.0);
        rightWheel.set(ControlMode.PercentOutput, 0.0);
    }

    public void update() {

        SmartDashboard.putNumber("Left Shooter Wheel Rps", leftFlwheel.getRate());
        SmartDashboard.putNumber("Right Shooter Wheel Rps", rightFlywheel.getRate());
        SmartDashboard.putNumber("left flywheel get", leftFlwheel.get());
        SmartDashboard.putNumber("left flywheel get distance", leftFlwheel.getDistance());
    }
}