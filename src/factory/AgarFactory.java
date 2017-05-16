package factory;

import game.Agar;
import game.GameMain;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 * Factory to create agar.
 * @author anhcx
 */
public class AgarFactory {
    
    private final int AGAR_CONST = 500;
    GameMain game;
    
    /**
     * Constructor.
     * @param g game
     */
    public AgarFactory(GameMain g) {
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
            p = new Point(r.nextInt(GameMain.TOTAL_HEIGHT-200), r.nextInt(GameMain.TOTAL_HEIGHT-200));
            Agar agar = new Agar(col, p);
            game.AGAR_GROUP.add(agar);
            game.getAgarList().add(agar); 
        }
    }
}
