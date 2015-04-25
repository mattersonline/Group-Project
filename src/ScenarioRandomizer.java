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
		for(int i = 0; i < map[1].length; i++){
			for(int j = 0; j < map[1].length; j++){
				if(map[i][j] == null){
					cardPicked = randomizer.nextInt(3);
					map[i][j] = arr.get(cardPicked); //arr.get(cardPicked);
					//arr.remove(cardPicked);
				}
			}
		}
		return map;
	}
}
