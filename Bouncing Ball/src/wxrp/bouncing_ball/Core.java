/**
 * ---------------- Java 2D Graphics ---------------- 
 * Java 2D Bouncing Ball
 * This class contains motion logic and graphics rendering method.
 * Developed with Eclipse IDE
 * @author DannyWarp
 * 
 */ 

package wxrp.bouncing_ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Core extends JComponent {

	private static final long serialVersionUID = 1L;
	// Global variables. 
	int x, y, bounds = 80;
	boolean move_up, move_left;

		public Core() {
			// The timer is used to repaint the component.
			Timer timer = new Timer(10, new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					// horizontal motion logic.
					if (x > getWidth() - bounds) {
						move_left = true;
					}
					if (x < 0) {
						move_left = false;
					}
					// Performing horizontal motion.
						if (move_left) {
							x -= 1;
						}
						else {
							x += 1;
						}
					// vertical motion logic.
					if (y > getHeight() - bounds) {
						move_up = true;
					}
					if (y < 0) {
						move_up = false;
					}
					// Performing vertical motion.
						if (move_up) {
							y -= 1;
						}
						else {
							y += 1;
						}
					repaint(); // Repaint JComponent.
				}
			});
			timer.start();	// I think you have brains.
			
		}
	
	public void paintComponent(Graphics g) {						// This method is called using EDT, it does not need to be called. 
		Graphics2D g2d = (Graphics2D) g;						// Conversion from Graphics to Graphics2D.
		super.paintComponent(g2d);							// I don't know what that.
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	// Better resolution of the shapes.
				g2d.setColor(Color.RED);					// Setting color of all shapes below.
					g2d.fillOval(x, y, bounds, bounds);			// Draw the circle.
						g2d.dispose();					// Memory optimization. Helps a lot if method has create new shape objects.
			Toolkit.getDefaultToolkit().sync();					// Rendering are OS dependent. This line makes animation smoother on Linux.
	}

}
