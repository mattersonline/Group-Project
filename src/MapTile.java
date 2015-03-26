public class MapTile
{
	private int xCoordinate;
	private int yCoordinate;
	
	public MapTile(int y, int x)
	{
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public int getXCoordinate()
	{
		return this.xCoordinate;
	}
	
	public int getYCoordinate()
	{
		return this.yCoordinate;
	}
	
	public String toString()
	{
		return this.getClass().getTypeName() + " at map coordinates " + this.xCoordinate + "," + this.yCoordinate;
	}
	
	public boolean equals(MapTile compareToTile)
	{
		return (this.xCoordinate == compareToTile.xCoordinate
				&& this.yCoordinate == compareToTile.yCoordinate);
	}
}
