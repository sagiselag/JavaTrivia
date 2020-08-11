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
public class MenuWindow extends JFrame
{
    public MenuWindow() 
    {
    	setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));	
		
		JLabel lblMainMenu = new JLabel("Welcome To Java Trivia Game");
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setFont(new Font("Snap ITC", Font.BOLD, 20));
		lblMainMenu.setForeground(new Color(255, 255, 255));
		lblMainMenu.setBounds(262, 189, 480, 62);
		getContentPane().add(lblMainMenu);		
		
		JButton StartGame = new JButton("Start Game");
		StartGame.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
	            	ScreenManagement.ShowGetPlayersWindow();	                
	            }
		});
		
		StartGame.setBackground(new Color(255, 127, 80));		
		StartGame.setFont(new Font("Snap ITC", Font.BOLD, 17));
		StartGame.setBounds(407, 298, 190, 62);
		getContentPane().add(StartGame);
		
		JButton Instruction = new JButton("Instructions");
		Instruction.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	setVisible(false);
            	ScreenManagement.ShowInstructionsWindow();                
            }
	});
	Instruction.setFont(new Font("Snap ITC", Font.BOLD, 17));
	Instruction.setBackground(new Color(255, 127, 80));
	Instruction.setBounds(407, 369, 190, 62);
	getContentPane().add(Instruction);
	
	JButton PlayerStatisticsButton = new JButton("<html><center>Players" + "<br>" +  "Statistics</center></html>");
	PlayerStatisticsButton.setFont(new Font("Snap ITC", Font.BOLD, 17));
	PlayerStatisticsButton.setBackground(new Color(255, 127, 80));
	PlayerStatisticsButton.setBounds(407, 442, 190, 62);
	getContentPane().add(PlayerStatisticsButton);
	
	PlayerStatisticsButton.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
        	setVisible(false);
        	ScreenManagement.ShowPlayersStatisticsWindow();     
        }
});
	
	JButton Ex = new JButton("Exit");
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
	Ex.setBounds(407, 514, 190, 62);
	getContentPane().add(Ex);
    }
}