package View;

import java.util.TimerTask;

import javax.swing.JTextField;

public class TimerOperation {	
	
	java.util.Timer m_Timer; 
	PlayWindow m_Window;
	JTextField m_timerTextField = new JTextField();
	static int m_Time;
	
	public TimerOperation(PlayWindow i_Window)
	{				
		m_Time = PlayWindow.s_TimerTime;
		m_Window = i_Window;
		m_Timer = Controller.TimerSingleton.GetInstance();		

    	m_timerTextField.setBounds(363, 21, 168, 20);		        
    	m_timerTextField.setColumns(10);    	
    	m_timerTextField.setEditable(false);        
        
		m_Timer.schedule(new TimerTask() {
	        @Override
	        public void run() {	 
	        	m_timerTextField.setText("00 : " + m_Time);
	        	m_Time--;
	        	if(m_Time == 0) {
	        		View.PlayWindow.s_CurrQuestion = Controller.GameManagement.ChangeQuestion();	        			        			        		
	        		PlayWindow.ChangeQuestionOnScreen(m_Window);
	        		ResetTime();
	        	}
	        }
	    }, 1000,1000);
	}
	
	public JTextField GetTextField() {
		return m_timerTextField;
	}
	
	public static void ResetTime() {
		m_Time = PlayWindow.s_TimerTime;
	}
}