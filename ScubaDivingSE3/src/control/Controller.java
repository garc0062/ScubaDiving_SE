/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.DecimalFormat;
import model.SimpleCalculation;
import view.ScubaDivingView;

/**
 *
 * @author pablo
 */
public class Controller {

    private final ScubaDivingView view;
    private final SimpleCalculation simpleCalculation;
    DecimalFormat formatter;

    /**
     * Creates a controller to orchestrate the interaction between the view
     * (view)object and the model objects.
     */
    public Controller() {
        this.view = new ScubaDivingView(this);
        this.simpleCalculation = new SimpleCalculation();
        this.formatter = new DecimalFormat("#0.0");
    }

    /**
     * Create the view model and makes it visible.
     */
    public void execute() {
        view.pack();
        view.setVisible(true);
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
     * @return Depth in meters
     */
    public float getDepth() {
        return simpleCalculation.getDepth();
    }
    /**
     * @return Oxygen value as a Percentage
     */
    public float getPPO2() {
        return simpleCalculation.getPPO2();
    }
    /**
     * @return Oxygen value as a Percentage
     */
    public int getOxygenInPercentage() {
        return simpleCalculation.getOxygenInPercentage();
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
     *
     * @return maximum operating depth in meters
     */
    public String modCalculation() {
        float resultMOD = simpleCalculation.modCalculation();
        String result;
        if (simpleCalculation.setDepth(resultMOD)) {
            result = "<html>The Maximum Operating Depth value for an  <br>"
                    + "oxygen value of " + simpleCalculation.getOxygenInPercentage() + "%<br>"
                    + "and a PPO2 of " + simpleCalculation.getPPO2() + " meters is: <br><br>"
                    + "<strong>" + formatter.format(resultMOD) + " meters</strong></html>";
            view.setViewValues();
        } else {
            result = "<html>WARNING: This value exceeds <br>"
                    + "the depth range of 0-100 metres</html>";
        }
        return result;
    }

    /**
     * Requests the result of the MOD calculation from simpleCalculation
     *
     * @return maximum depth in meters
     */
    public String ppo2Calculation() {
        float resultPPO2 = simpleCalculation.ppo2Calculation();
        String result;
        if (simpleCalculation.setPPO2(resultPPO2)) {
            result = "<html>The PPO2 value for an  <br>"
                    + "oxygen value of " + simpleCalculation.getOxygenInPercentage() + "%<br>"
                    + "and a depth of " + simpleCalculation.getDepth() + " metres is: <br><br>"
                    + "<strong>" + formatter.format(resultPPO2) + " ata</strong></html>";
            view.setViewValues();
        } else {
            result = "<html>WARNING: The PPO2 obtained exceeds <br>"
                    + "the recommended PPO2 range of 1.1-1.6 ata. <br>"
                    + "Please try different values</html>";
        }
        return result;
    }

    /**
     * @return Best Mix of Oxygen as a percentage.
     */
    public String bestMixCalculation() {
        float resultBM = simpleCalculation.bestMixCalculation();
        String result;
        if (simpleCalculation.setOxygen(resultBM)) {
            result = "<html>The best Mix value for an "
                    + "depth value of " + simpleCalculation.getDepth() + " meters<br>"
                    + "and a ppo2 of " + simpleCalculation.getPPO2() + " ata is: <br><br>"
                    + "<strong>" + resultBM + "%</strong></html>";
            view.setViewValues();
        } else {
            result = "<html>WARNING: Value outside of range. <br>"
                    + "The oxygen value sholud be between 22% and 50% <br>"
                    + "Please try different values";
        }
        return result;
    }

    /**
     * Requests the result of the EAD calculation from simpleCalculation
     *
     * @return Equivalent Air Depth (EAD) Value in meter
     */
    public String eadCalculation() {
        float resultEAD = simpleCalculation.eadCalculation();
        String result = "<html>The Equivalent Air Depth value for an  "
                + "oxygen value of " + simpleCalculation.getOxygenInPercentage() + "%<br>"
                + "and a depth of " + simpleCalculation.getDepth() + " meters is: <br><br>"
                + "<strong>";
        if (resultEAD > 0) {
            result += formatter.format(resultEAD) + " meters";
        } else {
            simpleCalculation.setDepth(resultEAD);
            result += "0.0 meters";
        }
        return result;
    }

    /**
     * @return standard maximum depth in meters from model to view
     */
    public String smodCalculation() {
        float resultSMOD = simpleCalculation.smodCalculation();
        String result;
        if (simpleCalculation.setDepth(resultSMOD)) {
            result = "<html>The SMOD value for an  <br>"
                    + "oxygen value of " + simpleCalculation.getOxygenInPercentage() + "%<br>"
                    + "and a PPO2 of " + simpleCalculation.getPPO2() + " ata is: <br><br>"
                    + "<strong>" + formatter.format(resultSMOD) + " meters</strong></html>";
            view.setViewValues();
        } else {
            result = "<html>WARNING: This value exceeds <br>"
                    + "the depth range of 0-100 metres</html>";
        }
        return result;
    }
}
