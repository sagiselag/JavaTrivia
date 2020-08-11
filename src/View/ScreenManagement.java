package View;

public class ScreenManagement {
	public static String s_FirstPlayerName = "";
	public static String s_SecondPlayerName = "";
	private static MenuWindow s_MenuWindow= null;
	private static GetPlayersWindow s_GetPlayersWindow = null;
	private static InstructionsWindow s_InstructionsWindow = null;
	private static GetDifficultyWindow s_GetDifficultyWindow = null;
	private static ExitWindow s_ExitWindow = null;
	private static PlayWindow s_PlayWindow = null;
	private static GameOverWindow s_GameOverWindow = null;
	private static ReviewWindow s_ReviewWindow = null;
	private static PlayersStatisticsWindow s_PlayersStatisticsWindow = null;	
		
	public static void ShowMenuWindow()
	{
		if(s_MenuWindow == null) {
			s_MenuWindow = new MenuWindow();
		}		
		s_MenuWindow.setVisible(true);
	}	
	
	public static void ShowGetPlayersWindow()
	{		
		s_MenuWindow.setVisible(false);
		
		if(s_GetPlayersWindow == null) {
			s_GetPlayersWindow = new GetPlayersWindow();
		}
		s_GetPlayersWindow.setVisible(true);
	}
	
	public static void ShowInstructionsWindow()
	{		
		s_MenuWindow.setVisible(false);
		
		if(s_InstructionsWindow == null) {
			s_InstructionsWindow = new InstructionsWindow();
		}
		s_InstructionsWindow.setVisible(true);
	}
	
	public static void ShowGetDifficultyWindow()
	{				
		if(s_GetDifficultyWindow == null) {
			s_GetDifficultyWindow = new GetDifficultyWindow();
		}
		s_GetDifficultyWindow.setVisible(true);
	}
	
	public static void ShowExitWindow()
	{				
		if(s_ExitWindow == null) {
			s_ExitWindow = new ExitWindow();
		}
		s_ExitWindow.setVisible(true);
	}
	
	public static void ShowPlayWindow()
	{				
		if(s_PlayWindow == null) {
			s_PlayWindow = new PlayWindow();
		}
		s_PlayWindow.setVisible(true);
	}
	
	public static void ShowNewPlayWindow()
	{				
		if(s_PlayWindow == null) {
			s_PlayWindow = new PlayWindow();
		}
		PlayWindow.NewGame(s_PlayWindow);		
		s_PlayWindow.setVisible(true);
	}
	
	public static void ShowGameOverWindow()
	{			
    	if(s_GameOverWindow != null) {
    		s_GameOverWindow.NewGameIsOver();
        }
		if(s_GameOverWindow == null) {
			s_GameOverWindow = new GameOverWindow();
		}
		s_GameOverWindow.setVisible(true);
	}
	
	public static void ShowReviewWindow()
	{
    	if(s_ReviewWindow != null) {
    		s_ReviewWindow.NewGameReview();
        }
    	
		if(s_ReviewWindow == null) {
			s_ReviewWindow = new ReviewWindow();
		}
		s_ReviewWindow.setVisible(true);
	}
	
	public static void ShowPlayersStatisticsWindow()
	{		
    	if(s_PlayersStatisticsWindow != null) {
    		s_PlayersStatisticsWindow.NewPlayersStatisticsWindow();
        }
    	
		if(s_PlayersStatisticsWindow == null) {
			s_PlayersStatisticsWindow = new PlayersStatisticsWindow();
		}
		s_PlayersStatisticsWindow.setVisible(true);
	}
	
}
