package Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class QestionsFileHandler {			
	//Read 50 Question From the file on the basis of Level
    public ArrayList<Question> GetQuestions(ArrayList<Question> i_GameQuestions, String i_Difficulty) 
    {    
    	final String s_InFileEndOfPreviousCellColumnIndicator = "<EndOfPreviousCellColumn>";
    	final String s_CSVtoTXTEndOfPreviousCellColumnIndicator = ",";
    	final String s_EndOfPreviousCellColumnIndicator = s_CSVtoTXTEndOfPreviousCellColumnIndicator + s_InFileEndOfPreviousCellColumnIndicator + s_CSVtoTXTEndOfPreviousCellColumnIndicator;
    	final int s_InformationColumnNumber = 6;
    	
    	int m_lineNumber = 1;    	    	
    	BufferedReader reader;
    	String line;
    	String[] data;
        
    	try 
        {
//        	Since Questions could include commas (,) and Questions file built is easier as an CSV Excel file
//        	in order to update the questions bank please make sure to keep the question column pattern and put "<EndOfPreviousCellColumn>" between every 2 columns
//    		in addition please make sure to avoid new lines inside the cell - use \n instead
        	
        	
        	reader = new BufferedReader(new FileReader("QuestionsFileSavedAsTXTinsteadCSV.txt")); //read from file.
            line = reader.readLine(); //read one line
            while (line != null) 
            {
            	data = line.split(s_EndOfPreviousCellColumnIndicator);  
            	            
            	// data correction check
            	if(data.length != s_InformationColumnNumber) {
            		JOptionPane.showMessageDialog(null, "line = " +m_lineNumber + "\t  size = " + data.length + "\nQeustion \n" + data[0] + "\n Please remove new lines and put \"\\n\" instead");
            	}
            	m_lineNumber++;
            	
            	if(i_Difficulty.equalsIgnoreCase(data[1]) || "Normal".equalsIgnoreCase(data[1])) //if difficulty match
            	{
            		Question question = new Question(data[0],data[1],data[2],data[3],data[4],data[5]);
            		i_GameQuestions.add(question); //add that question in the array list
            	}
            	
            	line = reader.readLine(); //read next line
            }
            
            reader.close();            
        }
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error! can't open QuestionsFileSavedAsTXTinsteadCSV.txt file");
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }    
        
        return i_GameQuestions;
    }   
}



