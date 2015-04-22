import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class GUI extends JFrame implements KeyListener 
{
	public JPanel mapPanel;
	public JTextArea logBox;
	
	public GUI()
	{
		// initialize GUI
		this.mapPanel = new JPanel();
		this.logBox = new JTextArea();
		
		this.setLayout(new BorderLayout());
		this.add(this.mapPanel, BorderLayout.CENTER);
		JPanel statusPanel = new JPanel(new BorderLayout());
		// REFERENCE CREDIT: http://stackoverflow.com/questions/1052473/scrollbars-in-jtextarea/1053036#1053036
		JScrollPane logPane = new JScrollPane(this.logBox);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 75));
		statusPanel.add(logPane, BorderLayout.CENTER);
		this.add(statusPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		// display map
		this.setMapPanel(WildernessSurvival.map.getMapPanel());
		this.addKeyListener(this);
		// CREDIT: http://stackoverflow.com/questions/286727/java-keylistener-for-jframe-is-being-unresponsive
		this.setFocusable(true);
		this.setVisible(true);
		this.log("Game started...");
	}
	
	public void setMapPanel(JPanel mapPanel)
	{
		this.remove(this.mapPanel);
		this.mapPanel = mapPanel;
		this.add(this.mapPanel);
		this.revalidate();
		this.repaint();
	}

	public void log(String text)
	{
		logBox.append(text + "\n");
		// scroll the log area to the bottom so the latest logs are always visible
		// REFERENCE CREDIT: http://stackoverflow.com/questions/6131735/java-scroll-jscrollpane-with-jpanel-within-to-bottom/6132046#6132046
        logBox.scrollRectToVisible(new Rectangle(0,logBox.getHeight(),0,0));
	}
	
	@Override
	public void keyPressed(KeyEvent ke) { }

	@Override
	public void keyReleased(KeyEvent ke) 
	{
		int key = ke.getKeyCode();
		Direction currentDirection = Direction.NORTH;
		switch(key)
		{
			case KeyEvent.VK_UP:
				currentDirection = Direction.NORTH;
				break;
			case KeyEvent.VK_RIGHT:
				currentDirection = Direction.EAST;
				break;
			case KeyEvent.VK_DOWN:
				currentDirection = Direction.SOUTH;
				break;
			case KeyEvent.VK_LEFT:
				currentDirection = Direction.WEST;
				break;
			default:
				this.log("Invalid Input!");
		}
		
		if(WildernessSurvival.map.movePlayer(currentDirection))
		{
			int x = WildernessSurvival.map.getPlayerLocation().getXCoordinate();
			int y = WildernessSurvival.map.getPlayerLocation().getYCoordinate();
			this.log("Player moved to " + x  + "," + y);
			
			if(WildernessSurvival.map.isFinished())
			{
				this.removeKeyListener(this);
				this.log("Player has finished the game...");
			}
			else if(WildernessSurvival.player.getHealth() <= 0)
			{
				this.removeKeyListener(this);
				this.log("GAME OVER! YOU DIED!");
			}
		}
		else
		{
			this.log("Player tried to go to an invalid spot");
		}
		this.setMapPanel(WildernessSurvival.map.getMapPanel());
	}

	@Override
	public void keyTyped(KeyEvent ke) { }
}
