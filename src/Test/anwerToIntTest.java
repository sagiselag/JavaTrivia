package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Player;

class anwerToIntTest {	
	
	@Test
	void test() {
		String player1name = "anwerToIntTestPlayer1", player2name = "anwerToIntTestPlayer2", difficultEasy = "Easy",  difficultHard = "Hard";	
		Controller.GameManagement.SetBoard(player1name, player2name, difficultEasy);
		check(difficultEasy);
		
		Controller.GameManagement.SetBoard(player1name, player2name, difficultHard);
		check(difficultHard);
		   		
	}
	
	private void check(String i_Difficult) {
		int ans = 0;
		Player p1, p2;
		
		p1 = Controller.GameManagement.GetBoard().GetFirstPlayer();
		p2 = Controller.GameManagement.GetBoard().GetSecondPlayer();
		
		ans = Controller.GameManagement.answerToInt(p1.getFirstAnswerButton());
		if (ans != 0) fail(i_Difficult + "\t" + "Falit in convert First Player First Answer Button");
		ans = Controller.GameManagement.answerToInt(p2.getFirstAnswerButton());
		if (ans != 0) fail(i_Difficult + "\t" + "Falit in convert Second Player First Answer Button");			
		
		ans = Controller.GameManagement.answerToInt(p1.getSecondAnswerButton());
		if (ans != 1) fail(i_Difficult + "\t" + "Falit in convert First Player Second Answer Button");
		ans = Controller.GameManagement.answerToInt(p2.getSecondAnswerButton());
		if (ans != 1) fail(i_Difficult + "\t" + "Falit in convert Second Player Second Answer Button");
		
		ans = Controller.GameManagement.answerToInt(p1.getThirdAnswerButton());
		if (ans != 2) fail(i_Difficult + "\t" + "Falit in convert First Player Third Answer Button");
		ans = Controller.GameManagement.answerToInt(p2.getThirdAnswerButton());
		if (ans != 2) fail(i_Difficult + "\t" + "Falit in convert Second Player Third Answer Button");
		
		ans = Controller.GameManagement.answerToInt(p1.getFourthAnswerButton());
		if (ans != 3) fail(i_Difficult + "\t" + "Falit in convert First Player Fourth Answer Button");
		ans = Controller.GameManagement.answerToInt(p2.getFourthAnswerButton());
		if (ans != 3) fail(i_Difficult + "\t" + "Falit in convert Second Player Fourth Answer Button");
	}
}