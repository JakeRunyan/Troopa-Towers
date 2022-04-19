/** This class holds the data for the Luigi.
 * @author Jake Runyan, Nathan Atwood
 * @version April 19th, 2022 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class Luigi extends Enemy
{
	private double location;
	private GameState state;
	
	/**
	 * Constructor for the Luigi object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Luigi with the correct information. 
	 */
	public Luigi(GameState state)
	{
		this.state = state;
	}
	
	public void update(double elapsedTime)
	{
		location += .003;
		if (location >= 1)
		{
			state.removeAnimatable(this);
			location = 0;
			state.lifeEditor(2);
		}
	}

	public void draw(Graphics g, GameView view)
	{
		Point point = new Point(state.getPath().locatePosition(location));
		view.drawCenteredImage(g, "resources/luigi.png", (int)point.getX(), (int)point.getY(), 35);
	}

}
