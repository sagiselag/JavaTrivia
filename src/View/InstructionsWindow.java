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
public class InstructionsWindow extends JFrame
{
	private String[] m_InstructionsText = {
			"Easy - 25 easy questions + 25 normal questions.", 
			"Hard - 25 normal questions + 25 hard questions.",
			"Each question contains 4 possible answers.",
			"Correct answer will increase the score in 1 point.",
			"Incorrect answer will decrease the score by 2 points.",
			"An unanswered question will be cancelled."};
	private int m_X = 200, m_H = 80;
	
	public InstructionsWindow() 
    {
    	setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));	
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Snap ITC", Font.BOLD, 20));
		lblInstructions.setForeground(new Color(255, 255, 255));
		lblInstructions.setBounds(369, 79, 275, 60);
		getContentPane().add(lblInstructions);
		
		for (String line : m_InstructionsText) {
		    JLabel label = new JLabel(line);		    
		    label.setHorizontalAlignment(SwingConstants.LEFT);
		    label.setFont(new Font("Ariel", Font.BOLD, 16));
		    label.setForeground(new Color(255, 255, 255));
		    label.setBounds(300, m_X, 480, m_H);		    
			getContentPane().add(label);
			m_X += 20;
		    m_H += 20;
		}
		
		JButton Back = new JButton("Back");
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
		Back.setBounds(38, 607, 190, 62);
		getContentPane().add(Back);
    }
}
