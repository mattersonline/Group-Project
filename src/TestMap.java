import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TestMap {
	private final int MAP_SIZE = 10;
	private Card[][] mapArray;
	private MapTile startingTile;
	private MapTile finishTile;
	private MapTile currentPlayerLocation;
	private Color defaultTileColor; 
	
	TestMap(int mapSize)
	{
		this.mapArray = new Card[this.MAP_SIZE][this.MAP_SIZE];
		this.mapArray[6][4] = new StartCard();
		this.startingTile = new MapTile(6,4);
		this.mapArray[0][8] = new FinishCard();
		this.finishTile = new MapTile(0,8);
		this.currentPlayerLocation = new MapTile(6,4);
		
		// setup inaccessible areas
		this.mapArray[3][0] = new InaccessibleAreaCard();
		this.mapArray[3][1] = new InaccessibleAreaCard();
		this.mapArray[2][4] = new InaccessibleAreaCard();
		this.mapArray[3][4] = new InaccessibleAreaCard();
		this.mapArray[4][4] = new InaccessibleAreaCard();
		this.mapArray[5][5] = new InaccessibleAreaCard();
		this.mapArray[6][6] = new InaccessibleAreaCard();
		this.mapArray[7][5] = new InaccessibleAreaCard();
		this.mapArray[8][7] = new InaccessibleAreaCard();
		this.mapArray[9][8] = new InaccessibleAreaCard();
		
		for(int y = 0; y < this.mapArray.length; y++)
		{
			for(int x = 0; x < this.mapArray[y].length; x++)
			{
				if(this.mapArray[y][x] == null)
				{
					this.mapArray[y][x] = new ScenarioDemo();
				}
			}
		}
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
