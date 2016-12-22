/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getLogger(Agar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
