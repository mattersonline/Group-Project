import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import com.sun.prism.paint.Color;


public class TestMap {
	public final int MAP_SIZE = 10;
	private Card[][] mapArray;
	
	TestMap(int mapSize)
	{
		this.mapArray = new Card[this.MAP_SIZE][this.MAP_SIZE];
		this.mapArray[6][4] = new StartCard();
		this.mapArray[0][8] = new FinishCard();
		this.mapArray[2][4] = new InaccessibleAreaCard();
		this.mapArray[3][4] = new InaccessibleAreaCard();
		this.mapArray[4][4] = new InaccessibleAreaCard();
		this.mapArray[5][5] = new InaccessibleAreaCard();
		this.mapArray[6][6] = new InaccessibleAreaCard();
		this.mapArray[7][5] = new InaccessibleAreaCard();
		this.mapArray[8][7] = new InaccessibleAreaCard();
		this.mapArray[9][8] = new InaccessibleAreaCard();
		
		for(int row = 0; row < this.mapArray.length; row++)
		{
			for(int column = 0; column < this.mapArray[row].length; column++)
			{
				if(this.mapArray[row][column] == null)
				{
					this.mapArray[row][column] = new ScenarioDemo();
				}
			}
		}
	}
	
	public void displayConsole()
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
	
	public JPanel getPanel()
	{
		JPanel mapPanel = new JPanel(new GridLayout(10,10));
		
		for(int row = 0; row < this.mapArray.length; row++)
		{
			for(int column = 0; column < this.mapArray[row].length; column++)
			{
				JLabel card = new JLabel(this.mapArray[row][column].toString());
				mapPanel.add(card);
			}
		}
		
		return mapPanel;
	}
}
