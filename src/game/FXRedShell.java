package game;

import java.awt.Graphics;

public class FXRedShell extends FX {
	
	// Fields
	private int deltaX;
	private int deltaY;
	private double age;
	
	// Constructor
	public FXRedShell(GameState state, int x, int y, int deltaX, int deltaY) {
		super(state, x, y);
		
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		
		System.out.println("Shooting red shells is fun!!!");
		}

	// Animateable Methods
	public void update(double elapsedTime) {
		age += .07; // Increase this and the time of the bullet will decrease.
		if (age >= 1.0)
			state.removeAnimatable(this);
		
		x = x + deltaX * elapsedTime * 7;
		y = y + deltaY * elapsedTime * 7;
	}
	
	@Override
	public void draw(Graphics g, GameView view) {
		view.drawCenteredImage(g, "resources/red_shell.png", (int) x, (int) y, 35);
	}
	
	
	

}