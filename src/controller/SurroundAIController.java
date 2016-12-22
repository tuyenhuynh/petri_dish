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
public class SurroundAIController extends PetriController{
    public SurroundAIController(Game game, PetriDish player, PetriDish petri) {
        super(game, petri);
        this.player = player;
        System.out.println(player); 
        int angle = GameMath.angle(petri.getPosition(), player.getPosition());
        petri.setDirection(angle);
    }
    
    /**
     * Базовая реализация лишь проверяет, что спрайт не вышел за поля
     * @param elapsedTime 
     */
    @Override
    public void update(long elapsedTime) {
        int direction = player.getDirection(); 
        double dx = player.getSpeed()*Math.cos(GameMath.degreesToRadians(direction)) *100; 
        double dy = player.getSpeed()*Math.sin(GameMath.degreesToRadians(direction)) *100; 
        
        Point playerPos = player.getPosition();
        Point spritePos = petri.getPosition();
        
        Point lo = new Point(playerPos.x, playerPos.y);
        Point newPlayerPos = new Point((int)(playerPos.x + dx), (int)(playerPos.y + dy));
        double e = 1e-3;
        while (Math.abs(dx) > e || Math.abs(dy) > e){
            Point ret = new Point((int)(lo.x + dx / 2), (int)(lo.y + dy / 2));
            double dis1 = GameMath.distance(ret, playerPos);
            double dis2 = GameMath.distance(ret, spritePos);
            //System.out.println(dx + " " + dy);
            if (Math.abs(dis1 - 2 *dis2) < e){
                newPlayerPos = ret;
                break;
            }
            dx = dx / 2;
            dy = dy / 2;
            if (dis1 < dis2){
                lo = ret;
            }
        }
       
        double distance = GameMath.distance(spritePos, newPlayerPos);
        //if (distance > AIController.MAX_DISTANCE) {
            int angle = GameMath.angle(petri.getPosition(), newPlayerPos);
            petri.setDirection(angle);
        //}
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
