package collision;

import petri.collision.event.PetriPetriCollisionListener;
import game.GameMain;
import game.GameMath;
import game.PetriDish;
import game.listener.CollisionListener;
import java.awt.Point;
import java.util.ArrayList;
import petricup.lib.BasicCollisionGroup;
import petricup.lib.GameSprite;

/**
 *  Class to check Petri-petri collision
 * @author dungdunght
 */
public class PetriPetriCollision extends BasicCollisionGroup {
    
    public PetriPetriCollision(GameMain g) {
        super();
        owner = g;
    }
    
    private CollisionListener listener; 
    
    public void setListener(CollisionListener listener) {
        this.listener = listener; 
    }
    
    /**
     * Check collision between Petri and Petri
     * @param sprite1
     * @param sprite2
     */
    @Override
    public void collided(GameSprite sprite1, GameSprite sprite2) {
            
        int size1=((PetriDish)sprite1).getRenderedSize();
        int size2=((PetriDish)sprite2).getRenderedSize();
        PetriDish petriDish1 = (PetriDish)sprite1, 
                petriDish2 = (PetriDish)sprite2; 
        Point p1 = petriDish1.getPosition(),
                    p2 = petriDish2.getPosition();
           
        Point c1 = new Point(p1.x + (int)(petriDish1.getRenderedSize()/2), p1.y + (int) (petriDish2.getRenderedSize()/2));
        Point c2 = new Point(p2.x + (int)(petriDish1.getRenderedSize()/2), p2.y +(int)(petriDish2.getRenderedSize()/2));

        if(size2 > size1 && GameMath.distance(c1, c2) < petriDish2.getRenderedSize()/2) {
            petriDish2.growUp(petriDish1.size());
            petriDish1.setActive(false);
            if(petriDish1.isBot()) { 
                listener.collided(petriDish1);
            }else {
                listener.gameFinished(); 
            }
        }
        if(size1 > size2 && GameMath.distance(c1, c2) < petriDish1.getRenderedSize()/2) {
            petriDish1.growUp(petriDish2.size());
            petriDish2.setActive(false);
            if(petriDish2.isBot()) {
                listener.collided(petriDish2);
            }else {
                listener.gameFinished(); 
            }
        }
    }
    //fire signal about petri was killed
     private ArrayList PetriPetriCollisisonListnerList = new ArrayList();
     public void addDivercantChangeCellListner(PetriPetriCollisionListener l) {
            PetriPetriCollisisonListnerList.add(l);
        }
      protected void fireLossEnermy(GameSprite e) {
        for (Object listener : PetriPetriCollisisonListnerList)
        {        
            ((PetriPetriCollisionListener)listener).DieEnermy(e);
        }        
    }
    GameMain owner;
}
