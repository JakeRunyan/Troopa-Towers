/**All the code for red koopa troopas sitting in the menu.
 * @author Jake Runyan, Nathan Atwood
 * @version April 26th, 2022 */
package game;

import java.awt.Graphics;

public class RedKoopaTroopaMenu extends Tower
{
	/**
	 * Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public RedKoopaTroopaMenu(GameState state, GameControl control, int x, int y, int cost)
	{
		super(state, control, x, y, cost);
	}

	/** If the mouse is clicked and if the player has enough credits. This will click on it.
	 * If the mouse is over the image it will work.
	 */
	public void update(double elapsedTime)
	{
		if(state.getMouseClicked() && state.getCredit() >= cost)
		{
			int deltaX = Math.abs(x - state.getMouseX());
			int deltaY = Math.abs(y -state.getMouseY());
			
			if(deltaX < 40 && deltaY < 40)
			{
				state.consumeClick();
				state.addAnimatable(new RedKoopaTroopaMoving(state, control, x, y, cost));
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
