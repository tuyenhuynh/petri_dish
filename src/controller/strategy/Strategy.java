/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.strategy;

import game.PetriDish;

/**
 *
 * @author tuyenhuynh
 */
public interface Strategy {
    public int findDirection(PetriDish player, PetriDish petri);
}
