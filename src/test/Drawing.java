/**
 * 
 */
package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * @author Javar
 *
 */
public class Drawing extends JComponent {
	
	public void paintComponent(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		g1.drawOval(550, 200, 150, 150);
	}

}
