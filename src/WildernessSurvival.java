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
	public static TestMap map;
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
		for(int i = 0; i < 10; i++)
		{
			player.addInventoryItem(new HealthItem(player.getInventory().length));
		}
		// initialize map
		map = new TestMap(10);
		// initialize gui
		gui = new GUI();
		
		
/*		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		mapPanel = map.getMapPanel();
		frame.add(mapPanel, BorderLayout.CENTER);
		logBox = new JTextArea();
		JPanel statusPanel = new JPanel(new BorderLayout());
		// REFERENCE CREDIT: http://stackoverflow.com/questions/1052473/scrollbars-in-jtextarea/1053036#1053036
		JScrollPane logPane = new JScrollPane(logBox);
		statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 75));
		statusPanel.add(logPane, BorderLayout.CENTER);
		frame.add(statusPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		// display map
		frame.setVisible(true);
		frame.addKeyListener(WildernessSurvival);
		WildernessSurvival.log("Game started...");*/
//		
//		// start game loop
//		try
//		{
//			long pauseTime = 250;
//			
//			Direction currentDirection = Direction.NORTH;
//			int directionSwitch = 0;
//			Random randomDirectionSwitcher = new Random();
//			while(!isGameOver)
//			{
//				directionSwitch = randomDirectionSwitcher.nextInt(5);
//				
//				switch(directionSwitch)
//				{
//					case 0:
//						currentDirection = Direction.NORTH;
//						break;
//					case 1:
//						currentDirection = Direction.EAST;
//						break;
//					case 2:
//						currentDirection = Direction.SOUTH;
//						break;
//					case 3:
//						currentDirection = Direction.WEST;
//						break;
//				}
//				if(map.movePlayer(currentDirection))
//				{
//					frame.remove(mapPanel);
//					mapPanel = map.getMapPanel();
//					WildernessSurvival.log("Player moved to " + map.getPlayerLocation().getXCoordinate() + "," + map.getPlayerLocation().getYCoordinate());
//					frame.add(mapPanel);
//					// REFERENCE CREDIT: http://stackoverflow.com/questions/8608902/the-correct-way-to-swap-a-component-in-java/8608955#8608955
//					frame.revalidate();
//					frame.repaint();
//
//					isGameOver = map.isFinished();
//				}
//				else
//				{
//					WildernessSurvival.log("Player tried to go to an invalid spot");
//				}
//
//				if(player.getHealth() <= 0)
//				{
//					isGameOver = true;
//					WildernessSurvival.log("GAME OVER! YOU DIED!");
//				}
//				
//				Thread.sleep(pauseTime);
//			}
//		} 
//		catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
