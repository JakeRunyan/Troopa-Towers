/**Once mario is hit with a shell he needs to decrease in size until he is no longer visible. 
 * @author Jake Runyan, Nathan Atwood
 * @version April 25th, 2022 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class LuigiDying implements Animatable {

    private GameState state;
    private int scale;
    private Point position;

    /** Constructor for the Luigi object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Luigi with the correct information. 
	 */
	public LuigiDying(GameState state, Point location) {
		this.state = state;
        this.scale = 35;
        this.position = location;
        state.creditEditor(20);
	}

	/** Shrink Luigi in every frame. 
     * 
     * @param elapsedTime This varible is not used in this update method. 
     */
    public void update(double elapsedTime) {
        // Decrease Mario's Size
        if (this.scale >= 0)
            this.scale += -1;
        else
        	state.removeAnimatable(this);
    }

    /** Draw Luigi at the right place every time. 
     * 
     * @param g A graphics object to draw the Mario on the screen. 
	 * @param view passes in a reference to the GameView class so that all of the images on the screen can draw in the right place. 
     */
    public void draw(Graphics g, GameView view) {
    	view.drawCenteredImage(g, "resources/luigi.png", (int)position.getX(), (int)position.getY(), this.scale);
    }
    
}
