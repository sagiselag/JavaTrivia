package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.GameManagement;
import Model.Question;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PlayWindow extends JFrame
{
    public static JLabel lblRemainingTime;
    public static JLabel lblPlayer1;
    public static JLabel lblPlayer2;
    public static JLabel lblScore1;
    public static JLabel lblScore2;
    public static JLabel lblButtons1;
    public static JLabel lblButtons2;
    public static JLabel lblQuestionNumber;
    public static JLabel lblDifficulty;  
    public static JTextArea questionTextArea;
    public static JTextArea option1TextArea;
    public static JTextArea option2TextArea;
    public static JTextArea option3TextArea;
    public static JTextArea option4TextArea;
    public static JTextArea thisTextArea;        
    public static int questionNum=0;
    public static JTextField answerField;
    public static String s_Answer = null;    
    public static String[] s_FirstPlayerButtons = new String[4];
    public static String[] s_SecondPlayerButtons = new String[4];
    public static Model.Question s_CurrQuestion = null;
    public static Font s_Font = new Font("Snap ITC", Font.PLAIN, 20);
    public static int s_QuestionsLableWidth = 800, s_QeustionSpacing = 30, s_AnswerSpacing = 10;
    public static int s_TimerTime = 30;
    private static TimerOperation s_Timer;
    
    public PlayWindow() 
    {       	    	
    	PlayWindow window = this;    	
    	
    	s_Timer = new TimerOperation(this); 
    	getContentPane().add(s_Timer.GetTextField());
    	s_Timer.GetTextField().setVisible(true);
    	
    	setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));
		
		SetPlayersButtons();
		
        lblRemainingTime = new JLabel("Remaining Time is: ");
        lblRemainingTime.setForeground(new Color(255, 255, 255));
        lblRemainingTime.setFont(s_Font);
        lblRemainingTime.setBounds(113, 11, 246, 36);
        getContentPane().add(lblRemainingTime);
        
        
        lblPlayer1= new JLabel("Player 1: " + Controller.GameManagement.GetBoard().GetFirstPlayer().getName());
        lblPlayer1.setForeground(new Color(255, 255, 255));
        lblPlayer1.setFont(s_Font);
        lblPlayer1.setBounds(60, 51, 246, 36);
        getContentPane().add(lblPlayer1);
        
        
        lblPlayer2= new JLabel("Player 2: "+ Controller.GameManagement.GetBoard().GetSecondPlayer().getName());
        lblPlayer2.setForeground(new Color(255, 255, 255));
        lblPlayer2.setFont(s_Font);
        lblPlayer2.setBounds(60, 91, 246, 36);
        getContentPane().add(lblPlayer2);
        
        
        lblScore1= new JLabel("Score: "+ Controller.GameManagement.GetBoard().GetFirstPlayer().getScore());
        lblScore1.setForeground(new Color(255, 255, 255));
        lblScore1.setFont(s_Font);
        lblScore1.setBounds(360, 51, 246, 36);
        getContentPane().add(lblScore1);
        
        
        lblScore2= new JLabel("Score: "+ Controller.GameManagement.GetBoard().GetSecondPlayer().getScore());
        lblScore2.setForeground(new Color(255, 255, 255));
        lblScore2.setFont(s_Font);
        lblScore2.setBounds(360, 91, 246, 36);
        getContentPane().add(lblScore2);
        
        
        String FirstPlayerButtons =  s_FirstPlayerButtons[0] + "," + s_FirstPlayerButtons[1] + "," + s_FirstPlayerButtons[2] + "," + s_FirstPlayerButtons[3];
        
        String SecondPlayerButtons =  s_SecondPlayerButtons[0] + "," + s_SecondPlayerButtons[1] + "," + s_SecondPlayerButtons[2] + "," + s_SecondPlayerButtons[3];
        
        lblButtons1= new JLabel("Buttons: "+ FirstPlayerButtons);
        lblButtons1.setForeground(new Color(255, 255, 255));
        lblButtons1.setFont(s_Font);
        lblButtons1.setBounds(660, 51, 246, 36);
        getContentPane().add(lblButtons1);
        
        lblButtons2= new JLabel("Buttons: "+ SecondPlayerButtons);
        lblButtons2.setForeground(new Color(255, 255, 255));
        lblButtons2.setFont(s_Font);
        lblButtons2.setBounds(660, 91, 246, 36);
        getContentPane().add(lblButtons2);
        
        lblQuestionNumber= new JLabel();
        lblQuestionNumber.setText("Question Number: " + Controller.GameManagement.GetCurrentQuestionNumber());
        lblQuestionNumber.setForeground(new Color(255, 255, 255));
        lblQuestionNumber.setFont(s_Font);
        lblQuestionNumber.setBounds(60, 131, 500, 36);
        getContentPane().add(lblQuestionNumber);
        
        
        try {
        	s_CurrQuestion = Controller.GameManagement.GetRandomQuestion();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }   
        
        
        lblDifficulty= new JLabel();
        lblDifficulty.setText("Difficulty: " + s_CurrQuestion.GetDifficult());
        lblDifficulty.setForeground(new Color(255, 255, 255));
        lblDifficulty.setFont(s_Font);
        lblDifficulty.setBounds(60, 171, 246, 36);
        getContentPane().add(lblDifficulty);
        
              
                                
        int hight = 230;
        String text;
        
        text = "Question: " + s_CurrQuestion.GetQuestion();        
		questionTextArea = new JTextArea(text,1,1);
		questionTextArea = TextAreaHandler.setAreaHightByText(questionTextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    getContentPane().add(questionTextArea);
                   
        		
        hight += questionTextArea.getHeight() + s_QeustionSpacing;
        text = "A / G ) " + s_CurrQuestion.GetAnswers().get(0);
        option1TextArea = new JTextArea(text,1,1);
        option1TextArea = TextAreaHandler.setAreaHightByText(option1TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    getContentPane().add(option1TextArea);
	    
	    
        hight += option1TextArea.getHeight() + s_AnswerSpacing;
        text = "S / H ) " + s_CurrQuestion.GetAnswers().get(1);
        option2TextArea = new JTextArea(text,1,1);
        option2TextArea = TextAreaHandler.setAreaHightByText(option2TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    getContentPane().add(option2TextArea);
        
        
        hight += option2TextArea.getHeight() + s_AnswerSpacing;
        text = "D / J ) " + s_CurrQuestion.GetAnswers().get(2);
        option3TextArea = new JTextArea(text,1,1);
        option3TextArea = TextAreaHandler.setAreaHightByText(option3TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    getContentPane().add(option3TextArea);
        

        hight += option3TextArea.getHeight() + s_AnswerSpacing;
        text = "F / K ) " + s_CurrQuestion.GetAnswers().get(3);
        option4TextArea = new JTextArea(text,1,1);
        option4TextArea = TextAreaHandler.setAreaHightByText(option4TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    getContentPane().add(option4TextArea);
        
        
	    hight += option4TextArea.getHeight() + 50;
        answerField = new JTextField();
        this.addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
            	answerField.requestFocus();
            }
        }); 
		answerField.setBounds(60, hight, 168, 20);
		getContentPane().add(answerField);
		answerField.setColumns(10);	
        		        
        answerField.addKeyListener(new KeyAdapter() 
        {
        	ArrayList<KeyEvent> pressedKeys = new ArrayList<KeyEvent>();         	
        	
            public void keyReleased(KeyEvent e) 
            {            	
				/*
				 * we can see the logic to get the first key pressed is working //
				 * JOptionPane.showMessageDialog(null, "Number Of  Pressed Keys" +
				 * pressedKeys.size()); // for (KeyEvent key : pressedKeys) { //
				 * JOptionPane.showMessageDialog(null, "Key Pressed: " + key.getKeyChar()); // }
				 */
            	
            	if (Character.toString(e.getKeyChar()).equals( s_Answer)) 
            	{               		
					while (pressedKeys.size() != 1) {		
						pressedKeys.remove(1);
						answerField.setFocusable(false);
					}         		            		               		            												
					pressedKeys.remove(0);
            		answerField.setEditable(true);
                    answerField.setText("");
                    Controller.GameManagement.GetBoard().GetAllAnswers().add(s_Answer);                                                   
                    answerField.setFocusable(true);
                    
                     if(s_Answer.equalsIgnoreCase(s_FirstPlayerButtons[0]) || s_Answer.equalsIgnoreCase(s_FirstPlayerButtons[1]) || s_Answer.equalsIgnoreCase(s_FirstPlayerButtons[2]) || s_Answer.equalsIgnoreCase(s_FirstPlayerButtons[3]))
                     {                    	 
                     	questionNum = Controller.GameManagement.GetCurrentQuestionNumber();        		        		
                         s_CurrQuestion = Controller.GameManagement.ChangeQuestion();             	        
                     	Controller.GameManagement.AnswerInput(s_Answer, Controller.GameManagement.GetBoard().GetFirstPlayer(), s_CurrQuestion);                       	
                         lblScore1.setText("Player 1: "+Controller.GameManagement.GetBoard().GetFirstPlayer().getScore());                    
                         NextScreen(window, s_CurrQuestion);                                 

                     }
                     else if(s_Answer.equalsIgnoreCase(s_SecondPlayerButtons[0]) || s_Answer.equalsIgnoreCase(s_SecondPlayerButtons[1]) || s_Answer.equalsIgnoreCase(s_SecondPlayerButtons[2]) || s_Answer.equalsIgnoreCase(s_SecondPlayerButtons[3]))
                     {                    	 
                     	questionNum = Controller.GameManagement.GetCurrentQuestionNumber();        		        		
                         s_CurrQuestion = Controller.GameManagement.ChangeQuestion();
                     	Controller.GameManagement.AnswerInput(s_Answer, Controller.GameManagement.GetBoard().GetSecondPlayer(), s_CurrQuestion);                    
                         lblScore2.setText("Player 2: "+Controller.GameManagement.GetBoard().GetSecondPlayer().getScore());                  
                         NextScreen(window, s_CurrQuestion);                        
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null, "Please Enter Corect Option");
                         answerField.setText("");
                     }                  
            	}                   	
            	while (pressedKeys.size() != 1 && pressedKeys.size() > 0) {		
					pressedKeys.remove(0);		
				} 
            }
            
            public void keyPressed(KeyEvent e) {
            	char ans = 'm';            	            	            	            	
            	
            	if (!pressedKeys.contains(e)) 
            	{
            		pressedKeys.add(e);			
            	}
            	
            	answerField.setEditable(false);            	            	
            	
            	if (pressedKeys.size() == 1) 
            		{            		
            		ans = pressedKeys.get(0).getKeyChar();
            		s_Answer = Character.toString(ans);
            		}            	            	
                // Invoked when a key has been pressed.                
            }
        });
       
        JButton Ex = new JButton("End");
        Ex.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	setVisible(false);
                ScreenManagement.ShowGameOverWindow();
            }
		});
        
		Ex.setFont(s_Font);
		Ex.setBackground(new Color(255, 127, 80));
		Ex.setBounds(60, 782, 184, 47);
		getContentPane().add(Ex);		
		
