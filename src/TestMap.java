import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TestMap extends Map 
{
	TestMap(int mapSize)
	{
		mapSize = 10;
		MapTile startTile = new MapTile(6,4);
		MapTile finishTile = new MapTile(0,8);
		MapTile currentPlayerLocation = new MapTile(6,4);
		
		Card[][] cards = new Card[mapSize][mapSize];
		cards[startTile.getYCoordinate()][startTile.getXCoordinate()] = new StartCard();
		cards[finishTile.getYCoordinate()][finishTile.getXCoordinate()] = new FinishCard();
		
		// setup inaccessible areas
		cards[3][0] = new InaccessibleAreaCard();
		cards[3][1] = new InaccessibleAreaCard();
		cards[2][4] = new InaccessibleAreaCard();
		cards[3][4] = new InaccessibleAreaCard();
		cards[4][4] = new InaccessibleAreaCard();
		cards[5][5] = new InaccessibleAreaCard();
		cards[6][6] = new InaccessibleAreaCard();
		cards[7][5] = new InaccessibleAreaCard();
		cards[8][7] = new InaccessibleAreaCard();
		cards[9][8] = new InaccessibleAreaCard();
		
		super.setCardArray(cards);
		super.setFinish(finishTile);
		super.setStart(startTile);
		super.setCurrentPlayerLocation(currentPlayerLocation);
	}
}
