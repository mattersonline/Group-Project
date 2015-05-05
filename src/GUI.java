import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements KeyListener 
{
	private JPanel mapPanel;
	private JTextArea logBox;
	private JProgressBar healthBar;
	private JProgressBar hungerBar;
	
	public GUI()
	{
		// initialize GUI
		this.mapPanel = new JPanel();
		this.logBox = new JTextArea();
		this.healthBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		this.healthBar.setPreferredSize(new Dimension(110,15));
		this.hungerBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		this.hungerBar.setPreferredSize(new Dimension(110,15));
		this.setLayout(new BorderLayout());
		
		// setup the map panel
		this.add(this.mapPanel, BorderLayout.CENTER);
		// display map
		this.setMapPanel(WildernessSurvival.map.getMapPanel());

		// setup the log area
		JPanel statusPanel = new JPanel(new BorderLayout());
		// REFERENCE CREDIT: http://stackoverflow.com/questions/1052473/scrollbars-in-jtextarea/1053036#1053036
		JScrollPane logPane = new JScrollPane(this.logBox);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 150));
		statusPanel.add(logPane, BorderLayout.CENTER);
		this.add(statusPanel, BorderLayout.SOUTH);
		
		//setup the right side of the gui
		JPanel rightPanel = new JPanel(new GridLayout(2,1));
		rightPanel.setPreferredSize(new Dimension(125, this.getHeight()));
		
		// health panel
		JPanel healthPanel = new JPanel(new FlowLayout());
		healthPanel.add(new JLabel("Health"));
		healthPanel.add(this.healthBar);
		healthPanel.add(new JLabel("Hunger"));
		healthPanel.add(this.hungerBar);
		this.updateHealthBar();
		
		// inventory panel
		JPanel inventoryPanel = new JPanel(new GridLayout(3,2));
		JLabel healthButton = new JLabel(new ImageIcon("src/images/firstaid.png"));
		healthButton.setPreferredSize(new Dimension(75,75));
		inventoryPanel.add(healthButton);
		inventoryPanel.add(new JLabel("x 0"));
		JLabel weaponButton = new JLabel(new ImageIcon("src/images/dynamite.png"));
		weaponButton.setPreferredSize(new Dimension(75,75));
		inventoryPanel.add(weaponButton);
		inventoryPanel.add(new JLabel("x 0"));
		JLabel foodButton = new JLabel(new ImageIcon("src/images/fruit.png"));
		foodButton.setPreferredSize(new Dimension(75,75));
		inventoryPanel.add(foodButton);
		inventoryPanel.add(new JLabel("x 0"));
		
		// add healthPanel to right side
		rightPanel.add(healthPanel);
		
		// add inventory panel to the right side
		rightPanel.add(inventoryPanel);
		
		// add the right side
		this.add(rightPanel, BorderLayout.EAST);
		
		// finish setting up the gui before displaying
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		// CREDIT: http://stackoverflow.com/questions/286727/java-keylistener-for-jframe-is-being-unresponsive
		this.setFocusable(true);
		this.setVisible(true);
		this.log("Game started...");
	}
	
	public void updateHealthBar()
	{
		int playerHealth = WildernessSurvival.player.getHealth();
		int playerHunger = WildernessSurvival.player.getEnergy();
		if(playerHealth > 100) playerHealth = 100;
		if(playerHealth < 0) playerHealth = 0;
		if(playerHunger > 100) playerHunger = 100;
		if(playerHunger < 0) playerHunger = 0;
		
		this.healthBar.setForeground(this.getColor(playerHealth));
		this.hungerBar.setForeground(this.getColor(playerHunger));
		this.healthBar.setValue(playerHealth);
		this.hungerBar.setValue(playerHunger);
	}
	
	private Color getColor(int value)
	{
		if(value > 60)
		{
			return Color.GREEN;
		}
		else if(value > 25)
		{
			return Color.ORANGE;
		}
		else
		{
			return Color.RED;
		}
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
	public void keyPressed(KeyEvent ke) 
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
	public void keyReleased(KeyEvent ke) { }

	@Override
	public void keyTyped(KeyEvent ke) { }
	
}
