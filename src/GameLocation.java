
public class GameLocation implements IGamePosition {
	private String description;
	public GameLocation(int type)
	{
		if(type == 0)
		{
			this.description = "V";
		}
		else
		{
			this.description = "X";
		}
	}
	
	public String toString()
	{
		return this.description;
	}
}
