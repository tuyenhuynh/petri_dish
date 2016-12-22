package collision;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import game.Game;
import game.PetriDish;

/**
 * Class to check Agar - Petri collision, and perform by logic game.
 * @author anhcx
 */
public class AgarPetriCollision extends BasicCollisionGroup{
    
    /**
     * Constructor with a owner
     * @param g game - owner
     */
    public AgarPetriCollision(Game g) {
        this.pixelPerfectCollision = true;
        owner = g;
    }
    
    /**
     * Check collision between Agar and Petri
     * @param sprite agar
     * @param sprite1 petri
     */
    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        // remove agar from game field.
        sprite.setActive(false);
        
        // make petri bigger
        ((PetriDish)sprite1).growUp(1);
    }
    
    Game owner;
    
}
