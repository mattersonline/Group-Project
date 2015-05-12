import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class GUI extends JFrame implements KeyListener, MouseListener
{
	public JPanel mapPanel;
	private JTextArea logBox;
	private JProgressBar healthBar;
	private JProgressBar hungerBar;
	private Map map;
	private MapTile currentPlayerLocation;
	private JPanel statusPanel;
	private JPanel alertPanel;
	
	public GUI(Map map)
	{
		// initialize GUI
		this.map = map;
		int mapSize = this.map.getSize();
		this.mapPanel = new JPanel(new GridLayout(mapSize,mapSize));
		this.mapPanel.addMouseListener(this);
		this.logBox = new JTextArea();
		this.healthBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		this.healthBar.setPreferredSize(new Dimension(110,15));
		this.hungerBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		this.hungerBar.setPreferredSize(new Dimension(110,15));
		this.setLayout(new BorderLayout());
		this.currentPlayerLocation = this.map.getStart();
		this.alertPanel = new JPanel(new BorderLayout());
		this.alertPanel.setBorder(new LineBorder(Color.RED,3));
		
		// setup the map panel
		this.add(this.mapPanel, BorderLayout.CENTER);

		// setup the log area
		statusPanel = new JPanel(new BorderLayout());
		// REFERENCE CREDIT: http://stackoverflow.com/questions/1052473/scrollbars-in-jtextarea/1053036#1053036
		JScrollPane logPane = new JScrollPane(this.logBox);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 150));
		statusPanel.add(logPane, BorderLayout.CENTER);
		
		JPanel directionButtonsPanel = new JPanel(new BorderLayout());
		
		JButton leftButton = new JButton(new ImageIcon("src/images/leftarrow.png"));
		leftButton.addMouseListener(new MoveButtonListener(Direction.WEST));
		
		JButton upButton = new JButton(new ImageIcon("src/images/forwardarrow.png"));
		upButton.addMouseListener(new MoveButtonListener(Direction.NORTH));
		
		JButton rightButton = new JButton(new ImageIcon("src/images/rightarrow.png"));
		rightButton.addMouseListener(new MoveButtonListener(Direction.EAST));
		
		JButton downButton = new JButton(new ImageIcon("src/images/backarrow.png"));
		downButton.addMouseListener(new MoveButtonListener(Direction.SOUTH));
		
		directionButtonsPanel.add(leftButton, BorderLayout.WEST);
		directionButtonsPanel.add(upButton, BorderLayout.NORTH);
		directionButtonsPanel.add(rightButton, BorderLayout.EAST);
		directionButtonsPanel.add(downButton, BorderLayout.SOUTH);
		
		statusPanel.add(directionButtonsPanel, BorderLayout.EAST);
		
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
		
		// display map
		this.setupMapPanel();
		this.showCard(this.map.getStart(), new ImageIcon("src/images/player.png"));
		// CREDIT: http://stackoverflow.com/questions/286727/java-keylistener-for-jframe-is-being-unresponsive
		this.setFocusable(true);
		this.setVisible(true);
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
	
	public void setupMapPanel()
	{
		int mapSize = this.map.getSize();
		Card currentCard = null;
		JLabel cardSlot = null;
		
		for(int y = 0; y < mapSize; y++)
		{
			for(int x = 0; x < mapSize; x++)
			{
				currentCard = this.map.getCard(x, y);
				cardSlot = new JLabel();
				cardSlot.setHorizontalAlignment(JLabel.CENTER); // center content in the JLabel
				cardSlot.setSize(25,40);
				//cardSlot.setBorder(new LineBorder(Color.BLACK));
				
				// if not a visited card
				//cardSlot.setBackground(Color.DARK_GRAY);
				cardSlot.setBackground(new Color(0xC28944));
				cardSlot.setForeground(Color.DARK_GRAY);
				// CREDIT for setting background: http://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color/2380328#2380328
				cardSlot.setOpaque(true); // so background color will show
				
				this.mapPanel.add(cardSlot);
			}
		}
		
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

	public boolean movePlayer(Direction movementDirection)
	{
		MapTile newPlayerLocation = null;
		boolean successfullyMoved = true;
		
		switch(movementDirection)
		{
			case NORTH:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate() - 1, this.currentPlayerLocation.getXCoordinate());
				break;
			case EAST:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate(), this.currentPlayerLocation.getXCoordinate() + 1);
				break;
			case SOUTH:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate() + 1, this.currentPlayerLocation.getXCoordinate());
				break;
			case WEST:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate(), this.currentPlayerLocation.getXCoordinate() - 1);
				break;
		}

		if(this.map.isLocationValid(newPlayerLocation))
		{
			try
			{
				this.showCard(currentPlayerLocation);
				this.currentPlayerLocation = newPlayerLocation;
				this.showCard(currentPlayerLocation, new ImageIcon("src/images/player.png"));
				Card currentCard = this.map.getCard(currentPlayerLocation);
				
				if(currentCard instanceof ScenarioCard && !currentCard.isShown())
				{
					((ScenarioCard)currentCard).runScript();
				}
				currentCard.setShown(true);
			}
			catch(Exception error)
			{
				this.log(error.getMessage());
			}
		}
		else
		{
			if(this.map.isLocationInBounds(newPlayerLocation))
			{
				this.showCard(newPlayerLocation);
			}
			successfullyMoved = false;
		}
		
		this.updateHealthBar();
		
		if(successfullyMoved)
		{
			int y = this.currentPlayerLocation.getYCoordinate();
			int x = this.currentPlayerLocation.getXCoordinate();
			this.log("Player moved to " + x  + "," + y);
			
			if(this.currentPlayerLocation.equals(this.map.getFinish()))
			{
				this.removeKeyListener(this);
				this.prompt(
						"Congratulations... YOU WON!!", 
						"FINISHED", 
						new ImageIcon("src/images/manwithtrophy.png"), 
						new String[] {"OK"}, 
						"OK");
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
		
		return successfullyMoved;
	}
	
	private void showCard(int x, int y)
	{
		this.showCard(x, y, this.map.getCard(x, y).getIcon());
	}
	
	private void showCard(int x, int y, ImageIcon icon)
	{
		Component tile = this.mapPanel.getComponent(y * this.map.getSize() + x);
		JLabel label = (JLabel)tile;
		label.setIcon(icon);
		label = null;
		tile = null;
	}

	private void showCard(MapTile tile)
	{
		this.showCard(tile.getXCoordinate(), tile.getYCoordinate());
	}

	private void showCard(MapTile tile, ImageIcon icon)
	{
		this.showCard(tile.getXCoordinate(), tile.getYCoordinate(), icon);
	}
	
	@Override
	public void keyPressed(KeyEvent ke) 
	{
		int key = ke.getKeyCode();
		Direction currentDirection = Direction.NORTH;
		switch(key)
		{
			case KeyEvent.VK_UP:
			case KeyEvent.VK_I:
				currentDirection = Direction.NORTH;
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_L:
				currentDirection = Direction.EAST;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_K:
				currentDirection = Direction.SOUTH;
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_J:
				currentDirection = Direction.WEST;
				break;
			default:
				this.log("Invalid Input!");
		}
		this.movePlayer(currentDirection);
	}

	@Override
	public void keyReleased(KeyEvent ke) { }

	@Override
	public void keyTyped(KeyEvent ke) { }
	
	public void update(){
		int newHealth = WildernessSurvival.player.getHealth();
		int newHunger = WildernessSurvival.player.getEnergy();
		WildernessSurvival.gui.log("Your health is now : " + newHealth);
		WildernessSurvival.gui.log("Your hunger is now : " + newHunger);
		WildernessSurvival.player.updateWeakenedCounter(-1);
		WildernessSurvival.gui.log("You are weakened for another " + WildernessSurvival.player.getWeakenedCounter() + " turns!");
		this.updateHealthBar();
	}
	
	public void alert(String message)
	{
		// CREDIT: http://docs.oracle.com/javase/tutorial/uiswing/components/internalframe.html
		// CREDIT: https://docs.oracle.com/javase/8/docs/api/javax/swing/JInternalFrame.html
		// CREDIT: http://www.herongyang.com/Swing/JOptionPane-Display-Internal-Dialog-Box.html
		
		this.alertPanel.setPreferredSize(new Dimension(this.getWidth(), 150));
		this.alertPanel.removeAll();
		JInternalFrame alertFrame = new JInternalFrame();
		this.alertPanel.add(alertFrame);
		this.remove(this.statusPanel);
		this.add(this.alertPanel, BorderLayout.SOUTH);

		this.revalidate();
		this.repaint();
		
		JOptionPane.showInternalMessageDialog(alertFrame, message);

		this.remove(this.alertPanel);
		this.add(this.statusPanel, BorderLayout.SOUTH);
		
		this.revalidate();
		this.repaint();
		this.refocus();
	}
	
	public int prompt(String message, String title, ImageIcon icon, String[] choices, String defaultChoice)
	{	
		// CREDIT: http://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
		// CREDIT: http://docs.oracle.com/javase/tutorial/uiswing/components/internalframe.html
		// CREDIT: https://docs.oracle.com/javase/8/docs/api/javax/swing/JInternalFrame.html
		// CREDIT: http://www.herongyang.com/Swing/JOptionPane-Display-Internal-Dialog-Box.html
		
		this.alertPanel.setPreferredSize(new Dimension(this.getWidth(), 150));
		this.alertPanel.removeAll();
		JInternalFrame alertFrame = new JInternalFrame();
		alertPanel.add(alertFrame);
		this.remove(this.statusPanel);
		this.add(this.alertPanel, BorderLayout.SOUTH);

		this.revalidate();
		this.repaint();
		
		int choice = JOptionPane.showInternalOptionDialog(
				alertFrame, 
				message, 
				title, 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, 
				icon, 
				choices, 
				defaultChoice);

		this.remove(this.alertPanel);
		this.add(this.statusPanel, BorderLayout.SOUTH);
		
		this.revalidate();
		this.repaint();
		this.refocus();
		
		return choice;
	}
	
	public void displayStatusPanel()
	{
		this.remove(this.alertPanel);
		this.add(this.statusPanel, BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();
		this.refocus();
	}
	
	public void refocus(){
		this.toFront();
		this.setState(Frame.NORMAL);
		this.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.requestFocus();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
