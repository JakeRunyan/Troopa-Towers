/**Once mario is hit with a shell he needs to decrease in size until he is no longer visible. 
 * @author Jake Runyan, Nathan Atwood
 * @version April 25th, 2022 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class LuigiDying implements Animatable {

    private double location;
    private GameState state;
    private int scale;

    /**
	 * Constructor for the Luigi object. 
	 * 
	 * @param state Passes in the GameState object so to draw the Luigi with the correct information. 
	 */
	public LuigiDying(GameState state) {
		this.state = state;
        this.scale = 35;
        // this.location = 
	}

    @Override
    public void update(double elapsedTime) {
        // Decrease Mario's Size
        if (this.scale >= 0)
            this.scale += -1;
    }

    @Override
    public void draw(Graphics g, GameView view) {
        Point point = new Point(state.getPath().locatePosition(location));
		view.drawCenteredImage(g, "resources/mario.png", (int)point.getX(), (int)point.getY(), this.scale);
    }
    
}
