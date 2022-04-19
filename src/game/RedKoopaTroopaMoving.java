package game;

import java.awt.Graphics;

public class RedKoopaTroopaMoving extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public RedKoopaTroopaMoving(GameState state, int x, int y)
	{
		super(state, x, y);
	}

	public void update(double elapsedTime)
	{
		x = state.getMouseX();
		y = state.getMouseY();
		if(state.getMouseClicked())
		{
			if(x < 600 && y < 600)
			{
				state.consumeClick();
				state.addAnimatable(new RedKoopaTroopa(state, x, y));
				state.removeAnimatable(this);
			}
		}
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/red_koopa_troopa.png", x, y, 55);
	}
}
