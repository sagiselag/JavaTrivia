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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GetPlayersWindow extends JFrame
{    
    private JTextField player1name;
    private JTextField player2name;
    public static String name1="";
    public static String name2="";
    public static int score1=0;
    public static int score2=0;       
    
    public GetPlayersWindow() 
    {    
    	setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));		
		
		JLabel lblEnterYourName = new JLabel("Please enter both players names");
		lblEnterYourName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourName.setForeground(new Color(255, 255, 255));
		lblEnterYourName.setFont(new Font("Snap ITC", Font.BOLD, 20));
		lblEnterYourName.setBounds(261, 157, 480, 36);
		getContentPane().add(lblEnterYourName);
		
		JLabel lblPlayerOneControls = new JLabel("Player 1  keys: A - S - D - F");
		lblPlayerOneControls.setForeground(new Color(255, 255, 255));
		lblPlayerOneControls.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerOneControls.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblPlayerOneControls.setBounds(281, 222, 430, 36);
		getContentPane().add(lblPlayerOneControls);
		
		JLabel lblPlayerTwoControls = new JLabel("Player 2 keys: G - H - J - K");
		lblPlayerTwoControls.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerTwoControls.setForeground(new Color(255, 255, 255));
		lblPlayerTwoControls.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblPlayerTwoControls.setBounds(281, 262, 430, 36);
		getContentPane().add(lblPlayerTwoControls);
			
		JLabel lblPlayer_1 = new JLabel("Player 1 :");
		lblPlayer_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer_1.setForeground(new Color(255, 255, 255));
		lblPlayer_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblPlayer_1.setBounds(281, 342, 94, 36);
		getContentPane().add(lblPlayer_1);
			
		JLabel lblPlayer_2 = new JLabel("Player 2 :");
		lblPlayer_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer_2.setForeground(Color.WHITE);
		lblPlayer_2.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblPlayer_2.setBounds(281, 392, 94, 36);
		getContentPane().add(lblPlayer_2);
	        
		player1name = new JTextField();
		player1name.setHorizontalAlignment(SwingConstants.LEFT);
		player1name.setBounds(390, 352, 168, 20);
		getContentPane().add(player1name);
		player1name.setColumns(10);
			
		player2name = new JTextField();
		player2name.setHorizontalAlignment(SwingConstants.LEFT);
		player2name.setColumns(10);
		player2name.setBounds(390, 402, 168, 20);
		getContentPane().add(player2name);
	        
	        if(!name1.isEmpty())
	        {
	            player1name.setText(name1);
	        }
	        if(!name2.isEmpty())
	        {
	            player2name.setText(name2);
	        }
	        
		JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {		
	                name1 = player1name.getText();
	                name2 = player2name.getText();
	                if(name1.isEmpty())
	                {
	                    JOptionPane.showMessageDialog(null, "Please Enter Player 1 Name.");
	                }
	                else if(name2.isEmpty())
	                {
	                    JOptionPane.showMessageDialog(null, "Please Enter Player 2 Name.");
	                }
	                else if(!name1.chars().allMatch(Character::isLetter)) {
	                	JOptionPane.showMessageDialog(null, "Please Use Only Characters For Player 1 Name.");
	                }
	                else if(!name2.chars().allMatch(Character::isLetter)) {
	                	JOptionPane.showMessageDialog(null, "Please Use Only Characters For Player 2 Name.");
	                }
	                else
	                {
	                	setVisible(false);
	                	ScreenManagement.s_FirstPlayerName = name1;
	                	ScreenManagement.s_SecondPlayerName = name2;
	                	ScreenManagement.ShowGetDifficultyWindow();	                    
	                }
	            }
		});
		
		Next.setBackground(new Color(255, 127, 80));
		Next.setForeground(new Color(0, 0, 0));
		Next.setFont(new Font("Snap ITC", Font.BOLD, 17));
		Next.setBounds(546, 532, 184, 62);
		getContentPane().add(Next);
	        
	        JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	setVisible(false);
                	ScreenManagement.ShowMenuWindow();;	       
	            }
		});
		Back.setFont(new Font("Snap ITC", Font.BOLD, 17));
		Back.setBackground(new Color(255, 127, 80));
		Back.setBounds(266, 532, 184, 62);
		getContentPane().add(Back);	        
		
    }
}
