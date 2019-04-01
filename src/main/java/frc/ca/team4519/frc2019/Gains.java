package frc.ca.team4519.frc2019;

public class Gains {

    public static class DrivebaseGains {
        private DrivebaseGains() {}

        public static double CONTROL_LOOP_TIME = 0.005;	// 0.5 Millisecond

        public static double HANDLING_MODIFIER = 1.0;	//TODO Update this
        public static double PATH_TOLLERANCE = 0.25;	//TODO Update this

        //	Inches/Seconds
        public static double ROBOT_MAX_VELOCITY= 180.0; //TODO Update this
        public static double ROBOT_MAX_ACCELERATION = 45.0; //TODO Update this
        public static double ROBOT_MAX_ROTATIONAL_VELOCITY = 360.0;	//TODO Update this
        public static double ROBOT_MAX_ROTATIONAL_ACCELERATION = 250.0;	//TODO Update this
        public static double Wheelbase_Width = 35.25;	//TODO Update this
        public static double Wheelbase_Length = 39.25; 	//TODO Update this
        public static double EncoderTicksPerRev =(( 2 * Math.PI * 3.125 ) / 256); //TODO Update this THIS WILL NOT EVEN GET CLOSE TO WORKING
        public static double WheelSize_Inches = 6.250;


        public static double Dist_P = 0.1;	//TODO Tune this
        public static double Dist_I = 0.0;	//TODO tune this
        public static double Dist_D = 0.0;	//TODO Tune this
        public static double Dist_V = 1 / ROBOT_MAX_VELOCITY;   //TODO Update this
        public static double Dist_A = 0;	//TODO Tune this
        public static double DistTurn_P = 1.0 / 22.5;	//TODO Tune this
        public static double DistTurn_I = 0.0;	//TODO Tune this
        public static double DistTurn_D = 0.0;	//TODO Tune this
        public static double Dist_Tollerance = 0.0;	// + or - target distance

        //This works in Radians
        public static double Turn_P = 0.0175; //0.0825	//TODO Tune this
        public static double Turn_I = 0.0;	//TODO Tune this
        public static double Turn_D = 0.00; // 0.015	//TODO Tune this
        public static double Turn_V = 1 / 300; //0.05	//TODO Tune this
        public static double Turn_A = 0.0; //0.00225	//TODO Tune this
        public static double Turn_F = 0.01; //TODO Tune This
        public static double Turn_Tollerance = 0.0225;

    }

    public static double iansIntakeSpeed = 1.0; //TODO Update This
    public static double iansSpitSpeed = 1.0;  //TODO Update This
    public static double killIan = 0.0; //TODO Update This

    public static double bobShotSpeed = 0.9; //TODO Update me
    public static double bobIntakeSpeed = 0.5; //TODO Update me

    public static double limelightForward = 200; //TODO Update me
    public static double limelightReverse = 0; //TODO Update Me


}