/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import main.group.GroupAI;

/**
 * Class to change screen game: main game and screen lose game
 * @author dungdunght
 */
public class OptionGame extends GameEngine{
     public GameObject getGame(int GameID) {
       switch (GameID) {
          case 0: return new GameStart(this);
          case 1: return new Game(this, 1);
          case 2: return new Game(this, 2);
          case 3: return new GameFinish(this);
       }
       return null;
    }
}
