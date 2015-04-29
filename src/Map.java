import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public abstract class Map {
	private Card[][] mapArray;
	private MapTile startingTile;
	private MapTile finishTile;
	private MapTile currentPlayerLocation;
	private Color defaultTileColor; 
	private int mapSize;
	
	protected Map(int mapSize)
	{
		this.mapSize = mapSize;
		this.mapArray = new Card[mapSize][mapSize];
		this.mapArray = ScenarioRandomizer.RandomizeScenarios(this.mapArray);
	}
	
	protected void setCardArray(Card[][] cards)
	{
		this.mapArray = cards;
	}
	
	protected void setStart(MapTile start)
	{
		this.startingTile = start;
		this.mapArray[start.getYCoordinate()][start.getXCoordinate()] = new StartCard();
	}
	
	protected void setFinish(MapTile finish)
	{
		this.finishTile = finish;
		this.mapArray[finish.getYCoordinate()][finish.getXCoordinate()] = new FinishCard();
	}
	
	protected void setCard(MapTile tile, Card card)
	{
		this.mapArray[tile.getYCoordinate()][tile.getXCoordinate()] = card;
	}
	
	protected void setCurrentPlayerLocation(MapTile currentPlayerLocation)
	{
		this.currentPlayerLocation = currentPlayerLocation;
	}

	public boolean isFinished()
	{
		return this.currentPlayerLocation.equals(this.finishTile);
	}
	
	public void displayConsole()
	{
		System.out.print("  ");
		for(int i = 0; i < this.mapArray.length; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int y = 0; y < this.mapArray.length; y++)
		{
			System.out.print(y + " ");
			for(int x = 0; x < this.mapArray[y].length; x++)
			{
				System.out.print(this.mapArray[y][x].toString() + " ");
			}
			System.out.println();
		}
	}
	
	public MapTile getPlayerLocation()
	{
		return this.currentPlayerLocation;
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

		if(isLocationValid(newPlayerLocation))
		{
			this.currentPlayerLocation = newPlayerLocation;
			try
			{
				int y = this.currentPlayerLocation.getYCoordinate();
				int x = this.currentPlayerLocation.getXCoordinate();
				Card currentCard = this.mapArray[y][x];
				this.mapArray[y][x].setShown(true);
				
				if(currentCard instanceof ScenarioCard)
				{
					((ScenarioCard)currentCard).runScript();
				}
			}
			catch(Exception error)
			{
				WildernessSurvival.log(error.getMessage());
			}
		}
		else
		{
			if(isLocationInBounds(newPlayerLocation))
			{
				this.mapArray[newPlayerLocation.getYCoordinate()][newPlayerLocation.getXCoordinate()].setShown(true);
			}
			successfullyMoved = false;
		}
		
		return successfullyMoved;
	}
	
	private boolean isLocationInBounds(int y, int x)
	{
		return (y >= 0 && x >= 0 && y < this.mapArray.length && x < this.mapArray[y].length);
	}
	
	private boolean isLocationInBounds(MapTile location)
	{
		return isLocationInBounds(location.getYCoordinate(), location.getXCoordinate());
	}
	
	private boolean isLocationValid(int y, int x)
	{
		boolean isValid = true;
		if(!isLocationInBounds(y, x) || this.mapArray[y][x] instanceof InaccessibleAreaCard)
		{
			isValid = false;
		}
		
		return isValid;
	}
	
	private boolean isLocationValid(MapTile location)
	{
		return isLocationValid(location.getYCoordinate(), location.getXCoordinate());
	}
	
	public JPanel getMapPanel()
	{
		int playerX = this.currentPlayerLocation.getXCoordinate();
		int playerY = this.currentPlayerLocation.getYCoordinate();
		
		JPanel mapPanel = new JPanel(new GridLayout(this.mapSize,this.mapSize));
		Card currentCard = null;
		JLabel cardSlot = null;
		
		for(int y = 0; y < this.mapArray.length; y++)
		{
			for(int x = 0; x < this.mapArray[y].length; x++)
			{
				currentCard = this.mapArray[y][x];
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
				
				if(x == playerX && y == playerY && !(currentCard instanceof FinishCard))
				{
					// if current player location
					cardSlot.setBackground(new Color(0xE0AF28));
					cardSlot.setIcon(new ImageIcon("src/images/player.png"));
				}
				else if(currentCard.isShown())
				{
					// CREDIT: http://www.javalobby.org/java/forums/t19183.html
					cardSlot.setBackground(currentCard.getBackgroundColor());
					cardSlot.setIcon(currentCard.getIcon());
				}
				
				mapPanel.add(cardSlot);
			}
		}
		
		return mapPanel;
	}
}
