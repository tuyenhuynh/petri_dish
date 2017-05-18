/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import com.golden.gamedev.GameEngine;

/**
 *
 * @author tuyenhuynh
 */
public class GameObject extends com.golden.gamedev.GameObject{

    public GameObject(GameEngine ge) {
        super(ge);
    }
    
    @Override
    public void update(long elapsedTime) {
        
    }
    
    @Override
    public void initResources() {
        
    }
    
    @Override
    public void render(java.awt.Graphics2D g2) {
        Graphics2D g2d = new Graphics2D(g2);
        renderInContext(g2d);
    }
    
    public void renderInContext(Graphics2D g2d){
        this.render(g2d.get());
    }
}
