package game;

abstract public class Tower implements Animatable
{
	protected int cost;
	
	abstract public boolean isInside (int targetX, int targetY);
}