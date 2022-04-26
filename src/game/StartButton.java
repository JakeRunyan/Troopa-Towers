package game;

import java.awt.Graphics;
import java.awt.Color;

public class StartButton implements Animatable
{
	private GameState state;
	private int x, y;
	
	/** This is the constructor for the start button. It just gets the required variables.
	 * 
	 * @param state To get public things from the game state.
	 * @param x coordinate of the start button.
	 * @param y coordinate of the start button.
	 */
	public StartButton(GameState state, int x, int y)
	{
		this.state = state;
		this.x = x;
		this.y = y;
	}
	
	/** This checks to see of the button has been clicked. If so, it changes gameStarted to true.
	 */
    public void update(double elapsedTime)
    {
    	if(state.getMouseClicked())
		{
			int deltaX = Math.abs(x - state.getMouseX());
			int deltaY = Math.abs(y - state.getMouseY());
			
			if(deltaX < 40 && deltaY < 40)
			{
				state.consumeClick();
				state.gameStarted = true;
				state.removeAnimatable(this);
			}
		}
    }

    /** This draws the button and the prompt above it.
     */
    public void draw(Graphics g, GameView view)
    {      
        // Draw the text
        g.setColor(Color.WHITE);
        g.drawString("Press Lakitu to start the game", x-75, y-50);

        // Draw the Image
        view.drawCenteredImage(g, "resources/lakitu.png", x, y, 50);
    }
}