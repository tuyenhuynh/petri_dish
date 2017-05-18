package petricup.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 *
 * @author tuyenhuynh
 */
public class GameObject {
    Scene m_scene;
    public GameEngine parent;
    
    public GameObject(GameEngine ge) {
        parent = ge;
        m_scene = new Scene(this);
        MyInputProcessor inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
    }
    
    public void update(long e){
        
    }
    
    public void initResources(){
        
    }
 
    public void renderInContext(Graphics2D g2d){
        
    }
    
    public void render(java.awt.Graphics2D g2d){

    }
    
    protected void finish(){
        this.m_scene.dispose();
        parent.m_game.setScreen(parent.getGame(parent.nextGameID).m_scene);
    }
    
    protected boolean click(){
        return m_click;
    }
    

    /**
     * Получение координаты X курсора мыши в окне
     * @return координата X курсора в окне
     */
    public int getMouseX() {
        return Gdx.input.getX() - Gdx.graphics.getWidth() / 2;
    }

    /**
     * Получение координаты Y курсора мыши в окне
     * @return координата Y курсора в окне 
     */    
    public int getMouseY() {
        return (Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
    }
    
    private class MyInputProcessor implements InputProcessor{
        @Override
        public boolean touchDown(int x, int y, int pointer, int button) {
            if (button == Input.Buttons.LEFT) {
                m_click = true;
                return true;
            }
            return false;
        }

        @Override
        public boolean keyDown(int i) {
            return false;
        }

        @Override
        public boolean keyUp(int i) {
            return false;
        }

        @Override
        public boolean keyTyped(char c) {
            return false;
        }

        @Override
        public boolean touchUp(int i, int i1, int i2, int i3) {
            return false;
        }

        @Override
        public boolean touchDragged(int i, int i1, int i2) {
            return false;
        }

        @Override
        public boolean mouseMoved(int i, int i1) {
            return false;
        }

        @Override
        public boolean scrolled(int i) {
            return false;
        }
    }
    
    private boolean m_click = false;
}
