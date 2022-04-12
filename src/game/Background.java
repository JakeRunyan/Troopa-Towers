/** This class handles creating the background of the game.
 * @author Jake Runyan, Nathan Atwood
 * @version April 12th, 2022 */
package game;

import java.awt.Graphics;

public class Background implements Animatable
{
	private GameControl control;
	
	/** Constructs the background. 
	 * 
	 * @param control - Passes in the gameControl object. 
	 */
	public Background(GameControl control)
	{
		this.control = control;
	}
	
	/**
	 * Not needed becasue the background does not change from frame to frame. 
	 */
	public void update(double elapsedTime)
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Draws the background. 
	 */
	public void draw(Graphics g, GameView view)
	{
		// TODO Auto-generated method stub
		g.drawImage(control.loadImage("resources/path.jpg"), 0, 0, null);
	}

}
