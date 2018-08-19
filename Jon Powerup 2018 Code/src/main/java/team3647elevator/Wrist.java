package team3647elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import team3647ConstantsAndFunctions.Constants;
import team3647ConstantsAndFunctions.Functions;
import team3647subsystems.Joysticks;

public class Wrist {
	public static int elevatorState, aimedElevatorState;
	public static int wristState, aimedWristState;
	/*
	 * 0. Surya Big Gay
	 * 1. Flat
	 * 2. Aim
	 * 3. Idle
	 */

	public static boolean flat, aim, idle, suryaBigGay, manualOverride, originalPositionButton;
	public static double overrideValue, speed, wristEncoder; 
	public static WPI_TalonSRX wristMotor = new WPI_TalonSRX(Constants.wristPin);
	static DigitalInput limitSwitch = new DigitalInput(Constants.wristLimitSwitch); 
	public static double wristEncoderValue;
	static boolean limitSwitchState;
	

	public static void testWristCurrent()
	{
		System.out.println("Wrist Current: " + wristMotor.getOutputCurrent());
	}
	
	public static void setWristButtons(boolean flatButton, boolean aimButton, boolean idleButton)
	{
		flat = flatButton;
		aim = aimButton;
		idle = idleButton;
	}
	
	public static void moveWrist(double speed)
	{
		wristMotor.set(ControlMode.PercentOutput, speed);
	}
	
	
	public static void stopWrist()
	{
		moveWrist(0);
	}
	
	public static void setManualWristOverride(double jValue)
	{
		if(Math.abs(jValue) <.2 )
		{
			manualOverride = false;
		} 
		else 
		{
			overrideValue = jValue;
			manualOverride = true;
		}
	}
	
	public static void testWristEncoder()
	{
		System.out.println("Wrist Encoder Value: " + wristEncoderValue);
	}
	
	public static void resetWristEncoder()
	{
		wristMotor.getSensorCollection().setQuadraturePosition(0, 10);
	}
	public static void setWristIdle()
	{
		wristMotor.getSensorCollection().setQuadraturePosition(Constants.idle, 10);
	}
	
	public static void setWristEncoder()
	{
		if(reachedFlat())
		{
			resetWristEncoder();
		}
		wristEncoderValue = -wristMotor.getSensorCollection().getQuadraturePosition();
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
			if(wristEncoderValue > Constants.aim - 50 && wristEncoderValue < Constants.aim + 50)
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
			if(wristEncoderValue > Constants.idle - 50 && wristEncoderValue < Constants.idle + 50)
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
		if(reachedAim())
		{
			moveWrist(.15);
		}
		else
		{
			if(wristEncoderValue < Constants.aim)
			{
				moveWrist(0.35);
			}
			else 
			{
				stopWrist();
			}
		}
	}
	
	public static void maintainIdlePosition()
	{
		if(reachedIdle())
		{
			stopWrist();
		}
		else
		{
			if(wristEncoderValue < Constants.idle)
			{
				moveWrist(0.3);
			}
			else
			{
				moveWrist(-0.2);
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

	public static void runWrist()
	{
		switch(wristState)
		{
			case 0://starting code? big gay
				if(reachedFlat())
				{
					stopWrist();
					wristState = 1;
					aimedWristState = 1;
				} 
				else 
				{
					moveWrist(-0.2);
				}
				break;
				//should be below code for final
				//setWristIdle();
			case 1://flat
				if(manualOverride)
				{
					aimedWristState = -1;
				} 
				else if(flat)
				{
					aimedWristState = 1;
				} 
				else if(aim)
				{
					aimedWristState = 2;
				} 
				else if(idle)
				{
					aimedWristState = 3;
				}
				switch(aimedWristState)
				{
					case 1:
						if(reachedFlat())
						{
							stopWrist();
							wristState = 1;
						} 
						else
						{
							moveWrist(-.15);
						}
						break;
					case 2:
						if(reachedAim())
						{
							maintainAimPosition();
							wristState = 2;
						} 
						else
						{
							moveWrist(.2);
						}
						break;
					case 3:
						if(reachedIdle())
						{
							maintainIdlePosition();
							wristState = 3;
						}
						else
						{
						moveWrist(.25);
						}
						break;
					case -1:
						wristState = -1;
						break;
				}					
				break;
		
			case 2://aim
				if(manualOverride)
				{
					aimedWristState = -1;
				} 
				else if(flat)
				{
					aimedWristState = 1;
				}
				else if(aim)
				{
					aimedWristState = 2;
				} 
				else if(idle)
				{
					aimedWristState = 3;
				}
				switch(aimedWristState)
				{
					case 1:
						if(reachedFlat())
						{
							stopWrist();
							wristState = 1;
						}
						else
						{
							moveWrist(-.2);
						}
						break;
					case 2:
							maintainAimPosition();
							wristState = 2;
							break;
					case 3:
						if(reachedIdle())
						{
							maintainIdlePosition();
							wristState = 3;
						} 
						else
						{
							moveWrist(.2);
						}
						break;
					case -1:
						wristState = -1;
						break;
				}
				break;		
				
			case 3://idle
				if(manualOverride)
				{
					aimedWristState = -1;
				}
				else if(flat)
				{
					aimedWristState = 1;
				} else if(aim)
				{
					aimedWristState = 2;
				} 
				else if(idle)
				{
					aimedWristState = 3;
				}
				switch(aimedWristState)
				{
					case 1:
						if(reachedFlat())
						{
							stopWrist();
							wristState = 1;
						} 
						else
						{
							moveWrist(-.2);
						}
						break;
					case 2:
						if(reachedAim())
						{
							maintainAimPosition();
							wristState = 2;
						} 
						else
						{
							moveWrist(.2);
						}
						break;
					case 3:
						maintainIdlePosition();
						wristState = 3;
						break;
					case -1:
						wristState = -1;
						break;
				}
	
			case -1://manual
				if(flat || aim || idle)
				{
					if(flat)
					{
						if(reachedFlat())
						{
							stopWrist();
							wristState = 1;
							aimedWristState = 1;
						} 
						else if(wristEncoderValue>Constants.flat)
						{
							wristState = 2;
							aimedWristState = 1;
						}
					}
					else if(aim)
					{
						if(reachedAim())
						{
							maintainAimPosition();
							wristState = 2;
							aimedWristState = 2;
						}
						else if(wristEncoderValue>Constants.aim)
						{
							wristState = 3;
							aimedWristState = 2;
						}
						else if(wristEncoderValue<Constants.aim)
						{
							wristState = 1;
							aimedWristState = 2;
						}
					}
					else if (idle)
					{
						if(reachedIdle())
						{
							maintainIdlePosition();
							wristState = 3;
							aimedWristState = 3;
						} 
						else if(wristEncoderValue>Constants.idle)
						{
							wristState = 3;
							aimedWristState = 3;
						}
						else if(wristEncoderValue<Constants.idle)
						{
							wristState = 2;
							aimedWristState = 3;
						}
					}
					else
					{
						wristState = -1;
						aimedWristState = -1;
					}
					
				}
				else
				{
					if(!manualOverride)
					{
						overrideValue = 0;
					}
					moveWrist(overrideValue);
			}
			break;
		}
	}
}