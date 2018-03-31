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

    /**
     * Test of setDepth method, of class SimpleCalculation.
     */
    @Test
    public void testSetDepth() {
        System.out.println("setDepth");
        SimpleCalculation instance = new SimpleCalculation();
        //Less than min
        assertEquals(false, instance.setDepth(-1));
        assertEquals(false, instance.setDepth(-5));
        assertEquals(false, instance.setDepth(-155));
        //More than or equal to zero
        assertEquals(true, instance.setDepth(SimpleCalculation.MIN_DEPTH_VALUE));
        assertEquals(true, instance.setDepth(10));
        assertEquals(true, instance.setDepth(70));
    }

    /**
     * Test of getOxigenInPercentage method, of class SimpleCalculation.
     */
    @Test
    public void testGetOxigenInPercentage() {
        System.out.println("getOxigenInPercentage");
        SimpleCalculation instance = new SimpleCalculation();
        //Set value and get value in parcentage should be equal
        instance.setOxygen(23);
        assertEquals(23, instance.getOxygenInPercentage());
        instance.setOxygen(40);
        assertEquals(40, instance.getOxygenInPercentage());
        instance.setOxygen(50);
        assertEquals(50, instance.getOxygenInPercentage());
    }

    /**
     * Test of getOxigenInDecimal method, of class SimpleCalculation.
     */
    @Test
    public void testGetOxigenInDecimal() {
        System.out.println("getOxigenInDecimal");
        SimpleCalculation instance = new SimpleCalculation();
        //Get value in decimal should be the decimal of the percentage
        instance.setOxygen(23);
        assertEquals(0.23F, instance.getOxygenInDecimal(), 2);
        instance.setOxygen(40);
        assertEquals(0.40F, instance.getOxygenInDecimal(), 2);
        instance.setOxygen(50);
        assertEquals(0.50F, instance.getOxygenInDecimal(), 2);
    }

    /**
     * Test of getPpo2 method, of class SimpleCalculation.
     */
    @Test
    public void testGetPpo2() {
        System.out.println("getPpo2");
        SimpleCalculation instance = new SimpleCalculation();
        //Set value and get value in parcentage should be equal
        instance.setPPO2(1.1F);
        assertEquals(1.1F, instance.getPPO2(), 1);
        instance.setPPO2(1.3F);
        assertEquals(1.3F, instance.getPPO2(), 1);
    }

    /**
     * Test of getDepth method, of class SimpleCalculation.
     */
    @Test
    public void testGetDepth() {
        System.out.println("getDepth");
        SimpleCalculation instance = new SimpleCalculation();
        //Set value and get value in parcentage should be equal
        instance.setDepth(10);
        assertEquals(10, instance.getDepth(), 2);
        instance.setDepth(30);
        assertEquals(30, instance.getDepth(), 2);
    }

    /**
     * Test of getAbsolutePressure method, of class SimpleCalculation.
     */
    @Test
    public void testGetAbsolutePressure() {
        System.out.println("getAbsolutePressure");
        SimpleCalculation instance = new SimpleCalculation();
        //Get value should be equal to applying formula
        instance.setDepth(28.8F);
        assertEquals(3.88F, instance.getAbsolutePressure(), 2);
        instance.setDepth(30);
        assertEquals(4F, instance.getAbsolutePressure(), 2);
        instance.setDepth(24);
        assertEquals(3.44F, instance.getAbsolutePressure(), 2);
    }

}
