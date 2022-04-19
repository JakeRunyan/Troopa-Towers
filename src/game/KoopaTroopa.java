package game;

import java.awt.Graphics;

public class KoopaTroopa extends Tower
{
	
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
