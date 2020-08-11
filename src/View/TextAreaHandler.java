package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JTextArea;

public class TextAreaHandler {
	public static JTextArea setAreaHightByText (JTextArea i_TextArea, String i_Text, int i_X, int i_Y, int i_MaxWidth, Font i_Font) {		
		int textheight;
		int textwidth;

		i_TextArea.setText(i_Text);
		i_TextArea.setBackground(new Color(46,46,46));
		i_TextArea.setForeground(new Color(255, 255, 255));
		i_TextArea.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		i_TextArea.setLineWrap(true);
		i_TextArea.setWrapStyleWord(true);
		i_TextArea.setEditable(false);		
		
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);  
		textwidth = (int)(i_Font.getStringBounds(i_Text, frc).getWidth()) / 2;	
				
		if (textwidth / 300 != 0) 
		{
			textheight = (textwidth / 300) * (int)(i_Font.getStringBounds(i_Text, frc).getHeight());
		}
		else
		{
			textheight = (int)(i_Font.getStringBounds(i_Text, frc).getHeight());
		}		
				
		i_TextArea.setBounds(i_X, i_Y, i_MaxWidth,textheight);
		
		return i_TextArea;
	}

}
