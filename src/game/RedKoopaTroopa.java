package game;

import java.awt.Graphics;

public class RedKoopaTroopa extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public RedKoopaTroopa(GameState state, int x, int y)
	{
		super(state, x, y);
		state.creditEditor(-100);
	}

	public void update(double elapsedTime)
	{
		
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/red_koopa_troopa.png", x, y, 55);
	}
}
