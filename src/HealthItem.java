public class HealthItem extends Item
{
	private int healthMod;
	
	public HealthItem(int id)
	{
		super(id, "src/images/firstaid.png");
		this.healthMod = 25;
	}
	
	@Override
	public String toString()
	{
		return "Health Pack (+ " + this.healthMod + " Health)";
	}
	
	public void use()
	{
		WildernessSurvival.player.addHealth(this.healthMod);
	}
}
