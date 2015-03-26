import java.awt.*;
import java.util.Random;

import javax.swing.border.*;
import javax.swing.*;


public class WildernessSurvival {

	public static void main(String[] args) {
		// initialize player
		// initialize map
		TestMap map = new TestMap(10);
		// initialize gui
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		JPanel mapPanel = map.getMapPanel();
		frame.add(mapPanel, BorderLayout.CENTER);
		JLabel statusBar = new JLabel();
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.add(statusBar);
		frame.add(statusPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		// display map
		frame.setVisible(true);
		statusBar.setText("Game started...");
		
		// start game loop
		try
		{
			long pauseTime = 250;
			boolean isGameOver = false;
			Direction currentDirection = Direction.NORTH;
			int directionSwitch = 0;
			Random randomDirectionSwitcher = new Random();
			while(!isGameOver)
			{
				directionSwitch = randomDirectionSwitcher.nextInt(5);
				
				switch(directionSwitch)
				{
					case 0:
						currentDirection = Direction.NORTH;
						break;
					case 1:
						currentDirection = Direction.EAST;
						break;
					case 2:
						currentDirection = Direction.SOUTH;
						break;
					case 3:
						currentDirection = Direction.WEST;
						break;
				}
				if(map.movePlayer(currentDirection))
				{
					frame.remove(mapPanel);
					mapPanel = map.getMapPanel();
					statusBar.setText("Player moved to " + map.getPlayerLocation().getXCoordinate() + "," + map.getPlayerLocation().getYCoordinate());
					frame.add(mapPanel);
					// REFERENCE CREDIT: http://stackoverflow.com/questions/8608902/the-correct-way-to-swap-a-component-in-java/8608955#8608955
					frame.revalidate();
					frame.repaint();

					isGameOver = map.isFinished();
				}
				else
				{
					statusBar.setText("Player tried to go to an invalid spot");
				}
				
				Thread.sleep(pauseTime);
			}
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		statusBar.setText("Player has finished the game...");
	}

}
