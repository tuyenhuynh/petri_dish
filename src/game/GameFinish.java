package game;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import petricup.lib.GameEngine;
import petricup.lib.ImageBackground;
import petricup.lib.Graphics2D;
import petricup.lib.SystemFont;
import utils.LocalizationUtil;

public class GameFinish extends petricup.lib.GameObject {
    private ImageBackground background;
    SystemFont font;
    
    public GameFinish(GameEngine parent) {
        super(parent);
        font = new SystemFont("Arial", 0, 20, Color.red);
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
            background.setClip(0, 0, GameMain.dimensions().width, GameMain.dimensions().height);
            background.setTotalClip(GameMain.TOTAL_WIDTH, GameMain.TOTAL_HEIGHT);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void renderInContext(Graphics2D gd){
        background.render(gd);
        font.drawString(gd, LocalizationUtil.getLocalizationStr("lost"), 100, 100);
    }
}

