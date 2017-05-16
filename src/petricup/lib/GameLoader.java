package petricup.lib;


import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import java.awt.Dimension;

/**
 * Загрузчик игрового экрана
 */
public class GameLoader {
    /**
     * Инициализация загрузчика игрового экрана
     */
    public GameLoader() {
        m_config = new LwjglApplicationConfiguration();
        m_app = null;
    }
    /**
     * Устанавливает игру для отображения
     * @param game игра
     * @param windowSize размер экрана
     * @param fullscreen играть в фуллскрин?
     */
    public void setup(GameEngine game, Dimension windowSize, boolean fullscreen) {
        m_config.width = windowSize.width;
        m_config.height = windowSize.height;
        m_config.fullscreen = fullscreen;
        m_config.foregroundFPS = 60;
        m_config.resizable = false;
        
        m_game = game;
    }
    
    /**
     * Запускает игру, блокируя дальнейшее исполнение потока
     */
    public void start() {
        m_app = new LwjglApplication(m_game, m_config);
    }    
    
    
    /**
     * Конфигурация приложения
     */
    LwjglApplicationConfiguration m_config;
    
    /**
     * Приложение для запуска
     */
    LwjglApplication m_app;
    
    /**
     * Игра, которая будет исполняться в приложении
     */
    GameEngine m_game;
}
