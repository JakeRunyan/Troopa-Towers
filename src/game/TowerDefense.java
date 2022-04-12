/**
 * Tower Defense -- Application Main
 * 
 * @author Peter Jensen (feel free to add your name if you make changes)
 * @version Spring 2022
 */
package game;

public class TowerDefense 
{
	/**
	 * Application entry point
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) 
	{
		// Build a game control object.  All the work of building the
		// game and getting it going is done in a single GameControl
		// object.  No further work is needed in main.
				
		new GameControl();  // Don't even bother storing the result.
		
		// The main thread of execution ends here.  Note that the GUI
		// thread is still running, and our event callback methods will
		// be executed by the GUI thread when the appropriate events happen.
		// (The main thread ends quickly, the GUI thread lasts as long as
		// the JFrame exists.)
	}

}
