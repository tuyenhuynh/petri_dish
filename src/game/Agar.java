package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Agar - food of petri dish.
 * When petri dish eat him, petri dish will grow up by 1.
 * @author anhcx
 */
public class Agar extends GameSprite {
    
    /**
     * Constructor default.
     * @param c color of agar
     * @param pos position of agar
     */
    public Agar(Color c, Point pos) {
        try { 
            BufferedImage icon = ImageIO.read(new File("resources/agar.png"));
            this.setIcon(icon);
            this.setColor(c);
            this.setPosition(pos);
            this.setSpeed(0);
        } catch (IOException ex) {
            //Logger.getLogger(Agar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void repaint(){
        if (color != null && icon != null) {
            // Get area to re-paint
            BufferedImage bi = new BufferedImage(icon.getWidth(), icon.getHeight(), BufferedImage.TYPE_INT_ARGB);

            // Fill area with color
            g2d = bi.createGraphics();               
            g2d.setColor(color);
            g2d.fillOval(0, 0, bi.getWidth(), bi.getHeight());

            // Draw the border
            g2d.setColor(color.darker().darker());
            g2d.setStroke(new BasicStroke(2));
            g2d.drawOval(0, 0, icon.getWidth(), icon.getHeight());

            // Draw icon of object
            g2d.drawImage(icon, 0, 0, null);

            this.setImage(bi);
        }
    }
}
