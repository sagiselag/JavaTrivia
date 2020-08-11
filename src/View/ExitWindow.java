package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ExitWindow extends JFrame
{
	public ExitWindow() 
    {    
		setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));	
        
        JLabel lblSeeYouSoon = new JLabel("Thanks For Playing, see you soon :)");
        lblSeeYouSoon.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeeYouSoon.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        lblSeeYouSoon.setForeground(new Color(255, 255, 255));
        lblSeeYouSoon.setBounds(258, 285, 471, 106);
        getContentPane().add(lblSeeYouSoon);
    }
}
