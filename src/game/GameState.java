/**This class keeps track of all the numbers and information behind the game's mechanics.
 * @author Jake Runyan, Nathan Atwood
 * @version April 12th, 2022 */
package game;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameState 
{
	// Fields
	private GameControl control;
	private Path path;
	private List<Animatable> objects;
	private Animatable background;  //
	private Animatable menu;  //
	private Animatable mario;  //
	
	/** Construct all the data needed track the state of the game. 
	 * 
	 * @param control - Gives access to the data inside of the GameControl object. 
	 */
	public GameState (GameControl control)
	{
		this.control = control;
		
		// Construct list of things to animate. 
		objects = new ArrayList<Animatable>();
		
		objects.add(new Mario(this)); // pass in things from game state becasue mario is one of the moving items on the screen. 
		
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
		for( Animatable singleObject : objects) {
			singleObject.draw(g, view);
		}
	}	
	
	/**	 
	 * Right now, this methos only updates mario, but it will also update all
	 *  of the other enemies and other towers that we introduce nto the game. 
	 * 
	 * @param elapsedTime - The amouht of time that has passed since the beginning of the game. 
	 */
	public void updateAll(double elapsedTime)
	{
		mario.update(elapsedTime);
	}

	/**
	 * 
	 * Mutator method to add things to the list of animateable objects. 
	 * 
	 * @param thingToAdd - Whatever the user wants to add to the list of objects to animate. 
	 */
	public void addAnimatable(Animatable thingToAdd) {

		objects.add(thingToAdd);
		System.out.println("The add animatable helper method was called.");
	}

	// NOTE FROM NATHAN - WE MAY WANT TO ADD A MUTATOR MATHOD TO 
	//					  REMOVE THINGS FROMTHE LIST AS WELL. I 
	//					  HAVENT ADDED IT YET BECASUE I WANTED TO
	//		 			  SEE IF WE ACTUALLY NEEDED IT BEFORE I 
	//					  WRITE IT. 
}