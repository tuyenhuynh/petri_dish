/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.group;

import controller.SurroundAIController;
import game.Game;
import game.PetriDish;

/**
 *
 * @author tuyenhuynh
 */
public class SurroundGroupAI extends GroupAI{

    public SurroundGroupAI() {
    }

    @Override
    public void addAIController(PetriDish petriDish) {
        controllers.add(new SurroundAIController(game, player, petriDish));
    }
    
}
