package frc.ca.team4519;

import edu.wpi.first.wpilibj.Encoder;

import frc.ca.team4519.lib.*;

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

    public interface Controller {
        DrivetrainOutput update(Pose pose);
    }

    public Drivebase() {
        thisInstance = this;

        leftDrive = new Talon(Constants.leftDrive);
        rightDrive = new Talon(Constatnts.rightDrive);
        leftDriveEncoder = new Encoder(Constants.leftDriveEncoderA, Constants.leftDriveEncoderB, Constants.isLeftDriveEncoderFlipped, EncodingType.k4x);
        rightDriveEncoder = new Encoder(Constants.rightDriveEncoerA, Constants.rightDrieEncoerB, Constants.isRightDriveEncoderFlipped, EncodingType.k4x);
    }

    public double DriveControll() {
        
    }

    public void clearSensors();

    public void disableSubsystem();

    public void update();
}