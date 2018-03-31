/**
 * 
 */
package hangManGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author Javar Finch
 * @version 1.0 July 26, 2017
 */
// Extending JComponent makes this class inherit component properties
// Allowing drawing to be on a component
public class Draw extends JComponent {

	
	public void paintComponent(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		g1.setColor(Color.black);
		// draws head
		g1.drawOval(40, 50, 150, 150);
		g1.drawLine(110, 50, 110, 15);
		g1.drawLine(110, 15, 350, 15);
		g1.drawLine(350, 15, 350, 450);
	}

}
