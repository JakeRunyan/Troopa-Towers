/** This class holds the data for the Mario.
 * @author Jake Runyan, Nathan Atwood
 * @version April 26th, 2022 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class Mario extends Enemy
{
	/** Constructor for the Mario object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Mario with the correct information. 
	 */
	public Mario(GameState state) 
	{
		super(state, 0.0);
	}
	
	/** Update the Mario based to advance its location. 
	 * 
	 * @param elapsedTime - the amount of the time between frames. 
	 */
	public void update(double elapsedTime)
	{
		pathPosition += .002;
		if (pathPosition >= 1)
		{
			state.removeAnimatable(this);
			state.addAnimatable(new MarioDying(state, new Point(state.getPath().locatePosition(pathPosition))));
			pathPosition = 0;
			state.lifeEditor(1);
		}

	}

	/** Puts Mario on the screen every time the frame is updated. 
	 * 
	 * @param g A graphics object to draw the Mario on the screen. 
	 * @param view passes in a reference to the GameView class so that all of the images on the screen can draw in the right place. 
	 */
	public void draw(Graphics g, GameView view)
	{
		Point point = new Point(state.getPath().locatePosition(pathPosition));
		view.drawCenteredImage(g, "resources/mario.png", (int)point.getX(), (int)point.getY(), 35);
	}
}
