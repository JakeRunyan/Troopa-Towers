package game;

import java.awt.Graphics;
import java.awt.Color;

public class StartButton implements Animatable
{
    public void update(double elapsedTime)
    {
        
    }

    public void draw(Graphics g, GameView view)
    {      
        // Draw the text
        g.setColor(Color.WHITE);
        g.drawString("Press Lakitu to start the game", 625, 450);

        // Draw the Image
        view.drawCenteredImage(g, "resources/lakitu.png", 700, 500, 50);
        
    }
}