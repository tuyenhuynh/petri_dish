/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

/**
 *
 * @author tuyenhuynh
 */
public class Timer {
    private long delay;			// action delay
    private long currentTick;
    
    public Timer(int delay) {
        this.delay = delay;
        this.currentTick = 0;
    }
    
    public boolean action(long l) {
        currentTick += l;
        if (currentTick >= delay) {
            // time elapsed!

            // currentTick = 0;
            // synch the current tick to make the next tick accurate
            currentTick -= delay;

            return true;
        }
        return false;
    }
    
}
