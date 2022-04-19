package game;

import java.awt.Graphics;

public class KoopaTroopaMoving extends Tower
{
	/** Constructor for the KoopaTroopa object. 
	 * 
	 * @param state Passes in the GameState object so to draw the KoopaTroopa with the correct information. 
	 */
	public KoopaTroopaMoving(GameState state, int x, int y)
	{
		super(state, x, y);
	}

	public void update(double elapsedTime)
	{
//		if(MouseX < 600)
//			;
	}

	public void draw(Graphics g, GameView view)
	{
		
	}
}
