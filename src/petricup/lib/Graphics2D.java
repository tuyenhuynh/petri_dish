/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

/**
 *
 * @author tuyenhuynh
 */
public class Graphics2D {
    
    
    public Graphics2D(java.awt.Graphics2D g) {
        m_g = g;
    }
    
    
    public java.awt.Graphics2D get() {
        return m_g;
    }
    
    public void setFont(java.awt.Font font){
        m_g.setFont(font);
    }
    
    public void setColor(java.awt.Color color){
        m_g.setColor(color);
    }
    
    public void drawString(String s, int x, int y){
        m_g.drawString(s, x, y);
    }
      
    java.awt.Graphics2D m_g;
}
