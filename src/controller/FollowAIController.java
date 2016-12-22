/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import game.Game;
import game.GameMath;
import game.PetriDish;
import java.awt.Point;

/**
 *
 * @author tuyenhuynh
 */
public class FollowAIController extends PetriController{
    public FollowAIController(Game game, PetriDish player, PetriDish petri) {
        super(game, petri);
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
        Point playerPos = player.getPosition();
        Point spritePos = petri.getPosition();
        double dist = GameMath.distance(spritePos, playerPos);
        if (dist > AIController.MAX_DISTANCE) {
            int angle = GameMath.angle(petri.getPosition(), player.getPosition());
            petri.setDirection(angle);
        }
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
