package game;

import java.awt.Graphics;

public class RedKoopaTroopaMenu extends Tower
{
	/**
	 * Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public RedKoopaTroopaMenu(GameState state, int x, int y)
	{
		super(state, x, y);
	}

	public void update(double elapsedTime)
	{
		if(state.getMouseClicked())
		{
			int deltaX = Math.abs(x - state.getMouseX());
			int deltaY = Math.abs(y -state.getMouseY());
			
			if(deltaX < 40 && deltaY < 40)
			{
				state.consumeClick();
				state.addAnimatable(new RedKoopaTroopaMoving(state, x, y));
			}
		}
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/red_koopa_troopa.png", x, y, 55);
	}
}
