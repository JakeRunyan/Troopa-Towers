package game;

import java.awt.Point;

abstract public class Enemy implements Animatable
{
	protected int x, y;
	protected int health;
	protected GameState state;
	protected double pathPosition;
	

	/**
	 * Constructor -- all enemies need a GameState object reference as
	 * well as a position along the path.
	 * 
	 * @param state the GameState object reference
	 * @param pathPosition a percentage along the path
	 */
	public Enemy (GameState state, double pathPosition)
	{
		this.state = state;
		this.pathPosition = pathPosition;
	}
	/**
	 * Returns the x,y location of this enemy (as a Point).
	 * This method is needed by the towers -- they'll need to
	 * locate a nearby enemy.  This method can be used on 
	 * -any- enemy to locate it.
	 * 
	 * @return the location of this enemy as a Point
	 */
	public Point getLocation ()
	{
		Point p = state.getPath().locatePosition(pathPosition);
		return p;
	}
}
