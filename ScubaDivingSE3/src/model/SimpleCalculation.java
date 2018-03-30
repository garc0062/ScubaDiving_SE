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

    int oxigen;
    float ppo2;
    int depth;

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
     * Set value of Oxygen between valid values range (MIN_OXYGEN_VALUE and MAX_OXYGEN_VALUE)
     *
     * @param oxygen: partial pressure of oxygen to set.
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setOxygen(int oxygen) {
        if (oxygen >= MIN_OXYGEN_VALUE && oxygen <= MAX_OXYGEN_VALUE) {
            this.oxigen = oxygen;
            return true;
        }
        return false;
    }
}
