/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
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
     * Test of draw method, of class Cylinder.
     */
    @Test
    public void testPointsToDrawCylinder() {
        System.out.println("draw");
        Graphics g = null;
        Cylinder instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
