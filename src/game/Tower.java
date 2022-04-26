package game;

abstract public class Tower implements Animatable
{
	// Fields
	protected int x, y;
	protected int cost;
	protected GameState state;
	protected GameControl control;
	
	public Tower(GameState state, GameControl control, int x, int y, int cost)
	{
		this.state = state;
		this.control = control;
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}