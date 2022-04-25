package game;

import java.awt.Graphics;
import java.awt.Color;

public class StartButton implements Animatable {

    @Override
    public void update(double elapsedTime) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Graphics g, GameView view) {      
        // Draw the text
        g.setColor(Color.WHITE);
        g.drawString("Press Lakitu to start the game", 650, 700);

        // Draw the Image
        view.drawCenteredImage(g, "resources/mario.png", 700, 600, 35);
        
    }
    
}
