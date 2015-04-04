import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public abstract class Map {
	private Card[][] mapArray;
	private MapTile startingTile;
	private MapTile finishTile;
	private MapTile currentPlayerLocation;
	private Color defaultTileColor; 
	
	protected Map()
	{
		this.mapArray = ScenarioRandomizer.RandomizeScenarios(this.mapArray);
	}
	
	protected void setCardArray(Card[][] cards)
	{
		this.mapArray = cards;
	}
	
	protected void setStart(MapTile start)
	{
		this.startingTile = start;
		this.mapArray[start.getYCoordinate()][start.getYCoordinate()] = new StartCard();
	}
	
	protected void setFinish(MapTile finish)
	{
		this.finishTile = finish;
		this.mapArray[finish.getYCoordinate()][finish.getYCoordinate()] = new FinishCard();
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
		MapTile newPlayerLocation;
		boolean successfullyMoved = true;
		
		switch(movementDirection)
		{
			case NORTH:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate() - 1, this.currentPlayerLocation.getXCoordinate());
				if(isLocationValid(newPlayerLocation))
				{
					this.currentPlayerLocation = newPlayerLocation;
				}
				else
				{
					successfullyMoved = false;
				}
				break;
			case EAST:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate(), this.currentPlayerLocation.getXCoordinate() + 1);
				if(isLocationValid(newPlayerLocation))
				{
					this.currentPlayerLocation = newPlayerLocation;
				}
				else
				{
					successfullyMoved = false;
				}
				break;
			case SOUTH:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate() + 1, this.currentPlayerLocation.getXCoordinate());
				if(isLocationValid(newPlayerLocation))
				{
					this.currentPlayerLocation = newPlayerLocation;
				}
				else
				{
					successfullyMoved = false;
				}
				break;
			case WEST:
				newPlayerLocation = new MapTile(this.currentPlayerLocation.getYCoordinate(), this.currentPlayerLocation.getXCoordinate() - 1);
				if(isLocationValid(newPlayerLocation))
				{
					this.currentPlayerLocation = newPlayerLocation;
				}
				else
				{
					successfullyMoved = false;
				}
				break;
		}
		
		return successfullyMoved;
	}
	
	private boolean isLocationValid(int y, int x)
	{
		boolean isValid = true;
		if(x >= 0 && y >= 0 && y < this.mapArray.length && x < this.mapArray[y].length)
		{
			if(this.mapArray[y][x] instanceof InaccessibleAreaCard)
			{
				isValid = false;
			}
		}
		else
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
		JPanel mapPanel = new JPanel(new GridLayout(10,10));
		
		for(int y = 0; y < this.mapArray.length; y++)
		{
			for(int x = 0; x < this.mapArray[y].length; x++)
			{
				JLabel card = new JLabel(this.mapArray[y][x].toString(), JLabel.CENTER);
				card.setSize(25,40);
				card.setBorder(new LineBorder(Color.BLACK));
				
				if(x == this.currentPlayerLocation.getXCoordinate() && y == this.currentPlayerLocation.getYCoordinate())
				{
					// if current player location
					card.setBackground(Color.YELLOW);
					// CREDIT for setting background: http://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color/2380328#2380328
					card.setOpaque(true);
				}
				mapPanel.add(card);
			}
		}
		
		return mapPanel;
	}
}
