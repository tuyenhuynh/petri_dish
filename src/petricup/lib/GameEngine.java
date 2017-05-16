/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Главный класс игры
 */
public class GameEngine extends Game {

    /**
     * Инициализация ресурсов игры
     */
    @Override
    public void create () {
        m_camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        m_camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        m_camera.update();
        m_current_camera = m_camera;
        
        m_batch = new SpriteBatch();    
        m_ctx = new Graphics2D(m_batch);
        
        this.initResources();
    }    
    
    /**
     * Инициализация ресурсов игры
     */
    public void initResources() { 
        
    }
    
    /**
     * Обновляет состояние игры
     * @param elapsedTime время, прошедшее с предыдущего обновления
     */
    public void update(long elapsedTime) {
        
    }
 
    /**
     * Рендеринг игры
     */
    @Override
    public void render () {
        m_camera.update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        // This cryptic line clears the screen.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update((long) (Gdx.graphics.getDeltaTime() * 1000.0));
        
        m_ctx.getBatch().setProjectionMatrix(m_camera.combined);
        
        m_ctx.begin();
        renderInContext(m_ctx);
        m_ctx.end();
    }
        
    /**
     * Отрисовывет состояние игры
     * @param g контекст
     */    
    public void renderInContext(Graphics2D g) {
        
    }
    
    /**
     * Освобождение ресурсов игры
     */
    @Override
    public void dispose () {
           TextureManager.disposeTextures();
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
    
    /**
     * Камера
     */
    OrthographicCamera m_camera;
    
    /**
     * Глобальная камера игры для того, чтобы фон мог получить текущее смещение 
     * камеры
     */
    static Camera m_current_camera;
    
    /**
     * Batch для рисования
     */
    SpriteBatch m_batch;
    
    /**
     * Псевдо-графический контекст. В данном случае - контейнер длв Batch
     */
    Graphics2D  m_ctx;
}
