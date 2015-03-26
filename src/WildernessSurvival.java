import java.awt.BorderLayout;

import javax.swing.JFrame;


public class WildernessSurvival {

	public static void main(String[] args) {
		// initialize player
		// initialize map
		TestMap map = new TestMap(10);
		// initialize gui
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(map.getPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
		// display map
		// start game loop
	}

}
