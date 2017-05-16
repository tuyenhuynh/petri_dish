package controller;


import controller.strategy.RunAwayStrategy;
import controller.strategy.Strategy;
import controller.strategy.SurroundStrategy;
import game.Agar;
import game.GameMain;
import game.GameMath;
import game.PetriDish;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Controller AI.
 */
public class AIController extends PetriController {
    
    private Strategy moveStrategy; 
    
    private static final int DISTANCE = 10; 
    
    /**
     * Игрок
     */
    PetriDish player;
    /**
     * Максимальное расстояние
     */
    static final int MAX_DISTANCE = 240;

    private void setMoveStrategy(Strategy moveStrategy) {
        this.moveStrategy = moveStrategy; 
    }
    
    public AIController(GameMain game, PetriDish player, PetriDish petri) {
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
            //this.setMoveStrategy(new RunAwayStrategy()); 
            this.setMoveStrategy(new SurroundStrategy());
        }else {
            this.setMoveStrategy(new SurroundStrategy());
        }
        int angle = this.moveStrategy.findDirection(player, petri);
        petri.setDirection(angle);
        
        if(petri.getBotMode() != 0 ) {
            for(Agar agar : game.getAgarList()) {
                double distance = GameMath.distance(petri.getPosition(), agar.getPosition());
                if(distance <= petri.getRenderedSize() + DISTANCE) {
                    
                    int agarDirection;
                    if(petri.getBotMode() == 1) {//PUSH
                        agarDirection = (GameMath.angle(agar.getPosition(), petri.getPosition()) + 180) %360;
                    }else { //PULL
                        agarDirection = (GameMath.angle(agar.getPosition(), petri.getPosition()));
                    }
                    agar.setDirection(agarDirection);
                    agar.setSpeed(0.05);
                    Timer timer = new Timer(500, null);
                    timer.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            agar.setSpeed(0);
                            timer.stop();
                        }
                    });
                    timer.start();
                }
            }
        }
    }
}
