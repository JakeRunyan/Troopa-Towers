package game;

import java.awt.Graphics;

public class GreenKoopaTroopaMoving extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public GreenKoopaTroopaMoving(GameState state, int x, int y, int cost)
	{
		super(state, x, y, cost);
	}

	/** This will update the tower to follow the mouse until it gets clicked.
	 * Then it places a new tower where it is clicked and removes the current one.
	 */
	public void update(double elapsedTime)
	{
		x = state.getMouseX();
		y = state.getMouseY();
		if(state.getMouseClicked())
		{
			if(x < 600 && y < 600)
			{
				state.consumeClick();
				state.addAnimatable(new GreenKoopaTroopa(state, x, y, cost));
				state.removeAnimatable(this);
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
