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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int x, y, bounds = 80;
	boolean move_up, move_left;

	public Core() {
		
		Timer timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (x > getWidth() - bounds) {
					move_left = true;
				}
				
				if (x < 0) {
					move_left = false;
				}
				
					if (move_left) {
						x -= 1;
					}
					
					else {
						x += 1;
					}
					
				if (y > getHeight() - bounds) {
					move_up = true;
				}
				
				if (y < 0) {
					move_up = false;
				}
				
					if (move_up) {
						y -= 1;
					}
					
					else {
						y += 1;
					}
					
				repaint();
				
			}
		});
		
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(Color.RED);
			g2d.fillOval(x, y, bounds, bounds);
			g2d.dispose();
			
				Toolkit.getDefaultToolkit().sync();
	}

}



















