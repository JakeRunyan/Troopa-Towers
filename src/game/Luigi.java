package game;

import java.awt.Graphics;
import java.awt.Point;

public class Luigi extends Enemy
{
	private double location;
	private GameState state;
	
	/**
	 * Constructor for the Peach object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Peach with the correct information. 
	 */
	public Luigi(GameState state)
	{
		this.state = state;
	}
	
	public void update(double elapsedTime)
	{
		location += .002;
		if (location >= 1)
		{
			location = 0;
		}
	}

	@Override
	public void draw(Graphics g, GameView view)
	{
		Point point = new Point(state.getPath().locatePosition(location));
		view.drawCenteredImage(g, "resources/hd-peach.png", (int)point.getX(), (int)point.getY(), 35);
	}

}
