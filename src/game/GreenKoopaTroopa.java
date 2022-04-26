package game;

import java.awt.Graphics;

public class GreenKoopaTroopa extends Tower
{
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
		Enemy e = state.findNearestEnemy(x, y);
	}

	/** This draws the tower.
	 */
	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/green_koopa_troopa.png", x, y, 55);
	}
}
