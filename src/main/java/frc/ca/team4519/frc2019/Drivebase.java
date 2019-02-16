package frc.ca.team4519.frc2019;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;

import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.lib.DrivetrainOutput;
import frc.ca.team4519.lib.Subsystem;
import frc.ca.team4519.lib.Thread;

public class Drivebase extends Subsystem implements Thread{

    public static Drivebase thisInstance = new Drivebase();

    private final Talon leftDrive;
    private final Talon rightDrive;

    private final Encoder leftDriveEncoder;
    private final Encoder rightDriveEncoder;

    private final Solenoid shifter;

    private final AHRS navX;

    public static Drivebase grabInstance() {
        return thisInstance;
    }

    @Override
    public void loops() {

    }

    public interface Controller {
       // DrivetrainOutput update(Pose pose);
    }

    public Drivebase() {
        thisInstance = this;

        leftDrive = new Talon(Constants.leftDrive);
        rightDrive = new Talon(Constants.rightDrive);
        leftDriveEncoder = new Encoder(Constants.leftDriveEncoderA, Constants.leftDriveEncoderB, Constants.isLeftDriveEncoderFlipped, CounterBase.EncodingType.k4X);
        rightDriveEncoder = new Encoder(Constants.rightDriveEncoderA, Constants.rightDriveEncoderB, Constants.isRightDriveEncoderFlipped, CounterBase.EncodingType.k4X);
        shifter = new Solenoid(Constants.shifter);
        navX = new AHRS(SPI.Port.kMXP);

    }

    public boolean isHighGear() {
        return shifter.get();
    }

    public void setLeftRightPower(DrivetrainOutput power)  {
        leftDrive.set(-power.leftOutput);
        rightDrive.set(power.rightOutput);
    }

    public DrivetrainOutput arcade(double throttle, double turn) {
        throttle = (Math.abs(throttle) > Math.abs(0.03))? throttle : 0.0;
        turn = (Math.abs(turn) > Math.abs(0.03))? turn : 0.0;

        double right = throttle + turn ;
        double left = throttle - turn;

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

    }
}