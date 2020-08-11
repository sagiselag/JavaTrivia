package Controller;

import java.util.Timer;

public class TimerSingleton 
{	
	private static Timer s_TimerSingleton;
	
	//Singleton pattern to read/write from csv
	private TimerSingleton()
	{
		
	}
	
	public static Timer GetInstance()
	{
		if(s_TimerSingleton == null)
		{
			s_TimerSingleton = new Timer();
		}
		
		return s_TimerSingleton;
	}	
}