//		answerField.requestFocusInWindow();
//		answerField.setFocusable(true);
    }    
    
    public static void NextScreen(PlayWindow i_Window, Question i_Question) {
        if(i_Question != null)
        {
            ChangeQuestionOnScreen(i_Window);   	       
        }
        else
        {
        	i_Window.setVisible(false);
            ScreenManagement.ShowGameOverWindow();
        }           
    }

    public static void ChangeQuestionOnScreen(PlayWindow i_Window)
    {   
    	int questionNumber;    	
    	questionNumber = GameManagement.GetCurrentQuestionNumber();
    	
    	if (questionNumber <= GameManagement.GetBoard().GetQestions().size())
    	{
    		lblQuestionNumber.setText("Question Number: "+ questionNumber);	
	    	lblDifficulty.setText("Difficulty: "+ s_CurrQuestion.GetDifficult());
	    	
	    	String text;
	    	int hight = 230;
	    	
	    	text = "Question: "+s_CurrQuestion.GetQuestion();
		    questionTextArea = TextAreaHandler.setAreaHightByText(questionTextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
		    
	    	hight += questionTextArea.getHeight() + s_QeustionSpacing; 
	    	text = "A / G ) " + s_CurrQuestion.GetAnswers().get(0);
	    	option1TextArea = TextAreaHandler.setAreaHightByText(option1TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    	    	
	    	hight += option1TextArea.getHeight() + s_AnswerSpacing; 
	    	text = "S / H ) " + s_CurrQuestion.GetAnswers().get(1);
	    	option2TextArea = TextAreaHandler.setAreaHightByText(option2TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    	
	    	hight += option2TextArea.getHeight() + s_AnswerSpacing; 
	    	text = "D / J ) " + s_CurrQuestion.GetAnswers().get(2);
	    	option3TextArea = TextAreaHandler.setAreaHightByText(option3TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	    	    	
	    	hight += option3TextArea.getHeight() + s_AnswerSpacing; 
	    	text = "F / K ) " + s_CurrQuestion.GetAnswers().get(3);
	    	option4TextArea = TextAreaHandler.setAreaHightByText(option4TextArea, text, 60, hight, s_QuestionsLableWidth, s_Font);
	
	    	hight += option4TextArea.getHeight() + 50; 
	        answerField.setText("");
	        answerField.setBounds(60, hight, 168, 20);	    
	        
	        TimerOperation.ResetTime();		  
	        
			answerField.requestFocusInWindow();
			answerField.setFocusable(true);

    	}
    	else {
        	i_Window.setVisible(false);
        	ScreenManagement.ShowGameOverWindow();   
    	}
    }
    
    public static void SetPlayersButtons() {
    	s_FirstPlayerButtons[0] = Controller.GameManagement.GetBoard().GetFirstPlayer().getFirstAnswerButton(); 
    	s_FirstPlayerButtons[1] = Controller.GameManagement.GetBoard().GetFirstPlayer().getSecondAnswerButton();
    	s_FirstPlayerButtons[2] = Controller.GameManagement.GetBoard().GetFirstPlayer().getThirdAnswerButton(); 
    	s_FirstPlayerButtons[3] = Controller.GameManagement.GetBoard().GetFirstPlayer().getFourthAnswerButton();
    	
    	s_SecondPlayerButtons[0] = Controller.GameManagement.GetBoard().GetSecondPlayer().getFirstAnswerButton(); 
    	s_SecondPlayerButtons[1] = Controller.GameManagement.GetBoard().GetSecondPlayer().getSecondAnswerButton();
    	s_SecondPlayerButtons[2] = Controller.GameManagement.GetBoard().GetSecondPlayer().getThirdAnswerButton(); 
    	s_SecondPlayerButtons[3] = Controller.GameManagement.GetBoard().GetSecondPlayer().getFourthAnswerButton();
    }
    
    public static void NewGame(PlayWindow i_Window) {
        lblPlayer1.setText("Player 1: " + Controller.GameManagement.GetBoard().GetFirstPlayer().getName());        
        lblPlayer2.setText("Player 2: "+ Controller.GameManagement.GetBoard().GetSecondPlayer().getName());
        lblScore1.setText("Score: "+ Controller.GameManagement.GetBoard().GetFirstPlayer().getScore());
        lblScore2.setText("Score: "+ Controller.GameManagement.GetBoard().GetSecondPlayer().getScore()); 
        ChangeQuestionOnScreen(i_Window);	
    }
    
    public static TimerOperation GetTimer(){
    	return s_Timer;
    }
    
    public void SetTimer(TimerOperation value){
    	s_Timer = value;
    }
    
}
