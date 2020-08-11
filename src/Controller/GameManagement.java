package Controller;

import java.util.ArrayList;

import java.util.Random;

import javax.swing.JOptionPane;
import Model.PlayBoard;
import Model.Question;
import Model.Player;

public class GameManagement {
	private static PlayBoard m_PlayBoard = null;
	private static ArrayList<Question> m_AvailableQuestions = null;
	private static int m_Time = 30;
    private static int m_QuestionNum=1;
    private static boolean m_FirstGame = true;
    private static Question s_currQuestion = new Question(null, null, null, null, null, null);
    
    public static void SetBoard(String i_FirstPlayerName, String i_SecondPlayerName, String i_PlayDifficult)
    {    	
    	m_PlayBoard = new PlayBoard(i_FirstPlayerName, i_SecondPlayerName, i_PlayDifficult); 
    	m_AvailableQuestions = new ArrayList<Question>(m_PlayBoard.GetQestions());
    	m_Time = 30;
        m_QuestionNum=1; 
        m_FirstGame = false;
    }
    
    public static boolean IsFirstGame() {
    	return m_FirstGame;
    }
    
    public static PlayBoard GetBoard() {
    	return m_PlayBoard;
    }
    
    public static Question GetRandomQuestion() throws Exception 
    {
    	Question rndQuestion;
    	Random rand = new Random();    	
    	int index;
    	String difficulty;
    	
    	if(m_PlayBoard.GetDifficult() == "Easy") {
    		if(m_QuestionNum <= 25)
    		{
    			difficulty = "Easy";
    		}
    		else {
    			difficulty = "Normal";
    		}
    	}
    	else if(m_PlayBoard.GetDifficult() == "Hard") {
    		if(m_QuestionNum > 25)
    		{
    			difficulty = "Hard";
    		}
    		else {
    			difficulty = "Normal";
    		}
    	}
    	else {
    		throw new Exception("illigal difficulty");
    	}
    	
    	do 
    	{
    	index = rand.nextInt(m_AvailableQuestions.size());
    	}
    	while (!m_AvailableQuestions.get(index).GetDifficult().contains(difficulty) && m_AvailableQuestions.size() != 0);    	

    	rndQuestion = m_AvailableQuestions.get(index);
    	m_AvailableQuestions.remove(index);

    	return rndQuestion;
    }
    
    public static int answerToInt(String i_Ans) {
    	int ans = -1;
    	Player p1, p2;
    	
    	p1 = m_PlayBoard.GetFirstPlayer();
    	p2 = m_PlayBoard.GetSecondPlayer();

    	if(i_Ans.equals(p1.getFirstAnswerButton()) || i_Ans.equals(p2.getFirstAnswerButton()))
    	{
    		ans = 0;
    	}
    	
    	if(i_Ans.equals(p1.getSecondAnswerButton()) || i_Ans.equals(p2.getSecondAnswerButton()))
    	{
    		ans = 1;
    	}
    	else if(i_Ans.equals(p1.getThirdAnswerButton()) || i_Ans.equals(p2.getThirdAnswerButton()))
    	{
    		ans = 2;
    	}
    	else if(i_Ans.equals(p1.getFourthAnswerButton()) || i_Ans.equals(p2.getFourthAnswerButton()))
    	{
    		ans = 3;
    	}
    	
    	return ans;
    }
    
    public static void AnswerInput(String i_Ans, Player i_Player, Question i_Question) {
    	int index;
    	
    	m_PlayBoard.GetAllAnswers().add(i_Ans);
    	m_PlayBoard.GetPlayedQestions().add(i_Question);
    	index = answerToInt(i_Ans);    	
    	
    	if(i_Question.GetCorrectAns().equals(i_Question.GetAnswers().get(index))) {
    		i_Player.setScore(i_Player.getScore() + 1);
    	}
    	else {
    		i_Player.setScore(i_Player.getScore() - 2);
    	}

    	m_Time = 30;
    }
    
    public static Player GetWinner() {
    	Player player;
    	if(GetBoard().GetFirstPlayer().getScore() > GetBoard().GetSecondPlayer().getScore()) {
    		player = GetBoard().GetFirstPlayer();
    	}
    	else {
    		player = GetBoard().GetSecondPlayer();
    	}
    	
    	return player;
    }  
    
    public static Player GetLoser() {
    	Player player;
    	if(GetBoard().GetFirstPlayer().getScore() < GetBoard().GetSecondPlayer().getScore()) {
    		player = GetBoard().GetFirstPlayer();
    	}
    	else {
    		player = GetBoard().GetSecondPlayer();
    	}
    	
    	return player;
    }    
    
    public static boolean Draw() {
    	boolean ans = true;
    	if(GetBoard().GetFirstPlayer().getScore() != GetBoard().GetSecondPlayer().getScore()) {
    		ans = false;
    	}    	
    	
    	return ans;
    }  
    
    public static int GetTime() { 
    	return m_Time;
    }
    
    public static int GetCurrentQuestionNumber() { 
    	return m_QuestionNum;
    }
    
    public static void IncCurrentQuestionNumber() { 
    	m_QuestionNum++;
    }    
    
    public static void GameOver() {    	
    	PlayerStatisticsSingleton.GetInstance().Update(GetWinner().getName(), GetLoser().getName());    	
    }        
    
    public static void NewGame(String i_FirstPlayerName, String i_SecondPlayerName, String i_PlayDifficult)
    {    
    	m_PlayBoard.NewGame(i_FirstPlayerName, i_SecondPlayerName, i_PlayDifficult);
    	m_AvailableQuestions.removeAll(m_AvailableQuestions);
    	m_PlayBoard.GetPlayedQestions().removeAll(m_PlayBoard.GetPlayedQestions());
    	m_AvailableQuestions = m_PlayBoard.GetQestions();
    	m_Time = 30;
        m_QuestionNum=0;       
    }

    public static Question ChangeQuestion()
    {       	
    	int questionNumber = GetCurrentQuestionNumber();
    	
        IncCurrentQuestionNumber();
        
    	if (questionNumber < GetBoard().GetQestions().size()) {
	    	try {	    		    
	    		s_currQuestion = GetRandomQuestion();	    
//	            s_Timer.ResetTime();
	    	}
	        catch (Exception e)
	        {
	            JOptionPane.showMessageDialog(null, e.toString());
	        }       	
    	}
    	 

    	return s_currQuestion;
    }
}
