import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TestMap extends Map 
{
	TestMap(int mapSize)
	{
		super(10);
		mapSize = 10;
		MapTile startTile = new MapTile(6,4);
		MapTile finishTile = new MapTile(0,8);
		MapTile currentPlayerLocation = new MapTile(6,4);
				
		// setup inaccessible areas
		super.setCard(new MapTile(3, 0), new InaccessibleAreaCard());
		super.setCard(new MapTile(3, 1), new InaccessibleAreaCard());
		super.setCard(new MapTile(2, 4), new InaccessibleAreaCard());
		super.setCard(new MapTile(3, 4), new InaccessibleAreaCard());
		super.setCard(new MapTile(4, 4), new InaccessibleAreaCard());
		super.setCard(new MapTile(5, 5), new InaccessibleAreaCard());
		super.setCard(new MapTile(6, 6), new InaccessibleAreaCard());
		super.setCard(new MapTile(7, 5), new InaccessibleAreaCard());
		super.setCard(new MapTile(8, 7), new InaccessibleAreaCard());
		super.setCard(new MapTile(9, 8), new InaccessibleAreaCard());
		
		super.setFinish(finishTile);
		super.setStart(startTile);
		super.setCurrentPlayerLocation(currentPlayerLocation);
	}
}
