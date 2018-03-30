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
        if (ppo2 >= 1.1F && ppo2 <= 1.6F) {
            this.ppo2 = ppo2;
            return true;
        }
        return false;
    }
}
