package team3647ConstantsAndFunctions;

import team3647elevator.Elevator;
import team3647elevator.Elevator;

public class Functions 
{
	static double avg;
	static boolean reached;
	
	public static double test1and3Straight(double lValue, double rValue, double dist)
	{
		avg = (lValue + rValue)/2.0;
		if(avg < 1800)
		{
			return .6;
		}
		else if(avg < 4000)
		{
			return .74;
		}
		else if(avg < 7000)
		{
			return .87;
		}
		else if(avg < 10000)
		{
			return 1;
		}
		else if(avg < (dist -2000))
		{
			return .74;
		}
		else if(avg < dist)
		{
			return .34;
		}
		else
		{
			return 0;
		}
		//assuming distance 17000
	}
	
	
	public static double test3Turn(double eValue, double dist)
	{
		if(eValue < (dist - 2000))
		{
			return .7;
		}
		else if(eValue < dist)
		{
			return .5;
		}
		else
		{
			return 0;
		}
	}
	
	public static double test4Turn(double eValue, double dist)
	{
		eValue = Math.abs(eValue);
		if(eValue < (dist - 2000))
		{
			return -.7;
		}
		else if(eValue < dist)
		{
			return -.5;
		}
		else
		{
			return 0;
		}
	}
	
	public static double test5Turn(double eValue, double dist)
	{
		eValue = Math.abs(eValue);
		if(eValue < (dist - 2000))
		{
			return -.7;
		}
		else if(eValue < dist)
		{
			return -.5;
		}
		else
		{
			return 0;
		}
	}
	
	public static double testCurve(double eValue, double dist)
	{
		eValue = Math.abs(eValue);
		if(eValue < (dist - 1000))
		{
			return .6;
		}
		else if(eValue < dist)
		{
			return .3;
		}
		else
		{
			return 0;
		}
	}
	
	//Competition Stuff
	public static double oneCubeSwitchRightSideStraight(double sum, double dist)
	{
		if(sum < 2000)
		{
			return .6;
		}
		else if(sum < (dist-1500))
		{
			return .8;
		}
		else if(sum < dist)
		{
			return .4;
		}
		else
		{
			return 0;
		}
	}
	
	public static double oneCubeSwitchRightSideCurve(double eValue, double dist)
	{
		eValue = Math.abs(eValue);
		if(eValue < (dist - 1000))
		{
			return .6;
		}
		else if(eValue < dist)
		{
			return .3;
		}
		else
		{
			return 0;
		}
	}
	
	public static double twoCubeSwitchRightSideStraight(double sum, double dist)
	{
		if(sum < 2000)
		{
			return .4;
		}
		else if(sum < (dist-2500))
		{
			return .6;
		}
		else if(sum < (dist-1500))
		{
			return .45;
		}
		else if(sum < dist)
		{
			return .3;
		}
		else
		{
			return 0;
		}
	}
	
	public static double twoCubeSwitchRightSideCurve(double eValue, double dist)
	{
		eValue = Math.abs(eValue);
		if(eValue < 1500)
		{
			return .5;
		}
		else if(eValue < (dist - 2000))
		{
			return .6;
		}
		else if(eValue < dist)
		{
			return .3;
		}
		else
		{
			return 0;
		}
	}
	
	public static double twoCubeSwitchLeftSideFirstCurve(double eValue, double dist)
	{
		if(eValue < (dist - 2000))
		{
			return .4;
		}
		else if(eValue < (dist))
		{
			return .3;
		}
		else
		{
			return 0;
		}
	}
	
	public static double twoCubeSwitchLeftSideStraightCrossField(double eValue, double dist)
	{
		if(eValue < 3000)
		{
			return .5;
		}
		else if(eValue < (dist-1500))
		{
			return .7;
		}
		else if(eValue < (dist))
		{
			return .4;
		}
		else
		{
			return 0;
		}
	}
	
	public static double twoCubeSwitchLeftSideSecondCurve(double eValue, double dist)
	{
		if(eValue < (dist - 2000))
		{
			return .4;
		}
		else if(eValue < (dist))
		{
			return .3;
		}
		else
		{
			return 0;
		}
	}
}
