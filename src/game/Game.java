package game;

import PetriCollisionEvent.PetriPetriCollisionListener;
import factory.DangerFactory;
import factory.AgarFactory;
import collision.*;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;
import java.awt.*;
import controller.*;
import java.util.ArrayList;
import java.util.Random;
import main.group.GroupAI;
import controller.PlayerController;
import game.listener.CollisionListener;
import java.awt.image.BufferedImage;

/**
 * Game
 * @author anhcx
 */
public class Game extends GameObject {
    
    
    public static int TOTAL_WIDTH = 6000; 
    
    public static int TOTAL_HEIGHT = 6000;
    
    public static int NUMBER_ENEMY = 30;
    
    public static int NUMBER_DANGER = 50;
    
    public Game(GameEngine gameEngine, GroupAI groupAI) {
        super(gameEngine); 
        this.groupAI = groupAI; 
    }
  
    /**
     * Game play field. Where all event and object are scripted.
     */
    private PlayField playField;

    /**
     * Background. 
     */
    private Background bg;
    
    /** 
     * Group of sprite - petri.
     * This object can eat any agar and grow up.
     */
    SpriteGroup PETRI_GROUP;
    
    private AgarFactory agarFactory;
    
    /**
     * Group of sprite - agar.
     * Be generate each 3s. Agar is food of petri, make them grow up.
     */
    public SpriteGroup AGAR_GROUP;
    
    /**
     * Group of sprite - danger.
     */
    public SpriteGroup DANGER_GROUP;
    private DangerFactory dangerFactory;
    
    
    AgarPetriCollision agarPetriCollision;
    PetriDangerCollision petriDangerCollision;
    PetriPetriCollision petriPetriCollision;
    // All our actor
    private PetriDish player;
    private final java.util.List<PetriDish> spriteList = new ArrayList();
    
    Timer agar_timer = new Timer(10000);
    
    private GroupAI groupAI; 
    
    private PlayerController playerController; 
    
    private static final int AGAR_SIZE =  20; 
    
    @Override
    public void initResources() {
        // create play field.
        playField = new PlayField();
        // add background to play field.
        bg = new ImageBackground(getImage("resources/background.jpg"));
        bg.setClip(0, 0,1080, 720);
        
        PETRI_GROUP = new SpriteGroup("PetriDish");      
        AGAR_GROUP = new SpriteGroup("Agar");
        DANGER_GROUP = new SpriteGroup("Danger");
        
        playField.setBackground(bg);
        
        dangerFactory = new DangerFactory(this);
        dangerFactory.generate();
        
        // generate agar
        agarFactory = new AgarFactory(this);
        agarFactory.generate();        
        
        //TODO: check overlapped between  player and dangers;
        // create player with random on screen 640*480
        Random random = new Random(); 
        boolean added = false; 
        do {
            boolean overlapped = false; 
            Point point = new Point(random.nextInt(880), random.nextInt(520)); 
            player = new PetriDish(getImage("resources/PRIMITIVE_PLANT.png"), false); 
            player.setPosition(point);
            for(Danger danger: dangerFactory.getDangers() ){
                if(isOverlapped( danger, player)){
                    overlapped = true; 
                }
            }
            if(!overlapped) {
                PETRI_GROUP.add(player);
                playerController = new PlayerController(this, player);
                added = true;
            }
        } while (!added);
        
        /*------------------INIT GROUPAI-----------*/
        groupAI.setGame(this);
        groupAI.setPlayer(player);
        
        //Generate ai objects 
        for(int i = 0; i < NUMBER_ENEMY; i++) {
            boolean _added = true; 
            do {
                Point point = new Point(random.nextInt(TOTAL_WIDTH - 200), random.nextInt(TOTAL_HEIGHT -200)); 
                _added = addNewBot(getImage("resources/PRIMITIVE_ANIMAL.png"), point);    
            } while (!_added);
        }
        
        // add all group to game field
        playField.addGroup(PETRI_GROUP);
        playField.addGroup(AGAR_GROUP);
        playField.addGroup(DANGER_GROUP);
//        
        agarPetriCollision = new AgarPetriCollision(this);
        playField.addCollisionGroup(AGAR_GROUP, PETRI_GROUP, agarPetriCollision);
        
        petriDangerCollision = new PetriDangerCollision(this);
        playField.addCollisionGroup(PETRI_GROUP, DANGER_GROUP, petriDangerCollision);
        
        petriPetriCollision = new PetriPetriCollision(this);
        petriPetriCollision.setListener(new CollisionListener(){
            
            @Override
            public void collided(PetriDish petriDish) {
                spriteList.remove(petriDish);
                PETRI_GROUP.remove(petriDish);
                groupAI.removeAIController(petriDish);
                boolean added = true; 
                Random random = new Random(); 
                do {
                    Point point = new Point(random.nextInt(TOTAL_WIDTH - 200), random.nextInt(TOTAL_HEIGHT -200)); 
                    added = addNewBot(getImage("resources/PRIMITIVE_ANIMAL.png"), point);    
                } while (!added); 
            }

            @Override
            public void gameFinished() {
                parent.nextGameID = 1;
                finish();    
            }
        });
        
        petriPetriCollision.setCollisionGroup(PETRI_GROUP, PETRI_GROUP);
        petriPetriCollision.addDivercantChangeCellListner(new AddEnermyObserver());
        playField.addCollisionGroup(PETRI_GROUP, PETRI_GROUP, petriPetriCollision);
        
        // font
        font = fontManager.getFont(getImages("resources/font.png", 20, 3),
                                   " !            .,0123" +
                                   "456789:   -? ABCDEFG" +
                                   "HIJKLMNOPQRSTUVWXYZ ");
    }

