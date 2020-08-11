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
public class GetDifficultyWindow extends JFrame
{             
    public GetDifficultyWindow() 
    {    
    	setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));	
		
		JLabel lblChooseYourDifficulty = new JLabel("Choose play difficulty mode");
		lblChooseYourDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourDifficulty.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblChooseYourDifficulty.setForeground(new Color(255, 255, 255));
		lblChooseYourDifficulty.setBounds(251, 168, 480, 62);
        getContentPane().add(lblChooseYourDifficulty);			
		
		JButton btneasy = new JButton("Easy");
		btneasy.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e)
	            {	            	
	            	if(!Controller.GameManagement.IsFirstGame()) {
	                	Controller.GameManagement.NewGame(ScreenManagement.s_FirstPlayerName, ScreenManagement.s_SecondPlayerName, "Easy");
	                	setVisible(false);
	                	ScreenManagement.ShowNewPlayWindow();
	                }
	            	Controller.GameManagement.SetBoard(ScreenManagement.s_FirstPlayerName, ScreenManagement.s_SecondPlayerName, "Easy");	            	
	                setVisible(false);
	            	ScreenManagement.ShowPlayWindow();	   
	            }
		});
		btneasy.setBackground(new Color(255, 127, 80));
		btneasy.setFont(new Font("Snap ITC", Font.BOLD, 17));
		btneasy.setBounds(396, 323, 190, 62);
		getContentPane().add(btneasy);
			
		JButton btnhard = new JButton("Hard");
		btnhard.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	if(!Controller.GameManagement.IsFirstGame()) {
	                	Controller.GameManagement.NewGame(ScreenManagement.s_FirstPlayerName, ScreenManagement.s_SecondPlayerName, "Hard");
	                	setVisible(false);
	                	ScreenManagement.ShowNewPlayWindow();
	                }
	            	Controller.GameManagement.SetBoard(ScreenManagement.s_FirstPlayerName, ScreenManagement.s_SecondPlayerName, "Hard");
	                setVisible(false);	                
	                ScreenManagement.ShowPlayWindow();	   
	            }
		});
		btnhard.setFont(new Font("Snap ITC", Font.BOLD, 17));
		btnhard.setBackground(new Color(255, 127, 80));
		btnhard.setBounds(396, 403, 190, 62);
		getContentPane().add(btnhard);
	        
	        JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
	            	ScreenManagement.ShowGetPlayersWindow();
	            }
		});
		Back.setFont(new Font("Snap ITC", Font.BOLD, 17));
		Back.setBackground(new Color(255, 127, 80));
		Back.setBounds(28, 614, 190, 62);
		getContentPane().add(Back);
	    }
}
