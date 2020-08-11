package Model;

import java.util.ArrayList;

import Controller.QuestionFileSingleton;

public class PlayBoard {
	private Player m_Player1, m_Player2;
	private String m_PlayDifficult;
	private ArrayList<Question> m_GameQuestions;	   
	private ArrayList<String> m_AllAnswers = new ArrayList<String>();
	private ArrayList<Question> m_PlayedGameQuestions = new ArrayList<Question>();
	
	public PlayBoard(String i_FirstPlayerName, String i_SecondPlayerName, String i_PlayDifficult) 
	{
		m_PlayDifficult = i_PlayDifficult;
		m_GameQuestions = new ArrayList<Question>();
		m_GameQuestions = QuestionFileSingleton.GetInstance().GetQuestions(m_GameQuestions, i_PlayDifficult);
		m_Player1 = new Player(i_FirstPlayerName, "a", "s", "d", "f");
		m_Player2 = new Player(i_SecondPlayerName, "g", "h", "j", "k");
	}
	
	public Player GetFirstPlayer() {
		return m_Player1;
	}
	
	public Player GetSecondPlayer() {
		return m_Player2;
	}
	
	public String GetDifficult() {
		return m_PlayDifficult;
	}
	
	public ArrayList<String> GetAllAnswers() {
		return m_AllAnswers;
	}
	
	public ArrayList<Question> GetQestions() {
		return m_GameQuestions;
	}
	
	public ArrayList<Question> GetPlayedQestions() {
		return m_PlayedGameQuestions;
	}
	
	public void NewGame(String i_FirstPlayerName, String i_SecondPlayerName, String i_PlayDifficult)
	{
		m_PlayDifficult = i_PlayDifficult;
		m_GameQuestions.removeAll(m_GameQuestions);
		m_GameQuestions = QuestionFileSingleton.GetInstance().GetQuestions(m_GameQuestions, i_PlayDifficult);
		m_Player1.setScore(0);
		m_Player2.setScore(0);
		m_Player1.setName(i_FirstPlayerName);
		m_Player2.setName(i_SecondPlayerName);
	}
}
