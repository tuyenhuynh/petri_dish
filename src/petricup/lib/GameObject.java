package petricup.lib;

import java.awt.Graphics2D;

/**
 *
 * @author tuyenhuynh
 */
public class GameObject extends com.golden.gamedev.GameObject{

    public GameObject(GameEngine ge) {
        super(ge);
    }
    
    private GameEngine gameEngine;
    
    @Override
    public void initResources() {
        
    }
    
    @Override
    public void render(java.awt.Graphics2D g2) {
    }
    
    public void render(Graphics2D g2d){
        this.render(g2d.get());
    }
}
