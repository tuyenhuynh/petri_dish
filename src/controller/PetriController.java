package controller;

import game.GameMain;
import game.PetriDish;

/**
 * Controller of petri dish 's movement.
 * @author anhcx
 */
public abstract class PetriController {
    
    PetriDish petri;
    GameMain game;
    
    public PetriController(GameMain g, PetriDish p) {
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
    
}
