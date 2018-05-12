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
public class ComplexCalculationTest {

    public ComplexCalculationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getSizeColumns method, of class ComplexCalculation.
     */
    @Test
    public void getSizeColumnsTest() {
        ComplexCalculation instance = new ComplexCalculation();
        instance.setOxygenStart(39);
        instance.setOxygenEnd(41);
        instance.setDepthStart(3);
        instance.setDepthEnd(9);
        assertEquals(3, instance.getSizeRows());
    }

    /**
     * Test of getSizeRows method, of class ComplexCalculation.
     */
    @Test
    public void getSizeRowsTest() {
        ComplexCalculation instance = new ComplexCalculation();
        instance.setOxygenStart(39);
        instance.setOxygenEnd(41);
        instance.setDepthStart(3);
        instance.setDepthEnd(9);
        assertEquals(4, instance.getSizeColumns());
    }

    /**
     * Test of getCalculation method, of class ComplexCalculation.
     */
    @Test
    public void testGetCalculation() {
        System.out.println("getCalculation");
        ComplexCalculation instance = new ComplexCalculation();

        //if type is EAD
        instance.setTypeCalculation(ComplexCalculation.TypeComplex.EAD);
        //first case: valid value
        instance.getSimpleCalculation().setDepth(4);
        instance.getSimpleCalculation().setOxygen(25);
        assertEquals(3.29F, instance.getCalculation(), 0.01);
        //second case: wrong value
        instance.getSimpleCalculation().setDepth(3);
        instance.getSimpleCalculation().setOxygen(40);
        assertEquals(-1.0F, instance.getCalculation(), 0.01);

        //if type is PPO2
        instance.setTypeCalculation(ComplexCalculation.TypeComplex.PPO2);
        //first case: valid value
        instance.getSimpleCalculation().setDepth(30F);
        instance.getSimpleCalculation().setOxygen(32);
        assertEquals(1.28F, instance.getCalculation(), 0.01);
        //second case: wrong value
        instance.getSimpleCalculation().setDepth(50F);
        instance.getSimpleCalculation().setOxygen(28);
        assertEquals(-1.0F, instance.getCalculation(), 0.01);
    }

    /**
     * Test of calculateTable method, of class ComplexCalculation.
     */
    @Test
    public void testCalculateTable() {
        System.out.println("calculateTable");
        ComplexCalculation instance = new ComplexCalculation();

        //creating EAD table  
        String[][] tableExampleEAD = {
            {"3", "0.04", "", ""},
            {"6", "2.35", "2.15", "1.95"},
            {"9", "4.67", "4.43", "4.19"}
        };
        String[] headerExampleEAD = {"D\\O", "39", "40", "41"};
        instance.setOxygenStart(39);
        instance.setOxygenEnd(41);
        instance.setDepthStart(3);
        instance.setDepthEnd(9);
        instance.calculateTable(ComplexCalculation.TypeComplex.EAD);
        String[][] resultEADTable = instance.getTableCalculation();
        for (int i = 0; i < resultEADTable.length; i++) {
            assertArrayEquals(tableExampleEAD[i], resultEADTable[i]);
        }
        assertArrayEquals(headerExampleEAD, instance.getHeaders());

        //creating PPO2 table  
        String[][] tableExamplePPO2 = {
            {"25", "1.37", "1.40", "1.43"},
            {"28", "1.48", "1.52", "1.56"},
            {"31", "1.60", "", ""},
            {"34", "", "", ""}
        };
        String[] headerExamplePPO2 = {"D\\O", "39", "40", "41"};
        instance.setOxygenStart(39);
        instance.setOxygenEnd(41);
        instance.setDepthStart(25);
        instance.setDepthEnd(34);
        instance.calculateTable(ComplexCalculation.TypeComplex.PPO2);
        String[][] resultPPO2Table = instance.getTableCalculation();
        for (int i = 0; i < resultPPO2Table.length; i++) {
            assertArrayEquals(tableExamplePPO2[i], resultPPO2Table[i]);
        }
        assertArrayEquals(headerExamplePPO2, instance.getHeaders());
    }
}
