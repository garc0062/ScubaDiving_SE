/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.SimpleCalculation;
import view.ScubaDivingView;

/**
 *
 * @author pablo
 */
public class Controller {

    private final ScubaDivingView frame;
    private final SimpleCalculation simpleCalculation;

    /**
     * Creates a controller to orchestrate the interaction between the view
     * (frame)object and the model objects.
     */
    public Controller() {
        this.frame = new ScubaDivingView(this);
        this.simpleCalculation = new SimpleCalculation();
    }

    /**
     * Create the view model and makes it visible.
     */
    public void execute() {
        frame.pack();
        frame.setVisible(true);
    }
    
        /**
     * Performs the setPPO2 method in simpleCalculation
     *
     * @param ppo2: Partial Pressure of the gas expressed in ata
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setPPO2(float ppo2) {
        return simpleCalculation.setPPO2(ppo2);
    }

    /**
     * Performs the setOxygen method in simpleCalculation
     *
     * @param oxygen: percentage of oxygen in mixture to set.
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setOxygen(int oxygen) {
        return simpleCalculation.setOxygen(oxygen);
    }

    /**
     * Performs the setDepth method in simpleCalculation
     *
     * @param depth: absolute pressure at depth measured in meters
     * @return true if value was properly set (within range). False otherwise.
     */
    public boolean setDepth(float depth) {
        return simpleCalculation.setDepth(depth);
    }
    
    /**
     * Requests the result of the MOD calculation from simpleCalculation
     * @return maximum depth in meters
     */
    public float modCalculation() {
        return simpleCalculation.modCalculation();
    }
    
    /**
     * Requests the result of the MOD calculation from simpleCalculation
     * @return maximum depth in meters
     */
    public float ppo2Calculation() {
        return simpleCalculation.ppo2Calculation();
    }
    
    public boolean ppo2CalculationInRange() {
        if (simpleCalculation.validPPO2(this.ppo2Calculation())) {
            return true;
        }
        return false;
    }
    
    public boolean modCalculationInRange() {
        if (simpleCalculation.validDepth(this.modCalculation())) {
            return true;
        }
        return false;
    }
    
    /**
     * @return Oxygen value as a Percentage
     */
    public int getOxygenInPercentage() {
        return simpleCalculation.getOxygenInPercentage();
    }
    
    /**
     * @return Oxygen value as a Percentage
     */
    public float getPPO2() {
        return simpleCalculation.getPPO2();
    }
    
    /**
     * @return Depth in meters
     */
    public float getDepth() {
        return simpleCalculation.getDepth();
    }
    
    /**
     * Rounds the current PPO2 value to the nearest single decimal place
     */
    public void roundPPO2() {
        float ppo2Value = simpleCalculation.getPPO2() * 10;
        ppo2Value = Math.round(ppo2Value) / (float)10.0;
        simpleCalculation.setPPO2(ppo2Value);
    }
    
     /**
     * @return standard maximum depth in meters from model to view
     */
    public float smodCalculation() {
        return simpleCalculation.smodCalculation();
    }
    
}
