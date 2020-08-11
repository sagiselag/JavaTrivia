package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GameOverWindow extends JFrame
{
	JLabel lblResults;
	JLabel lbl1;
	JLabel lbl2;
	JButton review;
	JButton Ex;
	JButton NewGame;
	JButton NewGameDifferentPlayers;	

	public GameOverWindow() 
    {
        initialize();
    }
    private void initialize()
    {
        Controller.GameManagement.GameOver();
        
        setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));
        
		lblResults = new JLabel(); 
        lblResults.setText("Results");
        lblResults.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        lblResults.setForeground(new Color(255, 255, 255));
        lblResults.setBounds(406, 55, 98, 62);
        getContentPane().add(lblResults);
        
        lbl1 = new JLabel();        
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setBounds(218, 116, 475, 49);        
        lbl1.setForeground(new Color(255, 255, 255));
        lbl1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        getContentPane().add(lbl1);
        
        lbl2 = new JLabel();
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        lbl2.setForeground(new Color(255, 255, 255));
        lbl2.setBounds(218, 194, 475, 49);
        getContentPane().add(lbl2);
        
        
        if(!Controller.GameManagement.Draw())
        {
            lbl1.setText(Controller.GameManagement.GetWinner().getName() + " Win with the "+ Controller.GameManagement.GetWinner().getScore() +" Score.");
            lbl2.setText(Controller.GameManagement.GetLoser().getName() + " Lose with the "+ Controller.GameManagement.GetLoser().getScore() +" Score.");            
        }
        else
        {
            lbl1.setText("It's a draw, Both players score is: " + Controller.GameManagement.GetBoard().GetFirstPlayer().getScore());            
            getContentPane().add(lbl1);
            getContentPane().remove(lbl2);
        }
        
        review = new JButton("Review");
        review.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	setVisible(false);
            	ScreenManagement.ShowReviewWindow();;    
            }
		});
        
		review.setFont(new Font("Snap ITC", Font.BOLD, 17));
		review.setBackground(new Color(255, 127, 80));
		review.setBounds(327, 279, 253, 62);
		getContentPane().add(review);
	        
		Ex = new JButton("Exit");
		Ex.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
	            	ScreenManagement.ShowExitWindow();    
	            }
		});
		
		Ex.setFont(new Font("Snap ITC", Font.BOLD, 17));
		Ex.setBackground(new Color(255, 127, 80));
		Ex.setBounds(327, 633, 253, 62);
		getContentPane().add(Ex);
		
		NewGame = new JButton("<html><center>" + "Same Players" + "<br>" + ""+ "New Game" + "</center><html>");
		NewGame.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
	            	ScreenManagement.ShowGetDifficultyWindow();    
	            }
		});
		
		NewGame.setFont(new Font("Snap ITC", Font.BOLD, 17));
		NewGame.setBackground(new Color(255, 127, 80));
		NewGame.setBounds(327, 363, 253, 69);
		getContentPane().add(NewGame);
		
		NewGameDifferentPlayers = new JButton("<html><center>" + "Different Players" + "<br>" + ""+ "New Game" + "</center><html>");
		NewGameDifferentPlayers.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
	            	ScreenManagement.ShowGetPlayersWindow();   
	            }
		});
		NewGameDifferentPlayers.setFont(new Font("Snap ITC", Font.BOLD, 17));
		NewGameDifferentPlayers.setBackground(new Color(255, 127, 80));
		NewGameDifferentPlayers.setBounds(327, 452, 253, 69);
		getContentPane().add(NewGameDifferentPlayers);
		
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
		Back.setBounds(327, 542, 253, 69);
		getContentPane().add(Back);	    
    }
    
    	
	public void NewGameIsOver()
    {      
		Controller.GameManagement.GameOver();
        lbl2.setVisible(true);
        
        if(!Controller.GameManagement.Draw())
        {
            lbl1.setText(Controller.GameManagement.GetWinner().getName() + " Win with the "+ Controller.GameManagement.GetWinner().getScore() +" Score.");
            lbl2.setText(Controller.GameManagement.GetLoser().getName() + " Lose with the "+ Controller.GameManagement.GetLoser().getScore() +" Score.");            
        }
        else
        {
            lbl1.setText("It's a draw, Both players score is: " + Controller.GameManagement.GetBoard().GetFirstPlayer().getScore());            
            getContentPane().add(lbl1);
            lbl2.setVisible(false);
        }        
    }
}
