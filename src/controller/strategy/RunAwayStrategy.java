package controller.strategy;

import game.GameMath;
import game.PetriDish;

/**
 *
 * @author tuyenhuynh
 */
public class RunAwayStrategy implements Strategy{
    
    /**
     * Find direction for AI when it has to run away from player
     * @param player - player
     * @param petri - AI
     * @return - angle which defines AI's direction
     */
    @Override
    public int findDirection(PetriDish player, PetriDish petri){
        int angle = GameMath.angle(petri.getPosition(), player.getPosition());         
        return (angle + 180)%360;
    }
}
