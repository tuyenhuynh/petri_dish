package petricup.lib;

import java.awt.Point;

/**
 * Mathematical function. Using in the game.
 * @author anhcx
 */
public class GameMath {
    /**
     * Convert angle from degree to radian.
     * @param angle angle (degree)
     * @return angle (radian)
     */
    public static double degreesToRadians(int angle) {
        return angle * Math.PI / 180.0;
    }
    
    /**
     * Convert angle from radian to degree.
     * @param angle angle (radian)
     * @return angle (degree)
     */
    public static int radiansToDegrees(double angle) {
        return (int) (angle * 180.0 / Math.PI);
    }
    
    /**
     * Get distance between to point.
     * @param x1 coordinate x of first point
     * @param y1 coordinate y of first point
     * @param x2 coordinate x of second point
     * @param y2 coordinate x of second point
     * @return distance
     */
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    /**
     * Get distance between to point.
     * @param p1 first point
     * @param p2 second point
     * @return distance
     */
    public static double distance(Point p1, Point p2) {
        return GameMath.distance(p1.x, p1.y, p2.x, p2.y);
    }
    
    /**
     * Get angle between two point in the field.
     * @param p1 first point
     * @param p2 second point
     * @return angle (radian)
     */
    public static int angle(Point p1, Point p2) {
        int angle = radiansToDegrees(Math.atan((p2.y - p1.y) / (double)(p2.x - p1.x)));
        if (p2.x < p1.x)
            angle += 180;
        return angle;
    }
    
    /**
     * Get opposite point with a point is center.
     * @param p point, what is need to get opposite
     * @param center center point
     * @return opposite point
     */
    public static Point getOppositePoint(Point p, Point center) {
        int newX = p.x - 2 * (p.x - center.x);
        int newY = p.y - 2 * (p.y - center.y);
        return new Point(newX, newY);
    }
}