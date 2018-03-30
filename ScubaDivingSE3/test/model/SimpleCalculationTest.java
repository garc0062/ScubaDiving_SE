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
public class SimpleCalculationTest {

    public SimpleCalculationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setPPO2 method, of class SimpleCalculation.
     */
    @Test
    public void testSetPPO2() {
        System.out.println("setPPO2");
        SimpleCalculation instance = new SimpleCalculation();
        //First Scenario: values outside of range
        assertEquals(false, instance.setPPO2(-5.0F));
        assertEquals(false, instance.setPPO2(0.0F));
        assertEquals(false, instance.setPPO2(1.0F));
        assertEquals(false, instance.setPPO2(1.7F));
        assertEquals(false, instance.setPPO2(10.0F));
        //Second Scenario: values on the edge of range
        assertEquals(true, instance.setPPO2(SimpleCalculation.MIN_PPO2_VALUE));
        assertEquals(true, instance.setPPO2(SimpleCalculation.MAX_PPO2_VALUE));
        //Thrid Scenario: values within the range
        assertEquals(true, instance.setPPO2(1.2F));
        assertEquals(true, instance.setPPO2(1.3F));
        assertEquals(true, instance.setPPO2(1.4F));
        assertEquals(true, instance.setPPO2(1.5F));

    }

    /**
     * Test of setOxygen method, of class SimpleCalculation.
     */
    @Test
    public void testSetOxygen() {
        System.out.println("setOxygen");
        SimpleCalculation instance = new SimpleCalculation();
                //First Scenario: values outside of range
        assertEquals(false, instance.setOxygen(-5));
        assertEquals(false, instance.setOxygen(10));
        assertEquals(false, instance.setOxygen(21));
        assertEquals(false, instance.setOxygen(51));
        assertEquals(false, instance.setOxygen(100));
        //Second Scenario: values on the edge of range
        assertEquals(true, instance.setOxygen(SimpleCalculation.MIN_OXYGEN_VALUE));
        assertEquals(true, instance.setOxygen(SimpleCalculation.MAX_OXYGEN_VALUE));
        //Thrid Scenario: values within the range
        assertEquals(true, instance.setOxygen(23));
        assertEquals(true, instance.setOxygen(31));
        assertEquals(true, instance.setOxygen(40));
        assertEquals(true, instance.setOxygen(48));
    }

}
