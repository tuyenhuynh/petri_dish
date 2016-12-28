package game;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import main.group.GroupAI;

/**
 * Class to change screen game: main game and screen lose game
 * @author dungdunght
 */
public class OptionGame extends GameEngine{
    @Override
    public GameObject getGame(int GameID) {
       switch (GameID) {
          case 0: return new Game(this);
          case 1: return new GameFinish(this);
       }
       return null;
    }
}
