package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y, 0);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 5);
        assertEquals(p1.y, -3);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);
    }

    /** should generate a random value for the x and y coordinates for each point */
    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertTrue("P1 x is out of range",p1.x > -5 && p1.x < 3);
        assertTrue("P1 y is out of range",p1.y > -5 && p1.y < 3);
        assertTrue("P2 x is out of range",p2.x > -5 && p2.x < 3);
        assertTrue("P2 y is out of range",p2.y > -5 && p2.y < 3);
    }

    /** verify that both of the points should be set to (0,0) */
    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y,0);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0,-8,10);
        testPoints.setPoint(1, -9, 5);
        testPoints.copy(0,1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, -8);
        assertEquals(p1.y, 10);
        assertEquals(p2.x, -8);
        assertEquals(p2.y,10);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -1);
        testPoints.setPoint(1, -5, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double distanceActual = Math.sqrt(Math.pow(p2.x-p1.x,2)+Math.pow(p2.y-p1.y,2));
        assertEquals(testPoints.distance(), distanceActual, 1);
    }

    @Test
    public void slope() throws Exception{
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -11);
        testPoints.setPoint(1, -5, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double slopeActual = (p2.y-p1.y)/(p2.x-p2.y);
        assertEquals(testPoints.slope(),slopeActual,1);
    }

} //TwoPointsTest