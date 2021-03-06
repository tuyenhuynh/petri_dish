package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Petri dish - main hero of game.
 * Can go around with speed and angle,
 * , can eat agar to grow up and eat each other.
 * @author anhcx
 */
public class PetriDish extends GameSprite {
    
    private int size;                   // size of petri dish
    private boolean collided;           // petri dish is collied with danger?
    private long collidedMoment;        // save moment when collided
    private static final int MAX_SIZE = 30; 
    private boolean  isBot; 
    private int botMode; 
    private static final Random random = new Random();
    
    public int getBotMode() {
        return this.botMode;
    }
    
    /**
     * Mark to controller do not change the direction.
     */
    public void collided() {
        collided = true;
        collidedMoment = System.currentTimeMillis();        
    }
    
    /**
     * Constructor with icon of petri dish.
     * @param icon
     * @param isBot
     */
    public PetriDish(BufferedImage icon, boolean isBot){
        collided = false;
        size = 1;
        Random rand=new Random();
        this.setIcon(icon);
        this.setColor(Color.green);
        this.setPosition(new Point((rand.nextInt(Game.TOTAL_WIDTH-1000)), rand.nextInt(Game.TOTAL_HEIGHT-1000)));
        this.setSpeed(0.1);
        this.isBot = isBot;
        if(this.isBot) {
            this.botMode = random.nextInt(2) +1 ;
        }else {
            this.botMode = 0;
        }
    }
    
    @Override
    protected void repaint() {
        if (color != null && icon != null) {
            int iconHeight = icon.getHeight();
            int iconWidth  = icon.getWidth();
            int h_size = iconHeight + Math.min(size, MAX_SIZE);
            
            // Get area to re-paint
            BufferedImage bi = new BufferedImage(h_size, h_size, BufferedImage.TYPE_INT_ARGB);

            // Fill area with color
            g2d = bi.createGraphics();               
            g2d.setColor(color);
            g2d.fillOval(0, 0, h_size, h_size);

            // Draw the border
            g2d.setColor(color.darker().darker());
            g2d.setStroke(new BasicStroke(2));
            g2d.drawOval(0, 0, h_size, h_size);

            // Draw icon of object
            g2d.drawImage(icon, (iconHeight - iconWidth +Math.min(size, MAX_SIZE) )/2, Math.min(size, MAX_SIZE)/2, null);
            
            this.setImage(bi);
        }
    }
    
    /**
     * Set direction to object.
     * @param angle angle
     */
    @Override
    public void setDirection(int angle) {
        this.angle = angle;
        if(isBot){
            if(!collided) {
                
            }
        }
        
        if (!collided) {
            setHorizontalSpeed(speed * Math.cos(GameMath.degreesToRadians(angle)));
            setVerticalSpeed(speed * Math.sin(GameMath.degreesToRadians(angle)));
        } else {
            long curTime = System.currentTimeMillis();
            if (curTime - collidedMoment > 1000) {
                collided = false;
            }
        }
    }
    
    /**
     * Got grew up by increase size.
     * @param amount
     */
    public void growUp(int amount) {
        int delay = 20, time = delay; 
        size += amount;
        repaint();
    }
    
    /**
     * Get size of petri.
     * @return size of petri.
     */
    public int size() {
        return size;
    }
    /**
     * Get size to render sprite, in account to the limit of sprite's size.
     * @return size to render.
     */
    public int getRenderedSize(){
        if(icon != null){
            return Math.min(size, MAX_SIZE) + icon.getHeight();
        }else {
            System.out.println("Icon not found"); 
            return Math.min(size, MAX_SIZE) + 30;
        }
    }
    /**
     * Check whether sprite is enemy.
     * @return true if sprite is enemy, otherwise return false
     */
    public boolean isBot(){
        return this.isBot;
    }
}
