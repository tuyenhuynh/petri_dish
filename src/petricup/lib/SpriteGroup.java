/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import com.golden.gamedev.object.Sprite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author tuyenhuynh
 */
public class SpriteGroup{
    com.golden.gamedev.object.SpriteGroup m_spriteGroup;
    
    public SpriteGroup(String string) {
        m_spriteGroup = new com.golden.gamedev.object.SpriteGroup(string);
    }
    
    public void add(GameSprite sprite){
        m_spriteGroup.add(sprite.m_sprite);
        m_map.put(sprite.m_sprite, sprite);
    }
    
    public void remove(GameSprite sprite){
        m_spriteGroup.remove(sprite.m_sprite);
        m_map.remove(sprite.m_sprite);
    }
    
    GameSprite get(com.golden.gamedev.object.Sprite sp){
        return m_map.get(sp);
    }
    
    
    Map<Sprite, GameSprite> m_map = new HashMap<>();
}
