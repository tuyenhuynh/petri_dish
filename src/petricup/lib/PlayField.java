package petricup.lib;

public class PlayField {
    com.golden.gamedev.object.PlayField m_playField;
    
    public PlayField(){
        m_playField = new com.golden.gamedev.object.PlayField();
    }
    
    public void setBackground(ImageBackground bg) {
        m_playField.setBackground(bg.m_imageBackground);
    }
    
    public void addGroup(SpriteGroup spriteGroup){
        m_playField.addGroup(spriteGroup.m_spriteGroup);
    }
    
    public void addCollisionGroup(SpriteGroup sg1, SpriteGroup sg2, BasicCollisionGroup cm){
        m_playField.addCollisionGroup(sg1.m_spriteGroup, sg2.m_spriteGroup, cm);
        cm.setCollisionGroup(sg1, sg2);
    }
    
    public void update(long e){
        m_playField.update(e);
    }
    
    public void render(Graphics2D g2d){
        m_playField.render(g2d.get());
    }
    
    public void render(java.awt.Graphics2D g2d){
        m_playField.render(g2d);
    }
}
