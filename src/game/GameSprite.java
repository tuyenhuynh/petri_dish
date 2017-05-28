package game;
        
public class GameSprite extends petricup.lib.GameSprite {
    
    /**
     * Set speed to object.
     * @param speed speed
     */
    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
        setHorizontalSpeed(speed * Math.cos(GameMath.degreesToRadians(angle)));
        setVerticalSpeed(speed * Math.sin(GameMath.degreesToRadians(angle)));
    }
    
    /**
     * Set direction to object.
     * @param angle angle
     */
    @Override
    public void setDirection(int angle) {
        this.angle = angle;
        setHorizontalSpeed(speed * Math.cos(GameMath.degreesToRadians(angle)));
        setVerticalSpeed(speed * Math.sin(GameMath.degreesToRadians(angle)));
    }
}
