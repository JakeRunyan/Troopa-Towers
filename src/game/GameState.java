/**This class keeps track of all the numbers and information behind the game's mechanics.
 * @author Jake Runyan, Nathan Atwood
 * @version April 12th, 2022 */
package game;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GameState 
{
	// Fields
	private Path path;
	private List<Animatable> objects;
	
	/** Construct all the data needed track the state of the game. 
	 * 
	 * @param control - Gives access to the data inside of the GameControl object. 
	 */
	public GameState (GameControl control)
	{
		objects.add(new Background(control));
		objects.add(new Menu());
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
		// Draw the background and the menu
//		background.draw(g, view);
//		menu.draw(g, view);
//		for (Animatable item : objects)
//		{
////			item.draw(g, view);
//			System.out.println(item);
//		}
		// Draw the path
		path.drawPath(g);
		
		// Draw the Mario
//		mario.draw(g, view);
	}	
	
	/**	 
	 * Right now, this methos only updates mario, but it will also update all
	 *  of the other enemies and other towers that we introduce nto the game. 
	 * 
	 * @param elapsedTime - The amouht of time that has passed since the beginning of the game. 
	 */
	public void updateAll(double elapsedTime)
	{
//		mario.update(elapsedTime);
	}
}