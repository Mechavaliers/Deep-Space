package frc.ca.team4519.frc2019.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.VictorSP;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.frc2019.Gains;
import frc.ca.team4519.lib.DrivetrainOutput;
import frc.ca.team4519.lib.Subsystem;
import frc.ca.team4519.lib.Thread;

public class Drivebase extends Subsystem implements Thread{

    public static Drivebase thisInstance = new Drivebase();

    private final VictorSP leftDrive;
    private final VictorSP rightDrive;

    private final Encoder leftDriveEncoder;
    private final Encoder rightDriveEncoder;
    
    private final Solenoid shifter;

    public boolean toggleFront = false;
    double inversion = 1.0;

    private final AHRS navX;

    public static Drivebase grabInstance() {
        return thisInstance;
    }

    @Override
    public void loops() {

    }

    public interface Controller {
      //  DrivetrainOutput update(Pose pose);
    }

    public Drivebase() {
        thisInstance = this;

        leftDrive = new VictorSP(Constants.leftDrive);
        leftDrive.setName("Drivebase", "Left Drive Motors");

        rightDrive = new VictorSP(Constants.rightDrive);
        rightDrive.setName("Drivebase", "Right Drive Motor");

        leftDriveEncoder = new Encoder(Constants.leftDriveEncoderA, Constants.leftDriveEncoderB, Constants.isLeftDriveEncoderFlipped, CounterBase.EncodingType.k4X);
        leftDriveEncoder.setDistancePerPulse(Gains.DrivebaseGains.EncoderTicksPerRev);
        leftDriveEncoder.setName("Drivebase","Left Drive Motor");

        rightDriveEncoder = new Encoder(Constants.rightDriveEncoderA, Constants.rightDriveEncoderB, Constants.isRightDriveEncoderFlipped, CounterBase.EncodingType.k4X);
        rightDriveEncoder.setDistancePerPulse(Gains.DrivebaseGains.EncoderTicksPerRev);
        rightDriveEncoder.setName("Drivebase","Right Drive Motor");

        shifter = new Solenoid(Constants.shifter);

        navX = new AHRS(SPI.Port.kMXP);

    }

    public void shift(boolean wantShift) {
        shifter.set(wantShift);
    }

    public boolean isHighGear() {
        return shifter.get();
    }

    public void setLeftRightPower(DrivetrainOutput power)  {
        leftDrive.set(-power.leftOutput);
        rightDrive.set(power.rightOutput);
    }

    public double invertedState(){
        return inversion;
    }

    public DrivetrainOutput arcade(double throttle, double turn, boolean invert) {

            

            throttle = (Math.abs(throttle) > Math.abs(0.03))? throttle : 0.0;
            turn = (Math.abs(turn) > Math.abs(0.03))? turn : 0.0;

            if(!invert){
                toggleFront=true;
            }else if(toggleFront){
                inversion = inversion* -1.0;
                toggleFront=false;
            }

            double right = throttle + turn ;
            double left = throttle - turn;
            SmartDashboard.putNumber("Drivebase Output Throttle", throttle);
            SmartDashboard.putNumber("Drivebase Output Turn", turn);
            leftDrive.set(left*inversion);
            rightDrive.set(right *inversion);
            return new DrivetrainOutput(left, right);
    }

    public void clearSensors() {
        leftDriveEncoder.reset();
        rightDriveEncoder.reset();
        navX.reset();
    }

    public void disableSubsystem() {
        setLeftRightPower(new DrivetrainOutput(0.0, 0.0));
    }

    public void update() {
        SmartDashboard.putNumber("Left Encoder Distance", leftDriveEncoder.getDistance());
        SmartDashboard.putNumber("Left Encoder Velocity", leftDriveEncoder.getRate());
        SmartDashboard.putNumber("Right Encoder Distance", rightDriveEncoder.getDistance());
        SmartDashboard.putNumber("Right Encoder Velocity", rightDriveEncoder.getRate());
    }
}