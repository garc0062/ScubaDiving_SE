/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pablo
 */
/**
 * Manages simple calculations for scuba diving project.
 */
public class SimpleCalculation {

    //Range for PPO2 values
    public static final float MIN_PPO2_VALUE = 1.1F;
    public static final float MAX_PPO2_VALUE = 1.6F;
    //Range for Oxygen values
    public static final int MIN_OXYGEN_VALUE = 22;
    public static final int MAX_OXYGEN_VALUE = 50;
    //Min value of depth
    public static final int MIN_DEPTH_VALUE = 0;

    int oxigen;
    float ppo2;
    float depth;

     /**
     * Get oxygen in percentage
     * @return oxygen in percentage
     */
    public int getOxigenInPercentage() {
        return oxigen;
    }

     /**
     * Get oxygen in decimal
     * @return oxygen in decimal
     */
    public float getOxigenInDecimal() {
        return (float)oxigen * 0.01F;
    }

    public float getPpo2() {
        return ppo2;
    }

    public float getDepth() {
        return depth;
    }
    
    /**
     * Converts and returns absolute pressure at depth from depth in meters
     * @return oxygen in decimal
     */
    public float getAbsolutePressure() {
        return (float)depth/10 + 1;
    }

    /**
     * Set value of PPO2 between valid values range (1.1 and 1.6)
     *
     * @param ppo2: partial pressure of oxygen to set.
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setPPO2(float ppo2) {
        if (ppo2 >= MIN_PPO2_VALUE && ppo2 <= MAX_PPO2_VALUE) {
            this.ppo2 = ppo2;
            return true;
        }
        return false;
    }

    /**
     * Set value of Oxygen between valid values range (MIN_OXYGEN_VALUE and
     * MAX_OXYGEN_VALUE)
     *
     * @param oxygen: percentage of oxygen in mixture to set.
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setOxygen(int oxygen) {
        if (oxygen >= MIN_OXYGEN_VALUE && oxygen <= MAX_OXYGEN_VALUE) {
            this.oxigen = oxygen;
            return true;
        }
        return false;
    }

    /**
     * Set value of Oxygen between valid values range (MIN_OXYGEN_VALUE and
     * MAX_OXYGEN_VALUE)
     *
     * @param depth: partial pressure of oxygen to set.
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setDepth(float depth) {
        if (depth >= 0) {
            this.depth = depth;
            return true;
        }
        return false;
    }
}
