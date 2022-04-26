/**Superclass for all the effects in the game. 
 * @author Jake Runyan, Nathan Atwood
 * @version April 26th, 2022 */

 package game;

abstract public class FX implements Animatable
{
	protected GameState state;
	protected double x, y;
	
	public FX(GameState state, int x, int y)
	{
		this.state = state;
		this.x = x;
		this.y = y;
	}
}
