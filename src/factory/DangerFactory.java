package factory;

import game.Danger;
import game.GameMain;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author anhcx
 */
public class DangerFactory {
    private  GameMain game;
    public DangerFactory(GameMain g) {
        game = g;
    }
    
    private List<Danger> dangers = new ArrayList<>(); 
    
    /**
     * Generate new danger.
     */
    public void generate() {
        Random r = new Random();
        for (int i = 0; i < GameMain.NUMBER_DANGER; i++) {
            int x = r.nextInt(GameMain.TOTAL_HEIGHT-200);
            int y = r.nextInt(GameMain.TOTAL_WIDTH-200);
            Danger d = new Danger(new Point(x, y));
            game.DANGER_GROUP.add(d);
            dangers.add(d);
        }
    }
    
    
    /**
     * Get dangers list.
     * @return list of dangers
     */
    public List<Danger> getDangers(){
        return this.dangers;
    }
}
