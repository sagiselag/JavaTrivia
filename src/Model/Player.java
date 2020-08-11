package Model;
import java.util.*;

public class Player extends Observable {
	private String m_Name;
	private int m_Score;
	private String m_FirstAnswerButton, m_SecondAnswerButton, m_ThirdAnswerButton, m_FourthAnswerButton;
	
	public Player (String i_Name, String i_Button1, String i_Button2, String i_Button3, String i_Button4) {
		m_Name = i_Name.substring(0,1).toUpperCase() + i_Name.substring(1).toLowerCase();
		m_Score = 0;
		m_FourthAnswerButton = i_Button4;
		m_ThirdAnswerButton = i_Button3;
		m_SecondAnswerButton = i_Button2;
		m_FirstAnswerButton = i_Button1;
	}
	
	public String getName() {
		return m_Name;
	}
	
	public void setName(String i_Name) {
		m_Name = i_Name;
	}

	public int getScore() {
		return m_Score;
	}
	
	public void setScore(int m_Score) {
		this.m_Score = m_Score;
	}
	
	public String getFourthAnswerButton() {
		return m_FourthAnswerButton;
	}

	public String getThirdAnswerButton() {
		return m_ThirdAnswerButton;
	}

	public String getSecondAnswerButton() {
		return m_SecondAnswerButton;
	}

	public String getFirstAnswerButton() {
		return m_FirstAnswerButton;
	}	
}
