package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Model.PlayerStatisticsInformation;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PlayersStatisticsWindow extends JFrame
{
	ArrayList<PlayerStatisticsInformation> players = new ArrayList<PlayerStatisticsInformation>();
	JLabel lblTitle;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8349447643209966154L;
	private JTable table;
	DefaultTableModel model;
	
	public PlayersStatisticsWindow() 
    {   
		players = Controller.PlayerStatisticsSingleton.GetInstance().GetPlayersStatistics();
        setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(1000, 1000, 1000, 1000));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46,46,46));		
        
        lblTitle = new JLabel("Players Statistics");
        lblTitle.setFont(new Font("Snap ITC", Font.PLAIN, 20));
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setBounds(376, 55, 227, 62);
        getContentPane().add(lblTitle);
       

	    table = new JTable();
	    table.setForeground(Color.WHITE);
	    table.setBackground(new Color(46,46,46));
	    table.setShowHorizontalLines(false);
	    table.setShowVerticalLines(false);
	    table.setBorder(null);
	    table.setFont(new Font("Snap ITC", Font.PLAIN, 20));
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{"No.","Player Name", "Wins /", " Losess"},
	    	},
	    	new String[] {
	    		"Number","Name", "Wins ", " Losess"
	    	}
	    ) {
	    	/**
			 * 
			 */
			private static final long serialVersionUID = -527233726797028950L;
			boolean[] columnEditables = new boolean[] {
	    		false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    table.getColumnModel().getColumn(0).setResizable(false);
	    table.getColumnModel().getColumn(0).setPreferredWidth(20);
	    table.getColumnModel().getColumn(1).setResizable(false);
	    table.getColumnModel().getColumn(1).setPreferredWidth(67);
	    table.getColumnModel().getColumn(2).setResizable(false);
	    table.getColumnModel().getColumn(2).setPreferredWidth(39);
	    table.getColumnModel().getColumn(3).setResizable(false);
	    table.getColumnModel().getColumn(3).setPreferredWidth(42);
	    table.setBounds(215, 128, 531, 513);	    
	    getContentPane().add(table);
	    model = (DefaultTableModel) table.getModel();
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	    
	    table.getColumnModel().getColumn(0).setCellRenderer( leftRenderer );
	    table.getColumnModel().getColumn(1).setCellRenderer( leftRenderer );	
	    table.getColumnModel().getColumn(2).setCellRenderer( rightRenderer );	
	    table.getColumnModel().getColumn(3).setCellRenderer( leftRenderer );	
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    leftRenderer.setHorizontalAlignment( JLabel.LEFT );
	    rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    model.addRow(new Object[]{"","","",""});
	    model.addRow(new Object[]{"","","",""});
	    int index = 1;
	    for(PlayerStatisticsInformation player: players) 
        {
	    	model.addRow(new Object[]{index++ , player.getName(), player.getWins() + "   /", "   " + player.getLosses()});
	    	model.addRow(new Object[]{"","","",""});
        }	   
	    
	    JButton NextPlayers = new JButton("Next 15 Players");
	    NextPlayers.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	if(model.getRowCount() > 30) {
		            	for (int i = 0 ; i < 30 ; i++)
		            	{
		            		model.removeRow(2);
		            	}
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "No more players");
	            	}
	            }
		});
		
	    NextPlayers.setFont(new Font("Snap ITC", Font.BOLD, 17));
	    NextPlayers.setBackground(new Color(255, 127, 80));
	    NextPlayers.setBounds(464, 688, 210, 62);
		getContentPane().add(NextPlayers);
	    
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
		Back.setBounds(225, 688, 190, 62);
		getContentPane().add(Back);
    }    

	public void NewPlayersStatisticsWindow() 
    {   
		players = Controller.PlayerStatisticsSingleton.GetInstance().GetPlayersStatistics();
        
        while (table.getRowCount() > 3) {
        	model.removeRow(3);
        }

	    int index = 1;
	    for(PlayerStatisticsInformation player: players) 
        {
	    	model.addRow(new Object[]{index++ , player.getName(), player.getWins() + "   /", "   " + player.getLosses()});
	    	model.addRow(new Object[]{"","","",""});
        }	   
    }    
}
