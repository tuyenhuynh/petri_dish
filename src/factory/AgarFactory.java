package factory;

import game.Agar;
import game.Game;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 * Factory to create agar.
 * @author anhcx
 */
public class AgarFactory {
    
    private final int AGAR_CONST = 500;
    
    /**
     * Constructor.
     * @param g game
     */
    public AgarFactory(Game g) {
        game = g;
    }
    
    /**
     * Generate agar.
     */
    public void generate() {
        Random r = new Random();
        
        for (int i = 0; i < AGAR_CONST; i++) {
            Color col = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            Point p;
            p = new Point(r.nextInt(Game.TOTAL_HEIGHT-200), r.nextInt(Game.TOTAL_HEIGHT-200));
            game.AGAR_GROUP.add(new Agar(col, p));
        }
    }
    
    Game game;
}
