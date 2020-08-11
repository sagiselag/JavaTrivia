package Controller;

import Model.PlayersStatisticsFileHandler;;

public class PlayerStatisticsSingleton {
	private static PlayersStatisticsFileHandler m_PlayersStatisticsFileHandler;
	
	//Singleton pattern to read/write from csv
	private PlayerStatisticsSingleton()
	{
		
	}
	
	public static PlayersStatisticsFileHandler GetInstance()
	{
		if(m_PlayersStatisticsFileHandler == null)
		{
			m_PlayersStatisticsFileHandler = new PlayersStatisticsFileHandler();
		}
		
		return m_PlayersStatisticsFileHandler;
	}
}