/** This class holds the data for the Luigi.
 * @author Jake Runyan, Nathan Atwood
 * @version April 19th, 2022 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class Luigi extends Enemy
{
	/** Constructor for the Luigi object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Luigi with the correct information. 
	 */
	public Luigi(GameState state)
	{
		super(state, 0.0);
	}
	
	/** Update the Luigi based to advance its location. 
	 * 
	 * @param elapsedTime - the amount of the time between frames. 
	 */
	public void update(double elapsedTime)
	{
		pathPosition += .003;
		if (pathPosition >= 1)
		{
			state.removeAnimatable(this);
			state.addAnimatable(new LuigiDying(state, new Point(state.getPath().locatePosition(pathPosition)) ));
			pathPosition = 0;
			state.lifeEditor(2);
		}
	}

	/** Puts Luigi on the screen every time the frame is updated. 
	 * 
	 * @param g A graphics object to draw the Mario on the screen. 
	 * @param view passes in a reference to the GameView class so that all of the images on the screen can draw in the right place. 
	 */
	public void draw(Graphics g, GameView view)
	{
		Point point = new Point(state.getPath().locatePosition(pathPosition));
		view.drawCenteredImage(g, "resources/luigi.png", (int)point.getX(), (int)point.getY(), 35);
	}

}
