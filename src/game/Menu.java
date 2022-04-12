/** This class holds the data to create a functional menu. 
 * @author Jake Runyan, Nathan Atwood
 * @version April 12th, 2022 */

 package game;

import java.awt.Color;
import java.awt.Graphics;

public class Menu implements Animatable
{
	/**
	 * Nothing to construct or store in the object. Just need to draw the menu on the screen.
	 */
	public Menu()
	{
		
	}
	
	/**
	 * This helper method does not need to be used because the menu does not change from frame to frame.
	 */
	public void update(double elapsedTime)
	{
		// TODO Auto-generated method stub
	}

	/** This function is to draw the menu background and the menu word.
	 * 
	 * @param g A graphics object to draw the menu on the screen. 
	 * @param view passes in a reference to the GameView class so that all of the images on the screen can draw in the right place. 
	 */
	public void draw(Graphics g, GameView view)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(600, 0, 800, 600);
		
		g.setColor(Color.WHITE);
		g.drawString("Menu", 690, 50);
	}
}
