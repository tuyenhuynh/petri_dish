/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import com.badlogic.gdx.graphics.Texture;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import petricup.lib.collision.Ellipse;

/**
 * Класс спрайта
 */
public abstract class GameSprite {
    
    /**
     * Создает спрайт по умолчанию
     */
    public GameSprite() {
        m_active = true;
    }
    
    /**
     * Создает спрайт с изображением x и y
     * @param bi изображение
     * @param x X-координата спрайта
     * @param y Y-координата спрайта
     */
    public GameSprite(BufferedImage bi, int x, int y) {        
        m_x = x;
        m_old_x = x;
        m_y = y;
        m_old_y = y;
        setImage(bi);
    }
    
    /**
     * Устанавливает изображение для спрайта
     * @param bi изображение
     */
    public final void setImage(BufferedImage bi) {
        m_texture = TextureManager.getTexture(bi);
        m_shape = new Ellipse(
                m_x +  m_texture.getWidth() / 2, 
                m_y -  m_texture.getHeight() / 2, 
                m_texture.getWidth() / 2, 
                m_texture.getHeight() / 2
        );        
    }
    
    /**
     * Обновление состояния спрайта
     * @param elapsed прошедшее время
     */
    public void update(long elapsed) {
        double nx = m_x + m_horizontal_speed * elapsed;
        double ny = m_y + m_vertical_speed * elapsed;
        
        m_old_x = m_x;
        m_old_y = m_y;
        
        m_x = nx;
        m_y = ny;
        
        m_shape.x0 = m_x +  m_texture.getWidth() / 2;
        m_shape.y0 = m_y -  m_texture.getHeight() / 2;
    }
    
    /**
     * Рисует спрайт 
     * @param g контекст
     */
    public void render(Graphics2D g) {
        if (m_texture != null)  {
            g.getBatch().draw(
                m_texture, 
                (float)m_x, 
                (float)(m_y - m_texture.getHeight())
            );
        }
    }
    
    /**
     * Устанавливает X-координату спрайта
     * @param x координата спрайта
     */
    public void setX(double x) {
        m_x = x;
        m_shape.x0 = x + m_texture.getWidth() / 2;
    }

    /**
     * Устанавливает Y-координату спрайта
     * @param y координата спрайта
     */
    public void setY(double y) {
        m_y = y;
        m_shape.y0 = y - m_texture.getHeight() / 2;
    }


    /**
     * Возвращает X-координату спрайта
     * @return X-координата спрайта
     */    
    public double getX() {
        return m_x;
    }

    /**
     * Возвращает Y-координату спрайта
     * @return Y-координата спрайта
     */
    public double getY() {
        return m_y;
    }

    /**
     * Устанавливает горизонтальную скорость спрайта
     * @param v скорость
     */    
    public void setHorizontalSpeed(double v) {
        m_horizontal_speed = v;
    }

    /**
     * Устанавливает вертикальную скорость спрайта
     * @param v скорость
     */
    public void setVerticalSpeed(double v) {
        m_vertical_speed = v;
    }

    /**
     * Возвращает старую X-координату
     * @return 
     */    
    public double getOldX() {
        return m_old_x;
    }
    
    /**
     * Возвращает старую Y-координату
     * @return 
     */
    public double getOldY() {
       return m_old_y;
    }  
    
    /**
     * Возвращает центр спрайта
     * @return центр спрайта
     */
    public Point getCenter() {
        return new Point((int)m_shape.x0,(int) m_shape.y0);
    }
    
    /**
     * Возвращает фигуру для коллизии
     * @return фигура для коллизии
     */
    public Ellipse getCollisionShape() {
        return m_shape;        
    }

    /**
     * Возвращает ширину спрайта
     * @return ширина спрайта
     */
    public int getWidth() {
        return m_texture.getWidth();
    }

    /**
     * Возвращает высоту спрайта
     * @return высота спрайта
     */
    public int getHeight() {
        return m_texture.getHeight();
    }    
    
    /**
     * Возвращает горизонтальную скорость
     * @return горизонтальная скорость
     */
    public double getHorizontalSpeed() {
        return m_horizontal_speed;
    }
    
    /**
     * Возвращает вертиальную скорость
     * @return вертикальная скорость
     */
    public double getVerticalSpeed() {
        return m_vertical_speed;
    }
    
    /**
     * Останавливает спрайт при выходе за пределы прямоугольника [0;0;totalWidth;totalHeight]
     * @param totalWidth макс. ширина
     * @param totalHeight макс. высота
     */
    public void stopOnGoingOutOfBounds(double totalWidth, double totalHeight) {            
        if (this.getX() <= 0 && this.getHorizontalSpeed() < 0) {
            this.setHorizontalSpeed(0);
        }
        if (this.getX() + this.getWidth() >= totalWidth && this.getHorizontalSpeed() > 0) {
            this.setHorizontalSpeed(0);
        }
        if (this.getY() - this.getHeight() <= 0 && this.getVerticalSpeed() < 0) {
            this.setVerticalSpeed(0);
        }
        if (this.getY() >= totalHeight && this.getVerticalSpeed() > 0) {
            this.setVerticalSpeed(0);
        }
    }
    
    public void setActive(boolean active) {
        m_active = active;
    }
    
    public boolean isActive(){
        return m_active;
    }
    
    public void setSpeed(double vx, double vy) {
        this.setHorizontalSpeed(vx);
        this.setVerticalSpeed(vy);
    }
    
    public Point getPosition(){
        return new Point((int)this.getX(), (int)this.getY());
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
    
    /**
     * Set speed to object.
     * @param speed speed
     */
    public abstract void setSpeed(double speed);
    
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
     * Draw appearance of sprite. 
     */
    protected void repaint() {
        
    }
    
    /**
     * Set position to object.
     * @param position position
     */
    public void setPosition(Point position) {
        this.setX(position.x);
        this.setY(position.y);
    }
    
    /**
     * Текстура
     */
    Texture m_texture;    
    /**
     * Форма для отображения спрайта
     */
    Ellipse m_shape;
    /**
     * X-координата центра спрайта
     */
    double m_x = 0;
    /**
     * Y-координата центра спрайта
     */
    double m_y = 0;
    /**
     * "Старая" X-координата спрайта
     */
    double m_old_x = 0;
    /**
     * "Старая" Y-координата спрайта
     */
    double m_old_y = 0;
    
    /**
     * Горизональная скорость спрайта
     */
    double m_horizontal_speed = 0;
    /**
     * Вертикальная скорость спрайта
     */
    double m_vertical_speed = 0;
    
    protected int angle = 0;
    
    protected double speed = 0;
    
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
     * Graphic.
     */
    protected java.awt.Graphics2D g2d;
    
    public boolean m_active;
}
