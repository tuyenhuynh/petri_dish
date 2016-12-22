/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import game.Danger;
import game.Game;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author anhcx
 */
public class DangerFactory {
    private  Game game;
    public DangerFactory(Game g) {
        game = g;
    }
    
    private List<Danger> dangers = new ArrayList<>(); 
    
    /**
     * Generate new danger.
     */
    public void generate() {
        Random r = new Random();
        for (int i = 0; i < Game.NUMBER_DANGER; i++) {
            int x = r.nextInt(Game.TOTAL_HEIGHT-200);
            int y = r.nextInt(Game.TOTAL_WIDTH-200);
            Danger d = new Danger(new Point(x, y));
            game.DANGER_GROUP.add(d);
            dangers.add(d);
        }
    }
    
    public List<Danger> getDangers(){
        return this.dangers;
    }
}
