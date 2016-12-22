package controller;

import game.Game;
import game.PetriDish;

/**
 * Controller of petri dish 's movement.
 * @author anhcx
 */
public abstract class PetriController {
    
    public PetriController(Game g, PetriDish p) {
        petri = p;
        game = g;
    }
    
    /**
     * 
     * @param elapsedTime
     */
    public abstract void update(long elapsedTime);
    
    public PetriDish getPetriDish (){
        return this.petri; 
    }
    
    PetriDish petri;
    Game game;
}
