package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * This is danger. Petri will be blocked by it.
 * @author anhcx
 */
public class Danger extends GameSprite {
    
    protected int size;
    
    /**
     * Constructor with position of danger on the map.
     * @param pos position will place danger
     */
    public Danger(Point pos) {
        Random r = new Random();
        try { 
            BufferedImage icon = ImageIO.read(new File("resources/danger.png"));
            size = icon.getHeight() / 3;
            this.setIcon(icon);
            this.setColor(Color.green);
            this.setPosition(pos);
            this.setSpeed(0);
        } catch (IOException ex) {
            Logger.getLogger(Agar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void repaint() {
        if (color != null && icon != null) {
            
            System.out.println("Controller repaint!");
            // Get area to re-paint
            BufferedImage bi = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

            // Fill area with color
            g2d = bi.createGraphics();               

            // Draw icon of object
            g2d.drawImage(icon, 0, 0, size, size, null);
            
            this.setImage(bi);
        }
    }
    
    public int getSize(){
        return this.size; 
    }
}
