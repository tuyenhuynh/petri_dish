package game;

import petricup.lib.GameEngine;
import petricup.lib.GameObject;

public class MultiScreenGame extends GameEngine {
    public void create () {
        
    }

    /*
    public void render () {
        super.render();
    }
*/

    public void dispose () {
        
    }
    
    public MultiScreenGame(){
        super();
    }
    
    @Override
    public GameObject getGame(int GameID) {
       switch (GameID) {
          case 0: return new GameMain(this);
          case 1: return new GameFinish(this);
       }
       return null;
    }
}
