package game;

import java.awt.Graphics;
import java.awt.Color;

public class StartButton implements Animatable
{
	private GameState state;
	private int x, y;
	public StartButton(GameState state, int x, int y)
	{
		this.state = state;
		this.x = x;
		this.y = y;
	}
    public void update(double elapsedTime)
    {
    	if(state.getMouseClicked() && state.gameStarted)
		{
			int deltaX = Math.abs(x - state.getMouseX());
			int deltaY = Math.abs(y - state.getMouseY());
			
			if(deltaX < 40 && deltaY < 40)
			{
				state.consumeClick();
			}
		}
    }

    public void draw(Graphics g, GameView view)
    {      
        // Draw the text
        g.setColor(Color.WHITE);
        g.drawString("Press Lakitu to start the game", 625, 450);

        // Draw the Image
        view.drawCenteredImage(g, "resources/lakitu.png", x, y, 50);
        
    }
}