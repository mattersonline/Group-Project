import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.border.*;
import javax.swing.*;


public class WildernessSurvival
{
	public static boolean isGameOver = false;
	public static JTextArea logBox;
	public static Human player;
	public static JFrame frame;
	public static JPanel mapPanel;
	public static GUI gui;
	
	public static void log(String text)
	{
		logBox.append(text + "\n");
		// scroll the log area to the bottom so the latest logs are always visible
		// REFERENCE CREDIT: http://stackoverflow.com/questions/6131735/java-scroll-jscrollpane-with-jpanel-within-to-bottom/6132046#6132046
        logBox.scrollRectToVisible(new Rectangle(0,logBox.getHeight(),0,0));
	}
	
	public static void main(String[] args) {
		// initialize player
		WildernessSurvival.player = new Human();
		// initialize gui
		gui = new GUI(new TestMap(10));
	}
}
