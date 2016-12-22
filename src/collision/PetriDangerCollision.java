package collision;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.PreciseCollisionGroup;
import game.Game;
import game.PetriDish;

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
    public void collided(Sprite sprite, Sprite sprite1) {
        
        PetriDish petriDish = (PetriDish)sprite; 
//        if(!petriDish.isBot()){
//        }
        ((PetriDish) sprite).collided();
        sprite.setSpeed(-sprite.getHorizontalSpeed(), -sprite.getVerticalSpeed());       
    }
    
    Game owner;
    
}
