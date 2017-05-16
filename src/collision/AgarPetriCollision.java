package collision;

import game.GameMain;
import game.PetriDish;
import petricup.lib.BasicCollisionGroup;
import petricup.lib.GameSprite;

/**
 * Class to check Agar - Petri collision, and perform by logic game.
 * @author anhcx
 */
public class AgarPetriCollision extends BasicCollisionGroup{
    
    /**
     * Constructor with a owner
     * @param g game - owner
     */
    public AgarPetriCollision(GameMain g) {
        this.pixelPerfectCollision = true;
        owner = g;
    }
    
    /**
     * Check collision between Agar and Petri
     * @param sprite agar
     * @param sprite1 petri
     */
    @Override
    public void collided(GameSprite sprite, GameSprite sprite1) {
        // remove agar from game field.
        sprite.setActive(false);
        // make petri bigger
        ((PetriDish)sprite1).growUp(1);
    }
    
    GameMain owner;
    
}
