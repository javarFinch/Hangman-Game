/**
 * 
 */
package hangManGame;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * @author Javar Finch
 * @version 1.0
 */
public class DrawRightArm extends JComponent {
	
	public void paintComponent(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		g1.drawLine(115, 300, 210, 115);
	}

}
