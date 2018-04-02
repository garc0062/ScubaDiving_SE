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

    int oxygen = 22;
    float ppo2 = (float)1.1;
    float depth;
    
    public SimpleCalculation() {
    }

     /**
     * Get oxygen in percentage
     * 
     * @return oxygen in percentage
     */
    public int getOxygenInPercentage() {
        return oxygen;
    }

     /**
     * Get oxygen in decimal
     * 
     * @return oxygen in decimal
     */
    public float getOxygenInDecimal() {
        return (float)oxygen * 0.01F;
    }

    public float getPPO2() {
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
     * Converts an ata value to meters
     *
     * @param ata: depth value as ata to use during conversion.
     * @return converted depth in meters.
     */
    public float getAtaAsMeters(float ata) {
        return(ata-1)*10;
    }

    /**
     * Set value of PPO2 between valid values range (1.1 and 1.6)
     *
     * @param ppo2: Partial Pressure of the gas expressed in ata
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setPPO2(float ppo2) {
        if (validPPO2(ppo2)) {
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
        if (validOxygen(oxygen)) {
            this.oxygen = oxygen;
            return true;
        }
        return false;
    }

    /**
     * Set value of Oxygen between valid values range (MIN_OXYGEN_VALUE and
     * MAX_OXYGEN_VALUE)
     *
     * @param depth: absolute pressure at depth measured in meters
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setDepth(float depth) {
        if (depth >= 0) {
            this.depth = depth;
            return true;
        }
        return false;
    }

    /**
     * Checks a given oxygen value to see if it is above the minimum requirement
     *
     * @return true if value is within range. False otherwise.
     */
    public boolean validOxygen(float oxygen){
        if (oxygen >= MIN_OXYGEN_VALUE && oxygen <= MAX_OXYGEN_VALUE) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks a given PPO2 value to see if it is above the minimum requirement
     * 
     * @param ppo2: partial pressure of oxygen to check.
     * @return true if value is within range. False otherwise.
     */
    public boolean validPPO2(float ppo2){
        if (ppo2 >= MIN_PPO2_VALUE && ppo2 <= MAX_PPO2_VALUE) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks a given depth value to see if it is above the minimum requirement
     * 
     * @param depth: depth value in meters to check.
     * @return true if value is within range. False otherwise.
     */
    public boolean validDepth(float depth){
        if (depth >= MIN_DEPTH_VALUE) {
            return true;
        }
        return false;
    }
    
    /**
     * Calculates Maximum Operating Depth in meters from current
     * oxygen value (as a decimal) and current PPO2 value
     *
     * @return maximum depth in meters
     */
    public float modCalculation() {
        float maxDepth = ppo2 / this.getOxygenInDecimal();
        return this.getAtaAsMeters(maxDepth);
    }
    
    /**
     * Calculates Maximum Operating Depth in meters from current
     * oxygen value (as a decimal) and current PPO2 value
     *
     * @return maximum depth in meters
     */
    public float ppo2Calculation() {
        float newPPO2 = this.getOxygenInDecimal() * this.getAbsolutePressure();
        System.out.println(newPPO2);
        return newPPO2;
    }
}
