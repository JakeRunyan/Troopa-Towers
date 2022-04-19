package game;

import java.awt.Graphics;

public class KoopaTroopa extends Tower
{
	/**
	 * Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public KoopaTroopa()
	{
		
	}

	public void update(double elapsedTime)
	{
		
	}

	public void draw(Graphics g, GameView view)
	{
		view.drawCenteredImage(g, "resources/koopa_troopa.png", 635, 100, 55);
	}
	
}
