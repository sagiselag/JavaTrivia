package Controller;

import Model.QestionsFileHandler;

public class QuestionFileSingleton 
{
	private static QestionsFileHandler m_QuestionFileSingleton;
		
		//Singleton pattern to read/write from csv
		private QuestionFileSingleton()
		{
			
		}
		
		public static QestionsFileHandler GetInstance()
		{
			if(m_QuestionFileSingleton == null)
			{
				m_QuestionFileSingleton = new QestionsFileHandler();
			}
			
			return m_QuestionFileSingleton;
		}
}
