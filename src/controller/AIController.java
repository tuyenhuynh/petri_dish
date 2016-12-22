package controller;


import controller.strategy.RunAwayStrategy;
import controller.strategy.Strategy;
import controller.strategy.SurroundStrategy;
import game.Game;
import game.GameMath;
import game.PetriDish;
import java.awt.Point;

/**
 * Controller AI.
 */
public class AIController extends PetriController {
    
    private Strategy moveStrategy; 
    
    private void setMoveStrategy(Strategy moveStrategy) {
        this.moveStrategy = moveStrategy; 
    }
    
    public AIController(Game game, PetriDish player, PetriDish petri) {
        super(game, petri);
        this.moveStrategy = new RunAwayStrategy();
        this.player = player;
        int angle = GameMath.angle(petri.getPosition(), player.getPosition());
        petri.setDirection(angle);
    }
    
    /**
     * Базовая реализация лишь проверяет, что спрайт не вышел за поля
     * @param elapsedTime 
     */
    @Override
    public void update(long elapsedTime) {
        if(petri.size() < player.size() + 2) {
            this.setMoveStrategy(new RunAwayStrategy());
            
        }else {
            this.setMoveStrategy(new SurroundStrategy());
        }
        int angle = this.moveStrategy.findDirection(player, petri);
        petri.setDirection(angle);
    }
    
    /**
     * Игрок
     */
    PetriDish player;
    /**
     * Максимальное расстояние
     */
    static final int MAX_DISTANCE = 240;
}
