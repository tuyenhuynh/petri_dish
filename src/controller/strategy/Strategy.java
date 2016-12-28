package controller.strategy;

import game.PetriDish;

/**
 *
 * @author tuyenhuynh
 */
public interface Strategy {
   
    /**
     * Find direction for AI when it has to run away from player
     * @param player - player
     * @param petri - AI
     * @return - angle which defines AI's direction
     */
    public int findDirection(PetriDish player, PetriDish petri);
}
