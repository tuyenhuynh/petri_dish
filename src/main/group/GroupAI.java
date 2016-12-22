/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.group;

import controller.PetriController;
import game.Game;
import game.PetriDish;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuyenhuynh
 */
public abstract class GroupAI {
    List<PetriController> controllers =new ArrayList<>(); 
    protected Game game; 
    protected PetriDish player; 
    
    public GroupAI(){ 
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setPlayer(PetriDish player) {
        this.player = player;
    }

    public abstract void addAIController(PetriDish petriDish);
    
    public void removeAIController(PetriDish petriDish) {
        for(PetriController controller: controllers){
            if(controller.getPetriDish() == petriDish){
                controllers.remove(controller);
                break; 
            }
        } 
    }
    
    public void update(long elapsedTime){
        for(PetriController controller: controllers) {
            controller.update(elapsedTime); 
        }
    }
    
}
