package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Question;

class GetRandomQuestionTest {

	@Test
	void test() {
		String player1name = "checkGetRandomQuestionPlayer1", player2name = "checkGetRandomQuestionPlayer2", difficultEasy = "Easy",  difficultNormal = "Normal",  difficultHard = "Hard";
		Question currQuestion, prevQuestion;		
		Controller.GameManagement.SetBoard(player1name, player2name, difficultEasy);	
		int numberOfTrys = 10;

		try {
			currQuestion = Controller.GameManagement.GetRandomQuestion();
			if(!currQuestion.GetDifficult().equals(difficultEasy) && !currQuestion.GetDifficult().equals(difficultNormal)) {
				fail("Easy Game Random Question Difficulty Doesn't match");
				
				prevQuestion = currQuestion;
				currQuestion = Controller.GameManagement.GetRandomQuestion();

				while (numberOfTrys > 0 &&  currQuestion.GetQuestion().equals(prevQuestion.GetQuestion())) {
					currQuestion = Controller.GameManagement.GetRandomQuestion();
					numberOfTrys--;
				}
				if(numberOfTrys == 0) {
					fail("Easy Game Random Question return the same question for 10 times");
				}
			}			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("Can't get random question");
			e.printStackTrace();
		} 
		
		
		Controller.GameManagement.SetBoard(player1name, player2name, difficultHard);
		try {
			currQuestion = Controller.GameManagement.GetRandomQuestion();
			if(!currQuestion.GetDifficult().equals(difficultHard) && !currQuestion.GetDifficult().equals(difficultNormal)) {
				fail("Easy Game Random Question Difficulty Doesn't match");
			}		
			
			prevQuestion = currQuestion;
			currQuestion = Controller.GameManagement.GetRandomQuestion();
			numberOfTrys = 10;
			
			while (numberOfTrys > 0 &&  currQuestion.GetQuestion().equals(prevQuestion.GetQuestion())) {
				currQuestion = Controller.GameManagement.GetRandomQuestion();
				numberOfTrys--;
			}
			if(numberOfTrys == 0) {
				fail("Hard Game Random Question return the same question for 10 times");
			}
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("Can't get random question");
			e.printStackTrace();
		} 
	}

}
