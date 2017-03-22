package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import petricup.lib.GameEngine;
import petricup.lib.ImageBackground;

/**
 * Screen losing game and next to new game 
 * @author dungdunght
 */
public class GameFinish extends petricup.lib.GameObject {
    private ImageBackground background; 
    public GameFinish(GameEngine parent) {
       super(parent);
    } 
     
    @Override
    public void update(long elapsedTime) {
        background.update(elapsedTime);
        if (click()) {
          parent.nextGameID = 0;
          finish();
        }
    }
    @Override
    public void initResources() {
        try{
            background = new ImageBackground(ImageIO.read(new File("resources/background.jpg")));
            background.setClip(0, 0, Game.TOTAL_HEIGHT, Game.TOTAL_WIDTH);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void render(Graphics2D gd) {
        background.render(gd);
        gd.setFont(new Font("Arial", Font.BOLD, 20));
        gd.setColor(Color.RED);
        gd.drawString("YOU LOSE !CLICK TO SCREEN TO START NEW GAME" , 100,100 );
    }
}

