/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;

/**
 *
 * @author pablo
 */
public class ComplexCalculation {

    //increasing value of depth
    public static final int INCREASE_DEPTH = 3;
    //increasing value of oxygen
    public static final int INCREASE_OXYGEN = 1;

    public static final int MIN_OXYGEN_VALUE = 18;
    //Min value of depth
    public static final int MIN_DEPTH_VALUE = 3;

    /**
     * Declares types of calculations
     */
    public enum TypeComplex {

        EAD(0),
        PPO2(1);

        int code;

        private TypeComplex(int code) {
            this.code = code;
        }
    }

    int oxygenStart;
    int oxygenEnd;
    int depthStart;
    int depthEnd;
    String[][] tableCalculation;
    String[] headers;
    String[] headersColumns;
    TypeComplex typeCalculation;
    private SimpleCalculation simpleCalculation;
    DecimalFormat formatter;

    public ComplexCalculation() {
        oxygenStart = MIN_OXYGEN_VALUE;
        oxygenEnd = MIN_OXYGEN_VALUE;
        depthStart = MIN_DEPTH_VALUE;
        depthEnd = MIN_DEPTH_VALUE;
        formatter = new DecimalFormat("#0.00");
        simpleCalculation = new SimpleCalculation();
    }

    /**
     * Gets table of complex calculations.
     *
     * @return table.
     */
    public String[][] getTableCalculation() {
        return tableCalculation;
    }

    /**
     * Gets header of table
     *
     * @return headers.
     */
    public String[] getHeaders() {
        return headers;
    }

    /**
     * Gets instance of SimpleCalculation class.
     *
     * @return simpleCalculation..
     */
    public SimpleCalculation getSimpleCalculation() {
        return simpleCalculation;
    }

    /**
     * Gets start of oxygen range
     *
     * @return start of oxygen range.
     */
    public int getOxygenStart() {
        return oxygenStart;
    }

    /**
     * Sets start of oxygen range
     *
     * @param oxygenStart: start of oxygen range.
     */
    public void setOxygenStart(int oxygenStart) {
        this.oxygenStart = oxygenStart;
    }

    /**
     * Gets end of oxygen range
     *
     * @return end of oxygen range.
     */
    public int getOxygenEnd() {
        return oxygenEnd;
    }

    /**
     * Sets type of complex calculation
     *
     * @param typeCalculation : type of calculation
     */
    public void setTypeCalculation(TypeComplex typeCalculation) {
        this.typeCalculation = typeCalculation;
    }

    /**
     * Sets end of oxygen range
     *
     * @param oxygenEnd : start of oxygen range.
     */
    public void setOxygenEnd(int oxygenEnd) {
        this.oxygenEnd = oxygenEnd;
    }

    /**
     * Gets start of depth range
     *
     * @return start of depth range.
     */
    public int getDepthStart() {
        return depthStart;
    }

    /**
     * Sets end of depth range
     *
     * @param depthStart : start of depth range.
     */
    public void setDepthStart(int depthStart) {
        this.depthStart = depthStart;
    }

    /**
     * Gets end of depth range
     *
     * @return end of depth range.
     */
    public int getDepthEnd() {
        return depthEnd;
    }

    /**
     * Sets end of depth range
     *
     * @param depthEnd: end of depth range.
     */
    public void setDepthEnd(int depthEnd) {
        this.depthEnd = depthEnd;
    }

    /**
     * calculates and returns a type of calculation.
     *
     * @return calculation: either EAD or PPO2. -1 If invalid value is gotten.
     */
    public float getCalculation() {
        float calculation;
        switch (typeCalculation) {
            case EAD:
                calculation = simpleCalculation.eadCalculation();
                if (calculation > 0) {
                    return calculation;
                }
                break;
            case PPO2:
                calculation = simpleCalculation.ppo2Calculation();
                if (calculation < SimpleCalculation.MAX_PPO2_VALUE) {
                    return calculation;
                }
                break;
        }
        return -1;
    }

    /**
     * populates table with values of calculation type (EAD/PPO2) between range
     * of oxygen and depth.
     *
     * @param type: type of complex calculation. It can be either EAD or PPO2
     */
    public void calculateTable(TypeComplex type) {
        simpleCalculation = new SimpleCalculation();
        this.typeCalculation = type;
        tableCalculation = new String[getSizeRows()][getSizeColumns()];
        headers = new String[getSizeColumns()];
//        headersColumns = new String[getSizeRows()];
        headers[0] = "D\\O";
        int tempxygenStart = oxygenStart - 1;
        for (int currentOxygen = tempxygenStart; currentOxygen <= oxygenEnd; currentOxygen = currentOxygen + INCREASE_OXYGEN) {
            if (currentOxygen != tempxygenStart) {
                headers[currentOxygen - tempxygenStart] = String.valueOf(currentOxygen);
            }
            for (int currentDepth = depthStart; currentDepth <= depthEnd; currentDepth = currentDepth + INCREASE_DEPTH) {
                if (currentOxygen == tempxygenStart) {
                    tableCalculation[(currentDepth - depthStart) / INCREASE_DEPTH][currentOxygen - tempxygenStart] = String.valueOf(currentDepth);
                    continue;
                }
                simpleCalculation.depth = currentDepth;
                simpleCalculation.oxygen = currentOxygen;
                tableCalculation[(currentDepth - depthStart) / INCREASE_DEPTH][currentOxygen - tempxygenStart] = getCalculation() != -1f ? formatter.format(getCalculation()) : "";
            }
        }
    }

    /**
     * calculates number of columns according to oxygen range
     *
     * @return number of columns
     */
    public int getSizeColumns() {
        return (oxygenEnd - oxygenStart) / INCREASE_OXYGEN + 2;
    }

    /**
     * calculates number of columns according to oxygen range
     *
     * @return number of columns
     */
    public int getSizeRows() {        
        return (depthEnd - depthStart) / INCREASE_DEPTH + 1;
    }
}
