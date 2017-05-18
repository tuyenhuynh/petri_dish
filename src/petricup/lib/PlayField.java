/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuyenhuynh
 */
public class PlayField {
    ImageBackground m_bg;
    List<SpriteGroup> list_spriteGroup = new ArrayList<>();
    List<BasicCollisionGroup> list_collisionGroup = new ArrayList<>();
    
    public PlayField(){
        
    }
    
    public void setBackground(ImageBackground bg) {
        m_bg = bg;
    }
    
    public void addGroup(SpriteGroup spriteGroup){
        list_spriteGroup.add(spriteGroup);
    }
    
    public void addCollisionGroup(SpriteGroup sg1, SpriteGroup sg2, BasicCollisionGroup cg){
        cg.setCollisionGroup(sg1, sg2);
        list_collisionGroup.add(cg);
    }
    
    public void update(long e){
        list_spriteGroup.stream().forEach((s) -> {
            s.update(e);
        });
        list_collisionGroup.stream().forEach((cg) -> {
            cg.checkCollision();
        });
    }
    
    public void render(Graphics2D g2d){
        m_bg.render(g2d);
        list_spriteGroup.stream().forEach((s) -> {
            s.render(g2d);
        });
    }
    
    public void render(java.awt.Graphics2D g2d){
    }    
}
