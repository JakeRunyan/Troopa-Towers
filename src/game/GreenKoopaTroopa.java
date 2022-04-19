package game;

import java.awt.Graphics;

public class GreenKoopaTroopa extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public GreenKoopaTroopa(GameState state, int x, int y)
	{
		super(state, x, y);
		state.creditEditor(-50);
	}

	public void update(double elapsedTime)
	{
		
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/green_koopa_troopa.png", x, y, 55);
	}
}
