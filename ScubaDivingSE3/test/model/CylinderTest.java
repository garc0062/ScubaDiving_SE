/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo
 */
public class CylinderTest {

    public CylinderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of all points of the oxygen-nitrogen cylinder so that
     * oxygen-nitrogen cylinder is properly drawn.
     */
    @Test
    public void testPointsToDrawCylinder() {
        System.out.println("draw points");

        //cylinder for minimum oxygen
        Cylinder cylinder = new Cylinder(SimpleCalculation.MIN_OXYGEN_VALUE);
        assertEquals(200, cylinder.getXUpperLeftOxygen(), 0);
        assertEquals(70, cylinder.getYUpperLeftOxygen(), 0);
        assertEquals(160, cylinder.getXOxygenCurve(), 0);
        assertEquals(170, cylinder.getYOxygenCurve(), 0);
        assertEquals(200, cylinder.getXLowerLeftOxygen(), 0);
        assertEquals(270, cylinder.getYLowerLeftOxygen(), 0);
        assertEquals(288, cylinder.getXLowerRightOxygen(), 0);
        assertEquals(270, cylinder.getYLowerRightOxygen(), 0);
        assertEquals(288, cylinder.getXUpperRightOxygen(), 0);
        assertEquals(70, cylinder.getYUpperRightOxygen(), 0);
        assertEquals(288, cylinder.getXUpperLeftNitrogen(), 0);
        assertEquals(70, cylinder.getYUpperLeftNitrogen(), 0);
        assertEquals(640, cylinder.getXNitrogenCurve(), 0);
        assertEquals(170, cylinder.getYNitrogenCurve(), 0);
        assertEquals(288, cylinder.getXLowerLeftNitrogen(), 0);
        assertEquals(270, cylinder.getYLowerLeftNitrogen(), 0);
        assertEquals(600, cylinder.getXLowerRightNitrogen(), 0);
        assertEquals(270, cylinder.getYLowerRightNitrogen(), 0);
        assertEquals(600, cylinder.getXUpperRightNitrogen(), 0);
        assertEquals(70, cylinder.getYUpperRightNitrogen(), 0);

        //cylinder for maximum oxygen
        cylinder = new Cylinder(SimpleCalculation.MAX_OXYGEN_VALUE);
        assertEquals(200, cylinder.getXUpperLeftOxygen(), 0);
        assertEquals(70, cylinder.getYUpperLeftOxygen(), 0);
        assertEquals(160, cylinder.getXOxygenCurve(), 0);
        assertEquals(170, cylinder.getYOxygenCurve(), 0);
        assertEquals(200, cylinder.getXLowerLeftOxygen(), 0);
        assertEquals(270, cylinder.getYLowerLeftOxygen(), 0);
        assertEquals(400, cylinder.getXLowerRightOxygen(), 0);
        assertEquals(270, cylinder.getYLowerRightOxygen(), 0);
        assertEquals(400, cylinder.getXUpperRightOxygen(), 0);
        assertEquals(70, cylinder.getYUpperRightOxygen(), 0);
        assertEquals(400, cylinder.getXUpperLeftNitrogen(), 0);
        assertEquals(70, cylinder.getYUpperLeftNitrogen(), 0);
        assertEquals(640, cylinder.getXNitrogenCurve(), 0);
        assertEquals(170, cylinder.getYNitrogenCurve(), 0);
        assertEquals(400, cylinder.getXLowerLeftNitrogen(), 0);
        assertEquals(270, cylinder.getYLowerLeftNitrogen(), 0);
        assertEquals(600, cylinder.getXLowerRightNitrogen(), 0);
        assertEquals(270, cylinder.getYLowerRightNitrogen(), 0);
        assertEquals(600, cylinder.getXUpperRightNitrogen(), 0);
        assertEquals(70, cylinder.getYUpperRightNitrogen(), 0);
    }
}
