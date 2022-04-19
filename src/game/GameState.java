/**This class keeps track of all the numbers and information behind the game's mechanics.
 * @author Jake Runyan, Nathan Atwood
 * @version April 12th, 2022 */
package game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameState implements MouseMotionListener, MouseListener
{
	// Fields
	private GameControl control;
	private Path path;
	private int life;
	private int credit;
	private boolean gameOver;
	private List<Animatable> objects;
	private int mouseX, mouseY;
	private boolean mouseClicked;
	
	/** Construct all the data needed track the state of the game. 
	 * 
	 * @param control - Gives access to the data inside of the GameControl object. 
	 */
	public GameState (GameControl control)
	{
		this.control = control;
		// Set Initial Life and Credit
		this.life = 100;
		this.credit = 1000;

		// Construct list of things to animate. 
		objects = new ArrayList<Animatable>();
		
		objects.add(new Background());
		objects.add(new Menu(life, credit));
		objects.add(new KoopaTroopaMenu(this, 635, 100));
		objects.add(new Mario(this));
		
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
	}	
	
	/**	Right now, this method updates all the items.
	 * 
	 * @param elapsedTime - The amount of time that has passed since the beginning of the game. 
	 */
	public void updateAll(double elapsedTime)
	{
		for(Animatable item : objects)
			item.update(elapsedTime);
		
		// If there hasn't been a mouse click that hasn't been consumed, consume it.
		mouseClicked = false;
	}

	/** Mutator method to add things to the list of animatable objects. 
	 * 
	 * @param thingToAdd - Whatever the user wants to add to the list of objects to animate. 
	 */
	public void addAnimatable(Animatable thingToAdd)
	{
		objects.add(thingToAdd);
		System.out.println("The add animatable helper method was called.");
	}

	/** Change the amount of life the player has depending on how hard they are hit by the enemy. 
	 * 
	 * @param amount The amount of life to add or subtract. Can be positive or negative.  
	 */	
	public void lifeEditor(int amount)
	{
		this.life -= amount;
	}

	/** Change the amount of credit the player has depending what they buy and how many karts they hit.  
	 * 
	 * @param amount The amount of credit to add or subtract. Can be positive or negative.  
	 */	
	public void creditEditor(int amount)
	{
		this.credit -= amount;
	}


	// MOUSE EVENTS
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	public void mouseClicked(MouseEvent e)
	{
		mouseClicked = true;
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	// NOTE FROM NATHAN - WE MAY WANT TO ADD A MUTATOR MATHOD TO 
	//					  REMOVE THINGS FROM THE LIST AS WELL. I 
	//					  HAVENT ADDED IT YET BECASUE I WANTED TO
	//		 			  SEE IF WE ACTUALLY NEEDED IT BEFORE I 
	//					  WRITE IT. 
}