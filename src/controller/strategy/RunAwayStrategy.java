/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
