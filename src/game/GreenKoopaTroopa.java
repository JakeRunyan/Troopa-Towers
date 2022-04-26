package game;

import java.awt.Graphics;
import java.awt.Point;

public class GreenKoopaTroopa extends Tower
{
	private double timeSinceLastShot;

	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public GreenKoopaTroopa(GameState state, GameControl control, int x, int y, int cost)
	{
		super(state, control, x, y, cost);
		state.creditEditor(-cost);
	}
	
	/** This will update the tower.
	 */
	public void update(double elapsedTime)
	{
		// One second since last shot?
		timeSinceLastShot += elapsedTime;
		if (timeSinceLastShot < 1.0)
			return; // Do not shoot anything

		Enemy e = state.findNearestEnemy(x, y);        // Find an enemy within range

		Point p = new Point(x, y);

		if(e != null)
		{
			if (e.getLocation().distance(p) < 75)
			{
				timeSinceLastShot = 0;
			}
		}
	}

	/** This draws the tower.
	 */
	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/green_koopa_troopa.png", x, y, 55);
	}
}
