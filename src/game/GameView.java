/** This class handles creating the window and generating the graphics within.
 * @author Jake Runyan, Nathan Atwood
 * @version April 26th, 2022 */
package game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView extends JPanel
{
	// Fields
	
	private GameState state;
	private GameControl control;
	
	/** Constructor for the GameView object. 
	 * 
	 * @param s - passes in data for the game state. 
	 * @param control - passes in data from the game controller. 
	 */
	public GameView (GameState s, GameControl control)
	{
		this.control = control;
		
		// Keep track of the game's state object.
		
		state = s;
		
		// Build the frame and the panel, then put 'this' object in it.
		// First, use inherited methods to set a new pixel size for this object.
		
		this.setMinimumSize(new Dimension(800,600));
		this.setMaximumSize(new Dimension(800,600));
		this.setPreferredSize(new Dimension(800,600));
		
		// Make the JFrame, ask it to exit the application when closed.
		
		JFrame frame = new JFrame ("Troopa Towers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Put 'this' JPanel into the frame.
		
		frame.setContentPane(this);
		
		// Reallocate frame space (called packing), then show it.
		
		frame.pack(); 
		frame.setVisible(true);
	}
	
	/**
	 * This method constructs a single frame. It is called roughly 60 times a second to animate the game. 
	 * 
	 * @param g Pass in a graphics method to construct the image on the screen. 
	 */
	public void paint (Graphics g)
	{
		state.drawAll(g, this);  // We'll do all the work in drawAll in this checkpoint
	}
	
	/**
	 * Takes a point on a screen and draws an image centered on that point. 
	 * @param g graphics
	 * @param name of the source file for the picture
	 * @param x value of the point
	 * @param y value of the point
	 */
	public void drawCenteredImage(Graphics g, String name, int x, int y, int scale) 
	{
			g.drawImage(control.loadImage(name), x-scale/2, y-scale/2, scale, scale, null);
	}

	
}
