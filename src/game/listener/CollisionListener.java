package game.listener;

import game.PetriDish;

/**
 *
 * @author tuyenhuynh
 */
public interface CollisionListener {
    public void collided(PetriDish petriDish); 
    public void gameFinished(); 
}
