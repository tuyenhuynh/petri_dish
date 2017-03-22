package main.group;

import controller.AIController;
import controller.PetriController;
import game.Game;
import game.PetriDish;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuyenhuynh
 */
public class GroupAI {
    List<PetriController> controllers =new ArrayList<>(); 
    protected Game game; 
    protected PetriDish player; 
    
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Set sprite controller
     * @param player - sprite player.
     */
    public void setPlayer(PetriDish player) {
        this.player = player;
    }

    /**
     * Add controller for sprite sprite.
     * @param petriDish - sprite whose controller will be added.
     */
    public void addAIController(PetriDish petriDish) {
        controllers.add(new AIController(game, player, petriDish));
    }
    
    /**
     * Remove controller by sprite.
     * @param petriDish - sprite whose controller will be removed.
     */
    public void removeAIController(PetriDish petriDish) {
        for(PetriController controller: controllers){
            if(controller.getPetriDish() == petriDish){
                controllers.remove(controller);
                break;
            }
        } 
    }
    
    /**
     * Update group AI.
     * @param elapsedTime - elapsedTime.
     */
    public void update(long elapsedTime){
        for(PetriController controller: controllers) {
            controller.update(elapsedTime); 
        }
    }
    
}
