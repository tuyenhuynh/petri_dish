package petricup.lib;

public class Timer{
    com.golden.gamedev.object.Timer m_timer;
    public Timer(int delay) {
        m_timer = new com.golden.gamedev.object.Timer(delay);
    }
    
    public boolean action(long time) {
        return m_timer.action(time);
    }
}