package team3647ConstantsAndFunctions;

public class Constants 
{
	//Motor Pins
	public final static int leftMaster = 57;
	public final static int rightMaster = 54;
	public final static int rightSlave1 = 58;
	public final static int rightSlave2 = 59;
	public final static int leftSlave1 = 52;
	public final static int leftSlave2 = 53;
	
	//Piston Pins
	public final static int forksPinSourceA = 4;
	public final static int forksPinSourceB = 5;
	public final static int intakePinSourceA = 2;
	public final static int intakePinSourceB = 3;
	public final static int shifterPinSourceA = 1;
	public final static int shifterPinSourceB = 0;
	public final static int lockPinSourceA = 6;
	public final static int lockPinSourceB = 7;
	
	//Elevator
	public final static int rightIntakePin = 56;
	public final static int leftIntakePin = 55;
	public final static int leftElevatorMaster = 52;
	public final static int rightElevatorMaster = 62;
	public final static int leftElevatorSlave = 54;
	public final static int rightElevatorSlave = 57;
	public final static int elevatorBannerSensor = 9;
	public final static int intakeBannerSensor = 8;
	
	public static final double stop = 0;
	public static final double pickUp = 3000;
	public static final double sWitch = 13000;
	public static final double lowerScale = 36300;
	public static final double scale = 41500;
	public static final double climb = 11000;

	//Wrist
	public final static int flat = 0;
	public final static int aim = 350;
	public final static int idle = 720;
	public final static int wristPin = 0;
	public final static int wristLimitSwitch = 1;
		//flat
	public final static double moveToFlat = -0.1;
	public final static double aimMoveToFlat = -0.3;
	public final static double idleMoveToFlat = -0.25;
		//aim
	public final static double idleMoveToAim = -0.2;
	public final static double moveToAim = 0.3;
	public final static double maintainAimWithCube = 0.17;
	public final static double maintainAim = 0.1;
	public final static double adjustAimUpWithCube = 0.2;
	public final static double adjustAimUp = 0.15;
	public final static double adjustAimDownWithCube = 0;
	public final static double adjustAimDown = 0;
		//idle
	public final static double moveToIdle = 0.5;
	public final static double maintainIdleWithcube = 0.15;
	public final static double maintainIdle = 0;
	public final static double adjustIdleUpWithCube = 0.2;
	public final static double adjustidleUp = 0.15;
	public final static double adjustIdleDownWithCube = -0.15;
	public final static double adjustIdleDown = -0.1;
	
	//Auto Constants
	public static final double oneCubeSwitchRightSideStraight = 8500;
	public static final double oneCubeSwitchRightSideCurve = 5300;
	public static final double oneCubeSwitchRightSideCurveRatio = 2.5;
	
	public static final double twoCubeSwitchRightSideStraight = 11000;
	public static final double twoCubeSwitchRightSideCurve = 9000;
	public static final double twoCubeSwitchRightSideCurveRatio = 2.3;
	
	public static final double twoCubeSwitchLeftSideStraight = 16000;
	public static final double twoCubeSwitchLeftSideFirstCurve = 5300;
	public static final double twoCubeSwitchLeftSideFirstCurveRatio = 2.5;
	public static final double twoCubeSwitchLeftSideStraightCrossField = 12785;
	public static final double twoCubeSwitchLeftSideSecondCurve = 5300;
	public static final double twoCubeSwitchLeftSideSecondCurveRatio = 2.5;
	
	public static final double lrandrrFirstStraightDist = 21936.6;
	public static final double lrandrrFirstTurnToScaleDist = 5400;
	public static final double lrandrrFirstTurnToScaleRatio = 3.26;
	public static final double lrandrrBackUpTurnAfterScaleDist = 5400;
	public static final double lrandrrBackUpTurnAfterScaleRatio = 3.26;
	public static final double lrandrrBackUpTurnAfterScale = 3222;
	public static final double lrandrrBackUpToWallTurnDist = 5400;
	public static final double lrandrrBackUpToWallTurnRatio = 3.26;
	public static final double lrStraightAfterWall = 	2928;
}
