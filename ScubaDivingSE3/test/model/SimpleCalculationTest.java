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
        assertEquals(0.23F, instance.getOxygenInDecimal(), 0.1);
        instance.setOxygen(40);
        assertEquals(0.40F, instance.getOxygenInDecimal(), 0.1);
        instance.setOxygen(50);
        assertEquals(0.50F, instance.getOxygenInDecimal(), 0.1);
    }

    /**
     * Test of getPpo2 method, of class SimpleCalculation.
     */
    @Test
    public void testGetPPO2() {
        System.out.println("getPPO2");
        SimpleCalculation instance = new SimpleCalculation();
        //Set value and get value in parcentage should be equal
        instance.setPPO2(1.1F);
        assertEquals(1.1F, instance.getPPO2(), 0.1);
        instance.setPPO2(1.3F);
        assertEquals(1.3F, instance.getPPO2(), 0.1);
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
        assertEquals(10, instance.getDepth(), 0.1);
        instance.setDepth(30);
        assertEquals(30, instance.getDepth(), 0.1);
    }

    /**
     * Test of modCalculation method, of class SimpleCalculation.
     */
    @Test
    public void testmodCalculation() {
        System.out.println("modCalculation");
        SimpleCalculation instance = new SimpleCalculation();
        instance.setOxygen(36);
        instance.setPPO2(1.4F);
        assertEquals(28.88F, instance.modCalculation(), 0.01);
        instance.setOxygen(41);
        instance.setPPO2(1.2F);
        assertEquals(19.26F, instance.modCalculation(), 0.01);
        instance.setOxygen(47);
        instance.setPPO2(1.5F);
        assertEquals(21.91F, instance.modCalculation(), 0.01);
    }
    
    /**
     * Test of ppo2Calculation method, of class SimpleCalculation.
     */
    @Test
    public void testPPO2Calculation() {
        System.out.println("PPO2Calculation");
        SimpleCalculation instance = new SimpleCalculation();
        instance.setOxygen(32);
        instance.setDepth(30F);
        assertEquals(1.28F, instance.ppo2Calculation(), 0.01);
        instance.setOxygen(40);
        instance.setDepth(40F);
        assertEquals(2F, instance.ppo2Calculation(), 0.01);
        instance.setOxygen(28);
        instance.setDepth(50F);
        assertEquals(1.68F, instance.ppo2Calculation(), 0.01);
    }
    
    /**
     * Test of getAtaAsMeters method, of class SimpleCalculation.
     */
    @Test
    public void testGetAtaAsMeters() {
        System.out.println("getAtaAsMeters");
        SimpleCalculation instance = new SimpleCalculation();
        assertEquals(28.8F, instance.getAtaAsMeters(3.88F), 0.01);
        assertEquals(30F, instance.getAtaAsMeters(4F), 0.01);
        assertEquals(41F, instance.getAtaAsMeters(5.1F), 0.01);
    }
    
    /**
     * Test of validPPO2 method, of class SimpleCalculation.
     */
    @Test
    public void testValidPPO2() {
        System.out.println("validPPO2");
        SimpleCalculation instance = new SimpleCalculation();
        assertTrue(instance.validPPO2(1.4F));
        assertFalse(instance.validPPO2(0.4F));
        assertFalse(instance.validPPO2(3.6F));
    }
    
    /**
     * Test of validPPO2 method, of class SimpleCalculation.
     */
    @Test
    public void testValidDepth() {
        System.out.println("validDepth");
        SimpleCalculation instance = new SimpleCalculation();
        assertTrue(instance.validDepth(30F));
        assertTrue(instance.validDepth(0F));
        assertFalse(instance.validDepth(-30F));
    }
    
    /**
     * Test of validPPO2 method, of class SimpleCalculation.
     */
    @Test
    public void testValidOxygen() {
        System.out.println("validOxygen");
        SimpleCalculation instance = new SimpleCalculation();
        assertTrue(instance.validOxygen(27));
        assertFalse(instance.validOxygen(12));
        assertFalse(instance.validOxygen(90));
        assertFalse(instance.validOxygen(-27));
    }
    
    /**
     * Test of SMOD method, of class SimpleCalculation.
     */
    @Test
    public void testSmodCalculation() {
        System.out.println("validOxygen");
        SimpleCalculation instance = new SimpleCalculation();
        instance.setOxygen(24);
        assertEquals(48.30F, instance.smodCalculation(), 0.1);
        instance.setOxygen(30);
        assertEquals(36.7F, instance.smodCalculation(), 0.1);
        instance.setOxygen(36);
        assertEquals(28.9F, instance.smodCalculation(), 0.1);
        instance.setOxygen(50);
        assertEquals(18.0F, instance.smodCalculation(), 0.1);
    }
}
