/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import com.golden.gamedev.object.Sprite;

/**
 *
 * @author tuyenhuynh
 */
public class BasicCollisionGroup extends com.golden.gamedev.object.collision.BasicCollisionGroup {
    
    public BasicCollisionGroup() {
        super();
    }
    
    @Override
    public void collided(Sprite sprite1, Sprite sprite2) {
        if (m_sg1 == null || m_sg2 == null)
            return;
            //System.out.println("a");
        GameSprite gs1 = m_sg1.get(sprite1);
        GameSprite gs2 = m_sg2.get(sprite2);    
        this.collided(gs1, gs2);
        
    }
    
    public void collided(GameSprite sprite1, GameSprite sprite2) {
        
    }
    
    public void setCollisionGroup(SpriteGroup sg1, SpriteGroup sg2){
        super.setCollisionGroup(sg1.m_spriteGroup, sg2.m_spriteGroup);
        m_sg1 = sg1;
        m_sg2 = sg2;
    }
    
    SpriteGroup m_sg1;
    SpriteGroup m_sg2;
}
