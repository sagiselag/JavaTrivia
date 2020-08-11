package Model;

import java.util.ArrayList;
import java.util.Random;

public class Question {
    //Data Members
    private String m_Question;
    private String m_Difficult;
    private String m_CorrectAns;
    private ArrayList<String> m_Answers;     
       
    //Parameterized Constructor
    public Question(String i_Question,String i_Difficult,String i_CorrectAns,String i_Opt1,String i_Opt2,String i_Opt3)
    {
    	m_Question=i_Question;
    	m_Difficult=i_Difficult;
    	m_CorrectAns=i_CorrectAns;
    	m_Answers = new ArrayList<String>();
    	addAnswersRandomaly(i_CorrectAns, i_Opt1, i_Opt2, i_Opt3);    	
    }
    
    private void addAnswersRandomaly(String i_CorrectAns,String i_Opt1,String i_Opt2,String i_Opt3) 
    {
    	ArrayList<String> answers = new ArrayList<String>();
    	Random rand = new Random();
    	// Obtain a number between [0 - 49].
    	int index;
    	
    	answers.add(i_CorrectAns);
    	answers.add(i_Opt1);
    	answers.add(i_Opt2);
    	answers.add(i_Opt3);
    	    	
    	while (!answers.isEmpty())
    	{
    	index = rand.nextInt(answers.size());
    	m_Answers.add(answers.get(index));
    	answers.remove(index);
    	}    	    	
    }
    
    public String GetQuestion()
    {
    	return m_Question;
    }
    
    public String GetDifficult()
    {
    	return m_Difficult;
    }
    
    public String GetCorrectAns()
    {
    	return m_CorrectAns;
    }
    
    public ArrayList<String> GetAnswers()
    {
    	return m_Answers;
    }
}
