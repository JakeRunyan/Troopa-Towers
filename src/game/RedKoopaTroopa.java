package game;

import java.awt.Graphics;

public class RedKoopaTroopa extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public RedKoopaTroopa(GameState state, int x, int y, int cost)
	{
		super(state, x, y, cost);
		state.creditEditor(-cost);
	}

	/** This will update the tower.
	 */
	public void update(double elapsedTime)
	{
		
	}

	/** This draws the tower.
	 */
	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/red_koopa_troopa.png", x, y, 55);
	}
}
