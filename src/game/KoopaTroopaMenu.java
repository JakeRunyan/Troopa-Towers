package game;

import java.awt.Graphics;

public class KoopaTroopaMenu extends Tower
{
	/**
	 * Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public KoopaTroopaMenu()
	{
		
	}

	public void update(double elapsedTime)
	{
		
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/koopa_troopa.png", 635, 100, 55);
	}

	@Override
	public boolean isInside(int targetX, int targetY)
	{
		return false;
	}
	
}
