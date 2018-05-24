/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ComplexCalculation;
import model.SimpleCalculation;
import javax.swing.table.DefaultTableCellRenderer;
import view.DefaultTableHeaderCellRenderer;
import view.ScubaDivingView;

/**
 *
 * @author pablo
 */
public class Controller {

    private final ScubaDivingView view;
    private final SimpleCalculation simpleCalculation;
    private final ComplexCalculation complexCalculation;
    DecimalFormat formatter;

    /**
     * Creates a controller to orchestrate the interaction between the view
     * (view)object and the model objects.
     */
    public Controller() {
        this.view = new ScubaDivingView(this);
        this.simpleCalculation = new SimpleCalculation();
        this.complexCalculation = new ComplexCalculation();
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

    public void setOxygenStart(int oxygenStart) {
        complexCalculation.setOxygenStart(oxygenStart);
        if (complexCalculation.getOxygenEnd() < complexCalculation.getOxygenStart()) {
            complexCalculation.setOxygenEnd(oxygenStart);
        }
    }

    public void setOxygenEnd(int oxygenEnd) {
        complexCalculation.setOxygenEnd(oxygenEnd);
        if (complexCalculation.getOxygenEnd() < complexCalculation.getOxygenStart()) {
            complexCalculation.setOxygenStart(oxygenEnd);
        }
    }

    public void setDepthStart(int depthStart) {
        complexCalculation.setDepthStart(depthStart);
        if (complexCalculation.getDepthEnd() < complexCalculation.getDepthStart()) {
            complexCalculation.setDepthEnd(depthStart);
        }
    }

    public void setDepthEnd(int depthEnd) {
        complexCalculation.setDepthEnd(depthEnd);
        if (complexCalculation.getDepthEnd() < complexCalculation.getDepthStart()) {
            complexCalculation.setDepthStart(depthEnd);
        }
    }

    public ComplexCalculation getComplexCalculation() {
        return complexCalculation;
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

    /**
     * Populates table with EAD values.
     */
    public void generateEADTable() {
        generateTableByType(ComplexCalculation.TypeComplex.EAD);
    }

    /**
     * Populates table with PPO2 values.
     */
    public void generatePPO2Table() {
        generateTableByType(ComplexCalculation.TypeComplex.PPO2);
    }

    /**
     * Populates table with complex calculations depending on type.
     *
     * @param type: type of complex calculation, namely either EAD or PPO2.
     */
    public void generateTableByType(ComplexCalculation.TypeComplex type) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableComplexCalculations().getModel();
        JTable table = view.getTableComplexCalculations();
        complexCalculation.calculateTable(type);
        tableModel.setDataVector(complexCalculation.getTableCalculation(), complexCalculation.getHeaders());
        TableColumn column = null;

        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(40);
            column.setMinWidth(40);
            column.setPreferredWidth(40);
            if (i == 0) {
                column.setCellRenderer(new DefaultTableHeaderCellRenderer());
            }
        }
        
        //table.getTableHeader().getre
        if (table.getPreferredSize().width < table.getParent().getWidth()) {
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else {
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        view.getResultComplexCalculation().setBorder(BorderFactory.createTitledBorder("Table for " + type.name() + " calculations"));
    }
}
