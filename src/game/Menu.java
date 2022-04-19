/** This class holds the data to create a functional menu. 
 * @author Jake Runyan, Nathan Atwood
 * @version April 19th, 2022 */

 package game;

import java.awt.Color;
import java.awt.Graphics;

public class Menu implements Animatable
{

	private Integer lives;
	private Integer credit;
	private GameState state;

	/**
	 * Nothing to construct or store in the object. Just need to draw the menu on the screen.
	 */
	public Menu(GameState state)
	{
		this.state = state;
		this.lives = state.getLife();
		this.credit = state.getCredit();
	}
	
	/**
	 * This helper method does not need to be used because the menu does not change from frame to frame.
	 */
	public void update(double elapsedTime)
	{
		lives = state.getLife();
		credit = state.getCredit();
		
	}

	/** This function is to draw the menu background and the menu word.
	 * 
	 * @param g A graphics object to draw the menu on the screen. 
	 * @param view passes in a reference to the GameView class so that all of the images on the screen can draw in the right place. 
	 */
	public void draw(Graphics g, GameView view)
	{
		// Menu Rectangle
		g.setColor(Color.DARK_GRAY);
		g.fillRect(600, 0, 800, 600);

		// Menu Header
		g.setColor(Color.WHITE);
		g.drawString("MENU", 690, 50);

		// Print out the amount of lives
		g.setColor(Color.WHITE);
		g.drawString("Lives", 690, 75);
		g.drawString(Integer.toString(lives), 690, 100);

		// Print out the Amount of Credit
		g.setColor(Color.WHITE);
		g.drawString("Credit", 690, 150);
		g.drawString(Integer.toString(credit), 690, 175);
	}
}
