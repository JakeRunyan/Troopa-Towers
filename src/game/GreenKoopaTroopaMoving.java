package game;

import java.awt.Graphics;

public class GreenKoopaTroopaMoving extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public GreenKoopaTroopaMoving(GameState state, int x, int y)
	{
		super(state, x, y);
		System.out.println("This is being called");
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
				state.addAnimatable(new GreenKoopaTroopa(state, x, y));
			}
		}
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/koopa_troopa.png", x, y, 55);
	}
}
