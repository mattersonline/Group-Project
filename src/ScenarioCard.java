import java.awt.Color;
import java.awt.Frame;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class ScenarioCard extends GamePlayCard
{
	public ScenarioCard()
	{
		super(new ImageIcon("src/images/stump.png"));
		//super.setBackgroundColor(new Color(0xDECB97));
		super.setBackgroundColor(new Color(0xEBD5B3));
	}
	
	public abstract void runScript();
	public static int displayDialog(String message, String title, Icon icon, Object[] options, Object initialValue){
		return JOptionPane.showOptionDialog(null, 
		message, 
		title, 
		JOptionPane.DEFAULT_OPTION, 
		JOptionPane.PLAIN_MESSAGE, 
		icon, 
		options, 
		initialValue);
	}
	public static void alertDialog(Object alert){
		JOptionPane.showMessageDialog(null, alert);
	}
	public static void refocus(){
		WildernessSurvival.frame.toFront();
		WildernessSurvival.frame.setState(Frame.NORMAL);
		WildernessSurvival.frame.requestFocus();
	}
}
