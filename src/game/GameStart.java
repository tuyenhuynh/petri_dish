/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import petricup.lib.GameEngine;
import petricup.lib.GameObject;
import petricup.lib.ImageBackground;

/**
 *
 * @author tuyenhuynh
 */
public class GameStart extends GameObject {
    private ImageBackground background; 
    public GameStart(GameEngine parent) {
        super(parent);
        
    } 
    @Override
    public void update(long elapsedTime) {
        background.update(elapsedTime);
        if (this.keyPressed(KeyEvent.VK_1)) {
          parent.nextGameID = 1;
          finish();
        }else if (this.keyPressed(KeyEvent.VK_2)) {
          parent.nextGameID = 2;
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
        gd.drawString("PRESS 1 TO PLAY MODE 1 - GROUP AI" , 400,250 );
        gd.drawString("PRESS 2 TO PLAY MODE 2 - AI WITH POSSIBILITY PULL/PUSH AGARS" , 300,300 );
    } 
}
