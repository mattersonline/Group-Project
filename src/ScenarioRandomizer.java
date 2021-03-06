import java.util.*;
import java.awt.*;
public final class ScenarioRandomizer {
	static ArrayList<ScenarioCard> arr = new ArrayList<ScenarioCard>(2);
	private ScenarioRandomizer(){}
	
	public static Card[][] RandomizeScenarios(Card[][] map){
		
		Random randomizer = new Random();
		int cardsUsed = 0;
		int cardPicked;
		arr.add(new CoyoteScenario());
		arr.add(new WolfScenario());
		arr.add(new BearTrapScenario());
		arr.add(new DeerScenario());
		arr.add(new LogCabinScenario());
		arr.add(new WildDogScenario());
		arr.add(new HealthyBerriesScenario());
		arr.add(new PoisonBerriesScenario());
		arr.add(new WildDogScenario());
		arr.add(new WildDogScenario());
		arr.add(new CoyoteScenario());
		arr.add(new BearScenario());
		for(int i = 0; i < map[1].length; i++){
			for(int j = 0; j < map[1].length; j++){
				if(map[i][j] == null){
					cardPicked = randomizer.nextInt(12);
					map[i][j] = arr.get(cardPicked); //arr.get(cardPicked);
					//arr.remove(cardPicked);
				}
			}
		}
		return map;
	}
}
