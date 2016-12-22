/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.golden.gamedev.GameLoader;
import com.golden.gamedev.GameObject;
import game.Game;
import game.OptionGame;
import java.awt.Dimension;

/**
 * Main Class
 * @author anhcx
 */
public class Main {
    
    /**aa
    * Start the game
     * @param args - argument when running game from console
    */
    public static void main(String[] args) {
        GameLoader gameLoader = new GameLoader();
        gameLoader.setup(new OptionGame(), new Dimension(1080, 720), false);
        gameLoader.start();
    }
}
