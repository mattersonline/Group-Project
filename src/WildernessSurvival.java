import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.border.*;
import javax.swing.*;


public class WildernessSurvival
{
	public static boolean isGameOver = false;
	public static Human player;
	public static GUI gui;
	
	public static void main(String[] args) {
		// initialize player
		WildernessSurvival.player = new Human();
		// initialize gui
		gui = new GUI(new TestMap(10));
	}
}
