package frc.ca.team4519.frc2019.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.networktables.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.ca.team4519.frc2019.Constants;
import frc.ca.team4519.frc2019.Gains;
import frc.ca.team4519.lib.Thread;
import frc.ca.team4519.lib.*;

public class Limelight extends Subsystem implements Thread{

    private static Limelight thisInstance = new Limelight();

    private Servo pivot;

    private NetworkTableInstance limelight;
    private NetworkTable limelightTable;

    public static Limelight grabInstance() {
        return thisInstance;
    }


    private static final double facingForwards = Gains.limelightForward;
    private static final double facingBackwards = Gains.limelightReverse;


    public Limelight(){
        pivot = new Servo(Constants.cameraPivot);
        pivot.setName("LimeLight", "Pivot");
        pivot.setAngle(0);

        limelight = NetworkTableInstance.getDefault();
        limelightTable = limelight.getTable("limelight");
    }



    public void direction(double invert){
        if (invert == -1.0){
            pivot.setAngle(facingBackwards);
        }else {
            pivot.setAngle(facingForwards);
        }
    }

    public double distFromGoal() {
        return 42.569*Math.pow(limelightTable.getEntry("ta").getDouble(0), -0.5);
    }

    public double getHorizontalOffset(){
        return limelightTable.getEntry("tx").getDouble(0);
    }

    public double getVericalalOffset(){
        return limelightTable.getEntry("ty").getDouble(0);
    }

    public boolean hasValidTarget (){
        return limelightTable.getEntry("tv").getDouble(0) == 1;
    }

    public void setLightOff() {
        limelightTable.getEntry("ledMode").setNumber(1);
    }

    public void setLightBlinking() {
        limelightTable.getEntry("ledMode").setNumber(2);
    }

    public void setLightSolid() {
        limelightTable.getEntry("ledMode").setNumber(3);
    }

    public void cameraModeProcessoron() {
        limelightTable.getEntry("camMode").setNumber(3);
    }

    public void camerModeDriver() {
        limelightTable.getEntry("camMode").setNumber(3);
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
        SmartDashboard.putNumber("Distance from goal (Limelight)", distFromGoal());
        SmartDashboard.putNumber("somehting", getHorizontalOffset());
        SmartDashboard.putNumber("somehting", getVericalalOffset());
        SmartDashboard.putBoolean("Has Valid Target", hasValidTarget());
        

    }
}