/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
        formatter = new DecimalFormat("#0.0");
    }

    public String[][] getTableCalculation() {
        return tableCalculation;
    }

    public String[] getHeaders() {
        return headers;
    }

    public int getOxygenStart() {
        return oxygenStart;
    }

    public void setOxygenStart(int oxygenStart) {
        this.oxygenStart = oxygenStart;
    }

    public int getOxygenEnd() {
        return oxygenEnd;
    }

    public void setOxygenEnd(int oxygenEnd) {
        this.oxygenEnd = oxygenEnd;
    }

    public int getDepthStart() {
        return depthStart;
    }

    public void setDepthStart(int depthStart) {
        this.depthStart = depthStart;
    }

    public int getDepthEnd() {
        return depthEnd;
    }

    public void setDepthEnd(int depthEnd) {
        this.depthEnd = depthEnd;
    }

    public float getCalculation() {
        float calculation;
        switch (typeCalculation) {
            case EAD:
                calculation = simpleCalculation.eadCalculation();
                if (calculation > 0) {
                    return calculation;
                }
                return 0;
            case PPO2:
                calculation = simpleCalculation.ppo2Calculation();
                if (simpleCalculation.setPPO2(calculation)) {
                    return calculation;
                }
                break;
        }
        return -1;
    }

    public void calculateTable(TypeComplex type) {
        simpleCalculation = new SimpleCalculation();
        this.typeCalculation = type;
        tableCalculation = new String[getSizeRows()][getSizeColumns() + 1];
        headers = new String[getSizeColumns() + 1];
//        headersColumns = new String[getSizeRows()];
        headers[0] = "D/O";
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
                tableCalculation[(currentDepth - depthStart) / INCREASE_DEPTH][currentOxygen - tempxygenStart] = getCalculation() != -1f ? formatter.format(getCalculation()) : "-";
            }
        }
    }

    private int getSizeColumns() {
        return (oxygenEnd - oxygenStart) / INCREASE_OXYGEN + 1;
    }

    private int getSizeRows() {
        System.out.print((depthEnd - depthStart) / INCREASE_DEPTH);
        return (depthEnd - depthStart) / INCREASE_DEPTH + 1;
    }

}
