package game;

abstract public class Tower implements Animatable
{
	// Fields
	protected int x, y;
	protected int cost;
	protected GameState state;
	
	public Tower(GameState state, int x, int y)
	{
		this.state = state;
		this.x = x;
		this.y = y;
	}
}