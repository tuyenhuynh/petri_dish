package collision;

import game.GameMain;
import game.PetriDish;
import petricup.lib.GameSprite;
import petricup.lib.BasicCollisionGroup;

/**
 *
 * @author anhcx
 */
public class PetriDangerCollision extends BasicCollisionGroup{

    /**
     *
     * @param g
     */
    public PetriDangerCollision(GameMain g) {
        this.pixelPerfectCollision = true;
        owner = g;
    }
    
    /**
     *
     * @param sprite Petri
     * @param sprite1 Danger
     */
    @Override
    public void collided(GameSprite sprite, GameSprite sprite1) {
        
        PetriDish petriDish = (PetriDish)sprite; 
        if(!petriDish.isBot()){
            
        }
        ((PetriDish) sprite).collided();
        sprite.setSpeed(-sprite.getHorizontalSpeed(), -sprite.getVerticalSpeed());       
    }
    
    GameMain owner;
    
}
