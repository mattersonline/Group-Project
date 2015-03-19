
public class TestMap {
	public final int MAP_SIZE = 10;
	private ILocation[][] mapArray;
	
	TestMap(int mapSize)
	{
		this.mapArray = new ILocation[this.MAP_SIZE][this.MAP_SIZE];
		this.mapArray[6][4] = new GameLocation(0);
		this.mapArray[0][8] = new GameLocation(1);
		this.mapArray[2][1] = new BonusArea();
		this.mapArray[4][5] = new BonusArea();
		this.mapArray[7][8] = new BonusArea();
		this.mapArray[2][4] = new InaccessibleArea();
		this.mapArray[3][4] = new InaccessibleArea();
		this.mapArray[4][4] = new InaccessibleArea();
		this.mapArray[5][5] = new InaccessibleArea();
		this.mapArray[6][6] = new InaccessibleArea();
		this.mapArray[7][5] = new InaccessibleArea();
		this.mapArray[8][7] = new InaccessibleArea();
		this.mapArray[9][8] = new InaccessibleArea();
		this.mapArray[2][6] = new CrossableLocation();
		this.mapArray[2][7] = new CrossableLocation();
		this.mapArray[2][8] = new CrossableLocation();
		this.mapArray[5][0] = new CrossableLocation();
		this.mapArray[5][1] = new CrossableLocation();
		this.mapArray[5][2] = new CrossableLocation();
		
		for(int row = 0; row < this.mapArray.length; row++)
		{
			for(int column = 0; column < this.mapArray[row].length; column++)
			{
				if(this.mapArray[row][column] == null)
				{
					this.mapArray[row][column] = new TestScenario();
				}
			}
		}
	}
	
	public void display()
	{
		System.out.print("  ");
		for(int i = 0; i < this.mapArray.length; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int row = 0; row < this.mapArray.length; row++)
		{
			System.out.print(row + " ");
			for(int column = 0; column < this.mapArray[row].length; column++)
			{
				System.out.print(this.mapArray[row][column].toString() + " ");
			}
			System.out.println();
		}
	}
}
