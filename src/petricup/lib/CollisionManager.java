/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

/**
 *
 * @author nghiand
 */
public class CollisionManager {
    SpriteGroup sg1;
    SpriteGroup sg2;
    BasicCollisionGroup cm;

    public CollisionManager(SpriteGroup sg1, SpriteGroup sg2, BasicCollisionGroup cm) {
        this.sg1 = sg1;
        this.sg2 = sg2;
        this.cm = cm;
    }
    
    public SpriteGroup getSg1() {
        return sg1;
    }

    public void setSg1(SpriteGroup sg1) {
        this.sg1 = sg1;
    }

    public SpriteGroup getSg2() {
        return sg2;
    }

    public void setSg2(SpriteGroup sg2) {
        this.sg2 = sg2;
    }

    public BasicCollisionGroup getCm() {
        return cm;
    }

    public void setCm(BasicCollisionGroup cm) {
        this.cm = cm;
    }
}