    @Override
    public void update(long l) {  
        //update players controllers
        playerController.update(l);
        groupAI.update(l);
        
        if (agar_timer.action(l)) {
            agarFactory.generate();
        }
        
        playField.update(l);
    }
    
    
    @Override
    public void render(Graphics2D gd) {
        // render all characters
        playField.render(gd);   
        
        if(player != null){
            // set center view to player
            bg.setToCenter(player);
        }
        
        // render text
        font.drawString(gd, "PLAYER: " + String.valueOf(player.size()), 10, 10);
        
        for (int i = 0; i < spriteList.size(); i++) {
            font.drawString(gd, "AI " + String.valueOf(i+1) + ":" + String.valueOf(spriteList.get(i).size()), 10, 10+(i+1)*20);
        }      
    }
    
    /**
     * Get mouse position.
     * @return position
     */
    public Point mousePosition() {
        Point p = new Point(this.getMouseX(), this.getMouseY());
        p.x += bg.getX();
        p.y += bg.getY();
        return p;
    }
    
    /**
     * Game fonts.
     */
    GameFont font;
   //receive signal about petri was killed 
   private class AddEnermyObserver implements PetriPetriCollisionListener{
       @Override
        public void DieEnermy(Sprite e) {
            
            if (e==player){
                parent.nextGameID = 1;
                finish();
            }
            spriteList.remove((PetriDish)e);
            PETRI_GROUP.remove(e);
            PetriDish e1 = new PetriDish(getImage("resources/PRIMITIVE_ANIMAL.png"), true);
            spriteList.add(e1);
            PETRI_GROUP.add(e1);
            AIController ai = new AIController(Game.this, player, e1);
            groupAI.removeAIController((PetriDish)e); 
            groupAI.addAIController(e1);
        }
   }
   
   private boolean addNewBot(BufferedImage botImage, Point position){
        PetriDish bot = new PetriDish(botImage, true); 
        bot.setPosition(position);
        for(PetriDish sprite : spriteList){
            if(sprite.isActive() && isOverlapped(sprite, bot)){
                return false; 
            }
        }
        for(Danger danger: dangerFactory.getDangers() ){
            if(isOverlapped( danger, bot)){
                return false; 
            }
        }
        spriteList.add(bot);
        PETRI_GROUP.add(bot);
        groupAI.addAIController(bot);    
        return true;
    }
   
   private boolean isOverlapped(Sprite s1, Sprite s2) {
        int gap = 20;
        Point p1 = null, p2 = null; 
        int size1 = 0, size2 = 0; 
        if(s1 instanceof Agar) {
            size1 = AGAR_SIZE; 
            p1 = ((Agar)s1).getPosition();
        }
        if(s1 instanceof Danger) {
            size1 = ((Danger)s1).getSize();
            p1 = ((Danger)s1).getPosition();
        }
        if(s1 instanceof PetriDish) {
            size1 = ((PetriDish)s1).getRenderedSize(); 
            p1 = ((PetriDish)s1).getPosition();
        }
        
        if(s2 instanceof Agar) {
            size2 = AGAR_SIZE; 
            p2 = ((Agar)s2).getPosition();
        }
        if(s2 instanceof Danger) {
            size2 = ((Danger)s2).getSize();
            p2 = ((Danger)s2).getPosition();
        }
        if(s2 instanceof PetriDish) {
            size2 = ((PetriDish)s2).getRenderedSize(); 
            p2 = ((PetriDish)s2).getPosition();
        }
        boolean overlapped = GameMath.distance(p1, p2) <= size1 + size2 + gap ;
        return overlapped;        
    }
   
}


