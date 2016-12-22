/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.listener;

import game.PetriDish;

/**
 *
 * @author tuyenhuynh
 */
public interface CollisionListener {
    public void collided(PetriDish petriDish); 
    public void gameFinished(); 
}
