/**
 * ---------------- Java 2D Graphics ---------------- 
 * Java 2D Bouncing Ball
 * This class creates the window.
 * Developed with Eclipse IDE
 * @author DannyWarp
 * 
 */ 

package wxrp.bouncing_ball;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JFrame;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;

	public Interface() {										// Constructor.
		
		setSize(840, 500);									// Setting window size.
			setLocationRelativeTo(null);							// Centering the window.
				setDefaultCloseOperation(EXIT_ON_CLOSE);				// Shut down the program.
					setLayout(new BorderLayout());					// Setting the border layout.
						setTitle("Bouncing Ball Animation");			// Setting the program title.
		
		Image icon = getToolkit().getImage(ClassLoader.getSystemResource("jar_low.png"));	// This line gets a system image (only if this JAR build).
			setIconImage(icon);								// Setting the icon
				add(new Core());							// Adding a class to JFrame (the class must be of type Component ("extends JPanel, JComponent, etc.).			
					setVisible(true);						// Setting visibility of the program.
	}
	
	public static void main(String[] args) {
		new Interface();									// Run the program
	}
}
