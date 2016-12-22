/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.group;

import game.Game;
import game.PetriDish;
import controller.FollowAIController;

/**
 *
 * @author tuyenhuynh
 */
public class FollowGroupAI extends GroupAI{

    public FollowGroupAI() {
    }

    @Override
    public void addAIController(PetriDish petriDish) {
         controllers.add(new FollowAIController(game, player, petriDish));
    }

}
