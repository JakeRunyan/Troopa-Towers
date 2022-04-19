package game;

import java.awt.Graphics;

public class KoopaTroopaMoving extends Tower
{
	/**
	 * Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public KoopaTroopaMoving()
	{
		
	}

	public void update(double elapsedTime)
	{
//		if(MouseX < 600)
//			;
	}

	public void draw(Graphics g, GameView view)
	{
		
	}

	public boolean isInside(int targetX, int targetY)
	{
		int cx = 635;
		int cy = 100;
		int width = 55;
		
		if(cx - targetX <= width/2 )
		{
			
		}
		return false;
	}
	
}
