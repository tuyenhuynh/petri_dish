/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petri.collision.event;

import java.util.EventObject;

/**
 * fire signal about petri killed
 * @author dungdunght
 */
public class PetriPetriCollisionEvent extends EventObject{
    
    public PetriPetriCollisionEvent(Object source) { 
        super(source); 
    }
    
}
