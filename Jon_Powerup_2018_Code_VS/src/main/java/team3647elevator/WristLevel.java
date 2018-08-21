package team3647elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import team3647ConstantsAndFunctions.Constants;
import team3647ConstantsAndFunctions.Functions;
import team3647subsystems.Joysticks;


public class WristLevel
{
  static DigitalInput limitSwitch = new DigitalInput(Constants.wristLimitSwitch); 

  public static double wristEncoderValue;
  static boolean limitSwitchState;
  

  public static void testWristEncoder()
	{
		System.out.println("Wrist Encoder Value: " + wristEncoderValue);
	}
	
	public static void resetWristEncoder()
	{
		Wrist.wristMotor.getSensorCollection().setQuadraturePosition(0, 10);
	}
	public static void setWristIdle()
	{
		Wrist.wristMotor.getSensorCollection().setQuadraturePosition(Constants.idle, 10);
	}
	
	public static void setWristEncoder()
	{
		if(reachedFlat())
		{
			resetWristEncoder();
		}
		wristEncoderValue = -Wrist.wristMotor.getSensorCollection().getQuadraturePosition();
  }
  
  public static boolean reachedFlat()
	{
			if(limitSwitch.get())
			{
				return true;
			} 
			else 
			{
				return false;
			}
	}
	
	public static boolean reachedAim()
	{
			if(wristEncoderValue > Constants.aim - 25 && wristEncoderValue < Constants.aim + 25)
			{
				return true;
			} 
			else 
			{
			return false;
			}
	}
	
	public static boolean reachedIdle()
	{
			if(wristEncoderValue > Constants.idle - 25 && wristEncoderValue < Constants.idle + 25)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	public static void maintainAimPosition()
	{
    if(!IntakeWheels.getIntakeBannerSensor()) //with cube
    {
      if(reachedAim())
      {
        Wrist.moveWrist(Constants.maintainAimWithCube);
      }
      else
      {
        if(wristEncoderValue < Constants.aim - 25)
        {
          Wrist.moveWrist(Constants.adjustAimUpWithCube);
        }
        else 
        {
          Wrist.moveWrist(Constants.adjustAimDownWithCube);
        }
      }
    }
    else // no cube
    {
      if(reachedAim())
      {
        Wrist.moveWrist(Constants.maintainAim);
      }
      else
      {
        if(wristEncoderValue < Constants.aim - 25)
        {
          Wrist.moveWrist(Constants.adjustAimUp);
        }
        else 
        {
          Wrist.moveWrist(Constants.adjustAimDown);
        }
      }
    }
	}
	
	public static void maintainIdlePosition()
	{
    if(!IntakeWheels.getIntakeBannerSensor()) //with cube
    {
      if(reachedIdle())
      {
        Wrist.moveWrist(Constants.maintainIdleWithcube);
      }
      else
      {
        if(wristEncoderValue < Constants.idle - 25)
        {
          Wrist.moveWrist(Constants.adjustIdleUpWithCube);
        }
        else
        {
          Wrist.stopWrist();
        }
      }
    }
    else //no cube
    {
      if(reachedIdle())
      {
        Wrist.moveWrist(Constants.maintainIdle);
      }
      else
      {
        if(wristEncoderValue < Constants.idle - 25)
        {
          Wrist.moveWrist(Constants.adjustidleUp);
        }
        else
        {
          Wrist.moveWrist(Constants.adjustIdleDown);
        }
      }
    }
	}

	public static void setLimitSwitch()
	{
		limitSwitchState = limitSwitch.get();
	}
	
	public static void testLimitSwitch()
	{
		if(reachedFlat())
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}

}