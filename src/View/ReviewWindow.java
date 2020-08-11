package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ReviewWindow extends JFrame
{	
    public static JLabel lblReview;
    public JLabel lblQuestion;
    public JLabel lblAnswer;
    public JLabel lblOption1;
    public JLabel lblQuestionNumber;
    public JLabel lblDifficulty;
    public int m_QuestionNumber = 1;
    JTextArea questionTextArea = new JTextArea(1,1);
    JTextArea choosenOption1TextArea = new JTextArea(1,1);
    JTextArea correctAnswerTextArea = new JTextArea(1,1);
        
    public ReviewWindow() 
    { 
    	setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));
		
		lblReview = new JLabel("Review Questions");
		lblReview.setForeground(new Color(255, 255, 255));
		lblReview.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblReview.setBounds(356, 11, 246, 36);
        getContentPane().add(lblReview);
                
        lblQuestionNumber= new JLabel("Question Number: "+ m_QuestionNumber);
        lblQuestionNumber.setForeground(new Color(255, 255, 255));
        lblQuestionNumber.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        lblQuestionNumber.setBounds(60, 131, 269, 36);
        getContentPane().add(lblQuestionNumber);
        
        lblDifficulty= new JLabel("Difficulty: "+ Controller.GameManagement.GetBoard().GetQestions().get(m_QuestionNumber-1).GetDifficult());
        lblDifficulty.setForeground(new Color(255, 255, 255));
        lblDifficulty.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        lblDifficulty.setBounds(60, 171, 246, 36);
        getContentPane().add(lblDifficulty);
        
        int hight = 230;
        String text;
        
        text = "Question: "+Controller.GameManagement.GetBoard().GetQestions().get(m_QuestionNumber-1).GetQuestion();
        questionTextArea.setText(text);
		questionTextArea = TextAreaHandler.setAreaHightByText(questionTextArea, text, 60, hight, PlayWindow.s_QuestionsLableWidth, PlayWindow.s_Font);
	    getContentPane().add(questionTextArea);
                   
        		
        hight += questionTextArea.getHeight() + PlayWindow.s_QeustionSpacing;
        text = "Choose Option) "+ getChooseOption();        
        choosenOption1TextArea.setText(text);
        choosenOption1TextArea = TextAreaHandler.setAreaHightByText(choosenOption1TextArea, text, 60, hight, PlayWindow.s_QuestionsLableWidth, PlayWindow.s_Font);
	    getContentPane().add(choosenOption1TextArea);
	    	    
	    
        hight += choosenOption1TextArea.getHeight() + PlayWindow.s_AnswerSpacing;
        text = "Correct Answer) "+Controller.GameManagement.GetBoard().GetQestions().get(m_QuestionNumber-1).GetCorrectAns();                
        correctAnswerTextArea.setText(text);
        correctAnswerTextArea = TextAreaHandler.setAreaHightByText(correctAnswerTextArea, text, 60, hight, PlayWindow.s_QuestionsLableWidth, PlayWindow.s_Font);
	    getContentPane().add(correctAnswerTextArea);
        
		
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener()	 
        {
            public void actionPerformed(ActionEvent e) 
            {		
            	setVisible(false);
            	ScreenManagement.ShowExitWindow();                
            }
		});
		exit.setBackground(new Color(255, 127, 80));
		exit.setForeground(new Color(0, 0, 0));
		exit.setFont(new Font("Snap ITC", Font.BOLD, 17));
		exit.setBounds(106, 595, 190, 62);
		getContentPane().add(exit);
        
        JButton Next = new JButton("Next");
        Next.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(m_QuestionNumber < Controller.GameManagement.GetBoard().GetAllAnswers().size() && m_QuestionNumber < Controller.GameManagement.GetCurrentQuestionNumber() - 1 )
                {
                	m_QuestionNumber++;
                    goToNextQuestion();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You Review All The Questions");
                }
            }
		});
		Next.setFont(new Font("Snap ITC", Font.BOLD, 17));
		Next.setBackground(new Color(255, 127, 80));
		Next.setBounds(525, 595, 190, 62);
		getContentPane().add(Next);
		
		JButton Back = new JButton("<html><center>" +"Back To" + "<br>" +"Main Menu"+ "</center><html>");
		Back.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
	            	ScreenManagement.ShowMenuWindow();	                
	            }
		});
		
		Back.setFont(new Font("Snap ITC", Font.BOLD, 17));
		Back.setBackground(new Color(255, 127, 80));
		Back.setBounds(315, 595, 190, 62);
		getContentPane().add(Back);
	    }
	    
	    public String getChooseOption()
	    {
	    	int ans;
	    	
	    	ans = Controller.GameManagement.answerToInt(Controller.GameManagement.GetBoard().GetAllAnswers().get(m_QuestionNumber-1));
	    	return Controller.GameManagement.GetBoard().GetPlayedQestions().get(m_QuestionNumber-1).GetAnswers().get(ans);
	    }
	    
	    public void goToNextQuestion()
	    {	
	    	Model.Question nextQuestion;	    
	    	lblQuestionNumber.setText("Question Number: "+ m_QuestionNumber);
	    	nextQuestion = Controller.GameManagement.GetBoard().GetPlayedQestions().get(m_QuestionNumber-1);
	        lblDifficulty.setText("Difficulty: "+ nextQuestion.GetDifficult());	        
		    questionTextArea.setText("Question: "+nextQuestion.GetQuestion());
	        choosenOption1TextArea.setText("Choose Option) "+ getChooseOption());
	        correctAnswerTextArea.setText("Correct Answer) "+nextQuestion.GetCorrectAns());
	    }	
	    
	    public void NewGameReview()
	    {	
	    	m_QuestionNumber = 1;
	    	Model.Question nextQuestion;	    
	    	lblQuestionNumber.setText("Question Number: "+ m_QuestionNumber);
	    	nextQuestion = Controller.GameManagement.GetBoard().GetPlayedQestions().get(m_QuestionNumber-1);
//	    	nextQuestion = Controller.GameManagement.GetBoard().GetQestions().get(m_QuestionNumber-1);
	        lblDifficulty.setText("Difficulty: "+ nextQuestion.GetDifficult());	        
		    questionTextArea.setText("Question: "+nextQuestion.GetQuestion());
	        choosenOption1TextArea.setText("Choose Option) "+ getChooseOption());
	        correctAnswerTextArea.setText("Correct Answer) "+nextQuestion.GetCorrectAns());
	    }	
}
