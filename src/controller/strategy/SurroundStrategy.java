/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.strategy;

import game.GameMath;
import game.PetriDish;
import java.awt.Point;

/**
 *
 * @author nghiand
 */
public class SurroundStrategy implements Strategy{
    
    /**
     * Find direction for AI when it has to run away from player
     * @param player - player
     * @param petri - AI
     * @return - angle which defines AI's direction
     */
    @Override
    public int findDirection(PetriDish player, PetriDish petri) {
        int direction = player.getDirection(); 
        double dx = player.getSpeed()*Math.cos(GameMath.degreesToRadians(direction)) *100; 
        double dy = player.getSpeed()*Math.sin(GameMath.degreesToRadians(direction)) *100; 
        
        Point playerPos = player.getPosition();
        Point spritePos = petri.getPosition();
        
        Point lo = new Point(playerPos.x, playerPos.y);
        Point newPlayerPos = new Point((int)(playerPos.x + dx), (int)(playerPos.y + dy));
        double e = 1e-3;
        //find target position for AI
        while (Math.abs(dx) > e || Math.abs(dy) > e){
            Point ret = new Point((int)(lo.x + dx / 2), (int)(lo.y + dy / 2));
            double dis1 = GameMath.distance(ret, playerPos);
            double dis2 = GameMath.distance(ret, spritePos);
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
        //define angle using target position
        int angle = GameMath.angle(petri.getPosition(), newPlayerPos);
        return angle;
    }
}
