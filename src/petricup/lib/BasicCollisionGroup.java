package petricup.lib;

import java.util.List;

/**
 * Группа для поиска пересечений между спрайтами
 */
public class BasicCollisionGroup {
    /**
     * Конструирует новую группу
     */
    public BasicCollisionGroup() {
            
    }
    
    /**
     * Запускает проверку коллизий для спрайтов
     */
    public void checkCollision() {
        if (m_group1 != null && m_group2 != null) {
            List<GameSprite> sprites1 = m_group1.toList();
            List<GameSprite> sprites2 = m_group2.toList();
            for (int i = 0; i < sprites1.size(); i++) {
                for (int j = 0; j < sprites2.size(); j++) {
                    GameSprite s1 = sprites1.get(i);
                    GameSprite s2 = sprites2.get(j);                    
                    if (s1 != s2) {
                        if (s1.getCollisionShape().collidesWith(s2.getCollisionShape())) {
                            this.collided(s1, s2);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Устанавливает группы для происка пересечений 
     * @param s1 первая группа
     * @param s2 вторая группа
     */
    public void setCollisionGroup(SpriteGroup s1, SpriteGroup s2) {
        m_group1 = s1;
        m_group2 = s2;
    }
        
    
    /**
     * Обрабатывает коллизии.
     * @param first первый спрайт
     * @param second второй спрайт
     */
    public void collided(GameSprite first, GameSprite second) {
        
    }
    
    /**
     * Первая группа для определения пересечений
     */
    SpriteGroup m_group1;
    
    /**
     * Вторая группа для определения пересечений
     */
    SpriteGroup m_group2;    
}