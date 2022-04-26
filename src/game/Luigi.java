/** This class holds the data for the Luigi.
 * @author Jake Runyan, Nathan Atwood
 * @version April 19th, 2022 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class Luigi extends Enemy
{
	/**
	 * Constructor for the Luigi object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Luigi with the correct information. 
	 */
	public Luigi(GameState state)
	{
		super(state, 0.0);
	}
	
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

	public void draw(Graphics g, GameView view)
	{
		Point point = new Point(state.getPath().locatePosition(pathPosition));
		view.drawCenteredImage(g, "resources/luigi.png", (int)point.getX(), (int)point.getY(), 35);
	}

}
