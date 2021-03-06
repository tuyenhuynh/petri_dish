package collision;

import game.Game;
import game.PetriDish;
import petricup.lib.GameSprite;
import petricup.lib.PreciseCollisionGroup;

/**
 *
 * @author anhcx
 */
public class PetriDangerCollision extends PreciseCollisionGroup{

    /**
     *
     * @param g
     */
    public PetriDangerCollision(Game g) {
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
    
    Game owner;
    
}
