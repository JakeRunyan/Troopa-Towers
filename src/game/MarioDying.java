/**Once mario is hit with a shell he needs to decrease in size until he is no longer visible. 
 * @author Jake Runyan, Nathan Atwood
 * @version April 25th, 2022 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class MarioDying implements Animatable {

    private GameState state;
    private int scale;
    private Point position;

    /** Constructor for the Mario object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Mario with the correct information. 
	 */
	public MarioDying(GameState state, Point location) {
		this.state = state;
        this.scale = 35;
        this.position = location;
        state.creditEditor(10);
	}

    /** Shrink Mario in every frame. 
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

    /** Draw Mario at the right place every time. 
     * 
     * @param g A graphics object to draw the Mario on the screen. 
	 * @param view passes in a reference to the GameView class so that all of the images on the screen can draw in the right place. 
     */
    public void draw(Graphics g, GameView view) {
		view.drawCenteredImage(g, "resources/mario.png", (int)position.getX(), (int)position.getY(), this.scale);
    }
    
}
