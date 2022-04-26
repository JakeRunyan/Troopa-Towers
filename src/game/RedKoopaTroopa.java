package game;

import java.awt.Graphics;
import java.awt.Point;

public class RedKoopaTroopa extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public RedKoopaTroopa(GameState state, GameControl control, int x, int y, int cost)
	{
		super(state, control, x, y, cost);
		state.creditEditor(-cost);
		
		System.out.println("Hi! I am created! " + x + "   " + y);
	}

	/** This will update the tower.
	 */
	public void update(double elapsedTime)
	{
		Enemy e = state.findNearestEnemy(x, y);
		Point p = new Point(x, y);
		
		if(e != null)
		{
		if(e.getLocation().distance(p) < 75)
		{
			System.out.println("Boom! I'm firing!");
		}
		}
	}

	/** This draws the tower.
	 */
	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/red_koopa_troopa.png", x, y, 55);
	}
}
