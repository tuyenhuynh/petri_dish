/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petricup.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author nghiand
 */
public class Game extends com.badlogic.gdx.Game{
 
    /**
     * Инициализация ресурсов игры
     */
    @Override
    public void create() {        
        m_batch = new SpriteBatch();    
        m_ctx = new Graphics2D(m_batch);
        
        this.setScreen(m_gameEngine.getGame(0).m_scene);
    }

    /**
     * Рендеринг игры
     */
    @Override
    public void render () {
        super.render();
    }
    
    /**
     * Batch для рисования
     */
    SpriteBatch m_batch;
    
    /**
     * Псевдо-графический контекст. В данном случае - контейнер длв Batch
     */
    Graphics2D  m_ctx;
    
    /**
     * Глобальная камера игры для того, чтобы фон мог получить текущее смещение 
     * камеры
     */
    static Camera m_current_camera;
    
    GameEngine m_gameEngine;
}
