package controller;

import game.Game;
import game.GameMath;
import game.PetriDish;

/**
 * Control the player 's Petri dish.
 * @author anhcx
 */
public class PlayerController extends PetriController {
    
    /**
     * Constructor.
     * @param g game
     * @param p petri dish
     */
    public PlayerController(Game g, PetriDish p) {
        super(g, p);
    }
    
    /**
     * Update controller.
     * @param elapsedTime
     */
    @Override
    public void update(long elapsedTime) {
        int angle = GameMath.angle(petri.getPosition(), game.mousePosition());
        petri.setDirection(angle);
    }
}
