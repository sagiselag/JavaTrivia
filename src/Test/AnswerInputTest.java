package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Question;

class AnswerInputTest {

	@Test
	void test() {
		String player1name = "checkGetRandomQuestionPlayer1", player2name = "checkGetRandomQuestionPlayer2", difficultEasy = "Easy";
				
		Controller.GameManagement.SetBoard(player1name, player2name, difficultEasy);	
		Question currQuestion;
		int correctAnswervalue = 1, wrongAnswervalue = -2, correctScore;
		
		correctScore = correctAnswervalue + (3 * wrongAnswervalue);
		
		try {
				currQuestion = Controller.GameManagement.GetRandomQuestion();
				
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetFirstPlayer().getFirstAnswerButton(), Controller.GameManagement.GetBoard().GetFirstPlayer(), currQuestion);
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetFirstPlayer().getSecondAnswerButton(), Controller.GameManagement.GetBoard().GetFirstPlayer(), currQuestion);
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetFirstPlayer().getThirdAnswerButton(), Controller.GameManagement.GetBoard().GetFirstPlayer(), currQuestion);
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetFirstPlayer().getFourthAnswerButton(), Controller.GameManagement.GetBoard().GetFirstPlayer(), currQuestion);
				
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetSecondPlayer().getFirstAnswerButton(), Controller.GameManagement.GetBoard().GetSecondPlayer(), currQuestion);
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetSecondPlayer().getSecondAnswerButton(), Controller.GameManagement.GetBoard().GetSecondPlayer(), currQuestion);
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetSecondPlayer().getThirdAnswerButton(), Controller.GameManagement.GetBoard().GetSecondPlayer(), currQuestion);
				Controller.GameManagement.AnswerInput(Controller.GameManagement.GetBoard().GetSecondPlayer().getFourthAnswerButton(), Controller.GameManagement.GetBoard().GetSecondPlayer(), currQuestion);
				
				if (Controller.GameManagement.GetBoard().GetFirstPlayer().getScore() != correctScore)
					fail("Falit in claculating the First Player Score");
				if (Controller.GameManagement.GetBoard().GetSecondPlayer().getScore() != correctScore)
					fail("Falit in claculating the Second Player Score");
				
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
				
	}
}