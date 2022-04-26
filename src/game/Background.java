/** This class handles creating the background of the game.
 * @author Jake Runyan, Nathan Atwood
 * @version April 26th, 2022 */
package game;

import java.awt.Graphics;

public class Background implements Animatable
{
	/** Constructs the background. 
	 * 
	 * @param control - Passes in the gameControl object. 
	 */
	public Background()
	{
		
	}
	
	/**
	 * Not needed becasue the background does not change from frame to frame. 
	 */
	public void update(double elapsedTime)
	{
		
	}

	/**
	 * Draws the background. 
	 */
	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/path.jpg", 300, 300, 600);
	}

}
