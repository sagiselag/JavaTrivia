package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PlayersStatisticsFileHandler {
	
	private File PlayersStatistics = null;  // use Singleton to make sure we will create this file only ones		
	private static boolean s_WinnerIsListed = false, s_LoserIsListed = false;
    
	private void Read(String i_WinnerPlayerName, String i_LoserPlayerName, ArrayList<PlayerStatisticsInformation> io_Players) {
		BufferedReader reader;
    	String line;
    	String[] data;
    	int wins, losses;
		// get file information
        try 
        {
            reader = new BufferedReader(new FileReader("PlayersStatistics.txt")); //read from file.
            line = reader.readLine(); // Read first line
            line = reader.readLine(); //read one line            

            while (line != null) 
            {    
            	data = line.split(",");  
            	data[0] = data[0].substring(0,1).toUpperCase() + data[0].substring(1).toLowerCase();
            	data[1] = removeNotDigits(data[1]);            	
            	data[2] = removeNotDigits(data[2]);            	
            	wins = Integer.parseInt(data[1]);
            	losses = Integer.parseInt(data[2]);
            	if(data[0].contentEquals(i_WinnerPlayerName))
            	{
            		io_Players.add(new PlayerStatisticsInformation(data[0],wins+1,losses)); //add that player in the array list
            		s_WinnerIsListed = true;
            	}
            	else if(data[0].contentEquals(i_LoserPlayerName)) 
            	{
            		io_Players.add(new PlayerStatisticsInformation(data[0],wins,losses+1)); //add that player in the array list
            		s_LoserIsListed = true;
            	}
            	else 
            	{
            		io_Players.add(new PlayerStatisticsInformation(data[0],wins,losses)); //add that player in the array list
            	}
            	line = reader.readLine(); //read next line
            }
            
            reader.close(); 
        }
        
        catch (IOException e)
        {           
        }        
	}
	
	private void Write(String i_WinnerPlayerName, String i_LoserPlayerName, ArrayList<PlayerStatisticsInformation> i_Players) {		
    	//ArrayList<PlayerStatisticsInformation> players = new ArrayList<PlayerStatisticsInformation>();    	
    	String fileContent = new String();
        BufferedWriter writer; //write for write in the file.
		
		if(!s_WinnerIsListed) 
    	{
        	i_Players.add(new PlayerStatisticsInformation(i_WinnerPlayerName,1,0)); //add winner player in the array list             	
    	}
        
        if(!s_LoserIsListed) 
    	{
        	i_Players.add(new PlayerStatisticsInformation(i_LoserPlayerName,0,1)); //add loser player in the array list     
    	}
    	 
        // write updated information
        try 
        {        	
			writer = new BufferedWriter(new FileWriter("PlayersStatistics.txt"));
			fileContent = "Player Name, Wins, Losses";			
	        writer.write(fileContent);
	        writer.newLine();
	        writer.close();
	        for (PlayerStatisticsInformation player : i_Players) 
	        {
	        	writer = new BufferedWriter(new FileWriter("PlayersStatistics.txt",true));
	        	fileContent = player.getName() + ", Wins: " + player.getWins() + ", Losses: " + player.getLosses();	        	
	            writer.write(fileContent);	
	            writer.newLine();
	            writer.close();
	        }
	        
	        writer.close();	 	        
		} 
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}              
	}
	
	//write data in the file
    public void Update(String i_WinnerPlayerName, String i_LoserPlayerName)
    {    	
    	ArrayList<PlayerStatisticsInformation> players = new ArrayList<PlayerStatisticsInformation>();    	
    	s_WinnerIsListed = false; 
    	s_LoserIsListed = false;     
    	
        // create file if not exist
    	if(PlayersStatistics == null)
    	{
    		PlayersStatistics = new File("PlayersStatistics.txt");
    	}
    	
    	Read(i_WinnerPlayerName, i_LoserPlayerName, players);  
    	Write(i_WinnerPlayerName, i_LoserPlayerName, players);    	
    }    
    
    private static String removeNotDigits(String i_Str) 
    {    	
    	for(int  index = 0; index < i_Str.length() ; index++) {
    		if (!Character.isDigit(i_Str.charAt(index)))
    		{
    			i_Str=i_Str.replaceFirst(String.valueOf(i_Str.charAt(index)),""); 
    			index--;
    		}	
    	}
    	return i_Str;
    }

	public ArrayList<PlayerStatisticsInformation> GetPlayersStatistics() {
		ArrayList<PlayerStatisticsInformation> players = new ArrayList<PlayerStatisticsInformation>();
		BufferedReader reader;
    	String line;
    	String[] data;
    	int wins, losses;
    	
		// get file information
        try 
        {
            reader = new BufferedReader(new FileReader("PlayersStatistics.txt")); //read from file.
            line = reader.readLine(); // Read first line
            line = reader.readLine(); //read one line            

            while (line != null) 
            {    
            	data = line.split(",");  
            	data[0] = data[0].substring(0,1).toUpperCase() + data[0].substring(1).toLowerCase();
            	data[1] = removeNotDigits(data[1]);            	
            	data[2] = removeNotDigits(data[2]);            	
            	wins = Integer.parseInt(data[1]);
            	losses = Integer.parseInt(data[2]);
            	players.add(new PlayerStatisticsInformation(data[0],wins,losses)); //add that player in the array list
            	line = reader.readLine(); //read next line
            }
            
            reader.close(); 
        }
        
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error - Players Statistics File doesn't exsist");
        }     
        
        return players;
	}
}
