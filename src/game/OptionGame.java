/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import main.group.SurroundGroupAI;

/**
 * Class to change screen game: main game and screen lose game
 * @author dungdunght
 */
public class OptionGame extends GameEngine{
     public GameObject getGame(int GameID) {
       switch (GameID) {
          case 0: 
             return new Game(this, new SurroundGroupAI());
          case 1: 
              return new GameFinish(this);
       }
       return null;
    }
}
