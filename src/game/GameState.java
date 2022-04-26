/**This class keeps track of all the numbers and information behind the game's mechanics.
 * @author Jake Runyan, Nathan Atwood
 * @version April 19th, 2022 */
package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameState implements MouseMotionListener, MouseListener
{
	// Fields
	private List<Animatable> objects;
	private List<Animatable> objectsToAdd;
	private List<Animatable> objectsToRemove;
	
	private Path path;
	
	private int timer;
	private int life;
	private int credit;
	public boolean gameStarted;
	
	private int mouseX, mouseY;
	private boolean mouseClicked;
	
	/** Construct all the data needed track the state of the game. 
	 * 
	 * @param control - Gives access to the data inside of the GameControl object. 
	 */
	public GameState (GameControl control)
	{
		// Set Initial Life, Timer, and Credit
		this.timer = 0;
		this.life = 100;
		this.credit = 600;
		
		// Construct list of things to animate.
		objects = new ArrayList<Animatable>();
		objectsToAdd = new ArrayList<Animatable>();
		objectsToRemove = new ArrayList<Animatable>();
		
		objects.add(new Background());
		objects.add(new Menu(this));
		objects.add(new StartButton(this, 700, 500));
		objects.add(new GreenKoopaTroopaMenu(this, control, 635, 100, 50));
		objects.add(new RedKoopaTroopaMenu(this, control, 635, 200, 100));
		
		// Build our path
		try
		{
			Scanner reader = new Scanner(new File("src/resources/path.txt"));
			path = new Path(reader);		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	


	// UPDATE AND DRAW HELPER METHODS
	/** Load the path to use into the game. 
	 * 
	 * @return a path to use in the game. 
	 */
	public Path getPath()
	{
		return path;
	}
	
	/** Draw all of the objects in the game onto the screen. 
	 * 
	 * @param g - A graphics object to correctly draw the components on the screen. 
	 * @param view - Access to the GameView class so the different objects can correctly draw themselves on the screen. 
	 */
	public void drawAll(Graphics g, GameView view)
	{
		for(Animatable singleObject : objects)
			singleObject.draw(g, view);

		// If the game is over then draw the game over screen.
		if (life <= 0) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, 800, 600);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 350, 300);
		}
	}	
	
	/**	Right now, this method updates all the items.
	 * 
	 * @param elapsedTime - The amount of time that has passed since the beginning of the game. 
	 */
	public void updateAll(double elapsedTime)
	{
		// Updating all current objects.
		for(Animatable item : objects)
			item.update(elapsedTime);

		// Add Mario and Luigi objects as needed
		if (timer % 75 == 0 && gameStarted)
			objects.add(new Mario(this));
		
		if (timer % 250 == 10 && gameStarted)
			objects.add(new Luigi(this));
		
		// Adding and removing all objects that are to be added or removed.
		objects.addAll(objectsToAdd);
		objects.removeAll(objectsToRemove);

		objectsToAdd.clear();
		objectsToRemove.clear();
		// If there hasn't been a mouse click that hasn't been consumed, consume it.
		mouseClicked = false;

		// Check if the Game Needs to End
		if (life <= 0)
			gameOver();
		
		// Update the timer
		timer++;
	}

	/** Mutator method to add things to the list of animatable objects. 
	 * 
	 * @param thingToAdd - Whatever the user wants to add to the list of objects to animate. 
	 */
	public void addAnimatable(Animatable thingToAdd)
	{
		objectsToAdd.add(thingToAdd);
	}

	/** Mutator method to remove things from the list of animatable objects. This method 
	 *  creates a list of things to remove, and then those objects are removed at the end of the frame. 
	 * 
	 * @param thingToAdd - Whatever the user wants to add to the list of objects to animate. 
	 */
	public void removeAnimatable(Animatable thingToRemove)
	{
		objectsToRemove.add(thingToRemove);
	}

	/** Change the amount of life the player has depending on how hard they are hit by the enemy. 
	 * 
	 * @param amount The amount of life to add or subtract. Can be positive or negative.  
	 */	
	public void lifeEditor(int amount)
	{
		this.life -= amount;
	}
	
	/** This helper method returns the current lives the player has.
	 * 
	 * @return life
	 */
	public int getLife()
	{
		return life;
	}

	/** Change the amount of credit the player has depending what they buy and how many karts they hit.  
	 * 
	 * @param amount The amount of credit to add or subtract. Can be positive or negative.  
	 */	
	public void creditEditor(int amount)
	{
		this.credit += amount;
	}
	
	/** This helper method returns the current credits the player has.
	 * 
	 * @return credit
	 */
	public int getCredit()
	{
		return credit;
	}

	/** This method clears all of the objects and makes game over true.
	 */
	public void gameOver() 
	{
		objects.clear();
	}

	/** Finds and returns the enemy object closest tot the tower calling this helper method. 
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Enemy findNearestEnemy (int x, int y) {
		// Set Up Variables for the Loop
		Point p = new Point(x, y);
		Enemy closest = null;
		
		for (Animatable a : objects) { 			// Look through the list of animateables
			if (a instanceof Enemy) {  			// If there is an enemy 
				Enemy e = (Enemy) a;
				if (closest == null)			// Check if it is the closest. 
					closest = e;
				else if (p.distance(e.getLocation()) < p.distance(closest.getLocation()))
					closest = e;
			}

		}
		return closest;						    // Then return the enemy. 

	}











	// MOUSE EVENTS
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mousePressed(MouseEvent e)
	{
		mouseClicked = true;
	}
	
	

		/** An accessor method to get the mouse x coordinate. 
	 * 
	 * @return mouseX
	 */
	public int getMouseX()
	{
		return mouseX;
	}
	
	/** An accessor method to get the mouse Y coordinate. 
	 * 
	 * @return mouseY
	 */
	public int getMouseY()
	{
		return mouseY;
	}
	
	/** An accessor method to get if the mouse is clicked.
	 * 
	 * @return if the mouse is clicked or not.
	 */
	public boolean getMouseClicked()
	{
		return mouseClicked;
	}
	
	/** An accessor method to consume the click.
	 */
	public void consumeClick()
	{
		mouseClicked = false;
	}

	public void mouseClicked(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

}