package game;

import java.awt.Graphics;
import java.awt.Point;

public class FXGreenShell extends FX {
	
	// Fields
	private int deltaX;
	private int deltaY;
	private double age;
	
	// Constructor
	public FXGreenShell(GameState state, int x, int y, int deltaX, int deltaY) {
		super(state, x, y);
		
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		
		System.out.println("Shooting shells is fun!!!");
		}

	// Animateable Methods
	public void update(double elapsedTime) {
		age += .07; // Increase this and the time of the bullet will decrease.
		if (age >= 1.0)
			state.removeAnimatable(this);
		
		x = x + deltaX * elapsedTime * 7;
		y = y + deltaY * elapsedTime * 7;
		
		Point p = new Point((int) x, (int) y);
		Enemy e = state.findNearestEnemy(p.x, p.y);
		
		if(e.getLocation().distance(p) < 30)
		{
			state.removeAnimatable(this);
			state.removeAnimatable(e);
		}
	}
	
	public void draw(Graphics g, GameView view) {
		// TODO Auto-generated method stub
		view.drawCenteredImage(g, "resources/green_shell.png", (int) x, (int) y, 35);
	}
	
	
	

}
