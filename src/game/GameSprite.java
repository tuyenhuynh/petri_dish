package game;

import com.golden.gamedev.object.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Bridge from GTGE sprite and this game 's sprite.
 * @author anhcx
 */
public class GameSprite extends Sprite {
    /**
     * Color of sprite.
     * This color will be fill as a background of icon.
     */
    protected Color color = null;
    
    /**
     * Icon of sprite.
     */
    protected BufferedImage icon = null;
    
    /**
     * Angle (in degree) of speed vector.
     */
    protected int angle = 0;
    
    /**
     * Speed of sprite.
     */
    protected double speed = 0;
    
    /**
     * Graphic.
     */
    protected Graphics2D g2d;
    
    /**
     * Draw appearance of sprite. 
     */
    protected void repaint() {
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
    
    /**
     * Set position to object.
     * @param position position
     */
    public void setPosition(Point position) {
        this.setX(position.getX() - 1 / 2);
        this.setY(position.getY() - 1 / 2);
    }
    
    /**
     * Get position of object.
     * @return position of object.
     */
    public Point getPosition() {
        Point position = new Point();
        position.x = (int) (getX());
        position.y = (int) (getY());
        
        return position;
    }

    /**
     * Set speed to object.
     * @param speed speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
        setHorizontalSpeed(speed * Math.cos(GameMath.degreesToRadians(angle)));
        setVerticalSpeed(speed * Math.sin(GameMath.degreesToRadians(angle)));
    }

    /**
     * Get speed of object.
     * @return speed of object.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Set color to object.
     * @param color color
     */
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    /**
     * Set icon to object.
     * @param icon icon 
     */
    public void setIcon(BufferedImage icon) {
        this.icon = icon;
        repaint();
    }
    
    /**
     * Set direction to object.
     * @param angle angle
     */
    public void setDirection(int angle) {
        this.angle = angle;
        setHorizontalSpeed(speed * Math.cos(GameMath.degreesToRadians(angle)));
        setVerticalSpeed(speed * Math.sin(GameMath.degreesToRadians(angle)));
    }

    /**
    * Get direction of object
     * @return direction (angle)
     */
    public int getDirection() {
        return angle;
    }
    
}
