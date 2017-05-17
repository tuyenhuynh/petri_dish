/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import java.awt.Font;

/**
 *
 * @author tuyenhuynh
 */
public class SystemFont{
    com.golden.gamedev.object.font.SystemFont m_font;
    
    public SystemFont(String fontName, int attrs, int size, java.awt.Color clr) {
        m_font = new com.golden.gamedev.object.font.SystemFont(new Font(fontName, attrs, size), clr);
    }
    
    public void drawString(Graphics2D g, String data, int x, int y) {
        m_font.drawString(g.get(), data, x, y);
    }   
}
