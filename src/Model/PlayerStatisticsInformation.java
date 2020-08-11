package Model;

public class PlayerStatisticsInformation {
	private String m_PlayerName;
	private int m_Wins,m_Losses;
	
	public PlayerStatisticsInformation(String i_PlayerName, int i_Wins, int i_Losses)
	{
		m_PlayerName = i_PlayerName;
		m_Wins = i_Wins;
		m_Losses = i_Losses;
	}
	
	public String getName() {
		return m_PlayerName;
	}
	
	public int getWins() {
		return m_Wins;
	}
	
	public void setWins(int i_value) {
		m_Wins = i_value;
	}
	
	public int getLosses() {
		return m_Losses;
	}
	
	public void setLosses(int i_value) {
		m_Losses = i_value;
	}

}
