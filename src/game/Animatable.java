/** This class handles creating the window and generating the graphics within.
 * @author Jake Runyan, Nathan Atwood
 * @version April 12th, 2022 */
package game;

import java.awt.Graphics;

public interface Animatable 
{
	public void update (double elapsedTime);
	
	public void draw (Graphics g, GameView view);
}
