/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author tuyenhuynh
 */
public abstract class GameSprite{
    com.golden.gamedev.object.Sprite m_sprite = new com.golden.gamedev.object.Sprite();
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
        
    }
    
    /**
     * Set position to object.
     * @param position position
     */
    public void setPosition(Point position) {
        m_sprite.setX(position.getX() - 1 / 2);
        m_sprite.setY(position.getY() - 1 / 2);
    }
    
    /**
     * Get position of object.
     * @return position of object.
     */
    public Point getPosition() {
        Point position = new Point();
        position.x = (int) (m_sprite.getX());
        position.y = (int) (m_sprite.getY());
        
        return position;
    }

    /**
     * Set speed to object.
     * @param speed speed
     */
    public abstract void setSpeed(double speed);
    
    public void setSpeed(double horizontalSpeed, double verticalSpeed){
        m_sprite.setSpeed(horizontalSpeed, verticalSpeed);
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
    public abstract void setDirection(int angle);

    /**
    * Get direction of object
     * @return direction (angle)
     */
    public int getDirection() {
        return angle;
    }

    public void setHorizontalSpeed(double speed){
        m_sprite.setHorizontalSpeed(speed);
    }

    public void setVerticalSpeed(double speed) {
        m_sprite.setVerticalSpeed(speed);
    }
    
    public void setActive(boolean active){
        m_sprite.setActive(active);
    }
    
    public double getHorizontalSpeed(){
        return m_sprite.getHorizontalSpeed();
    }
    
    public double getVerticalSpeed(){
        return m_sprite.getVerticalSpeed();
    }
    
    public void setImage(BufferedImage bi){
        m_sprite.setImage(bi);
    }
    
    public boolean isActive(){
        return m_sprite.isActive();
    }

}
