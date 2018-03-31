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
    private SimpleCalculation simpleCalculation;

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

}
