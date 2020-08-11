package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Question;

class ChangeQuestionTest {

	@Test
	void test() {
		String player1name = "checkGetRandomQuestionPlayer1", player2name = "checkGetRandomQuestionPlayer2", difficultEasy = "Easy", difficultHard = "Hard";
		Question currQuestion, prevQuestion;	
		
		Controller.GameManagement.SetBoard(player1name, player2name, difficultEasy);	
		

		try {
			prevQuestion = Controller.GameManagement.ChangeQuestion();
			currQuestion = Controller.GameManagement.ChangeQuestion();
			if(currQuestion.GetQuestion().equals(prevQuestion.GetQuestion())) {
				fail("Easy Game Change Question Failed");
			}		
			
			Controller.GameManagement.SetBoard(player1name, player2name, difficultHard);	
			prevQuestion = Controller.GameManagement.ChangeQuestion();
			currQuestion = Controller.GameManagement.ChangeQuestion();
			if(currQuestion.GetQuestion().equals(prevQuestion.GetQuestion())) {
				fail("Hard Game Change Question Failed");
			}		
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("Can't get question");
			e.printStackTrace();
		} 
	}
}
