/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petri.collision.event;

import java.util.EventListener;
import petricup.lib.GameSprite;

/**
 *
 * @author dungdunght
 */
public interface PetriPetriCollisionListener extends EventListener{
    public void DieEnermy(GameSprite e);
}
