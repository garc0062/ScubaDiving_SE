/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import model.Cylinder;

/**
 *
 * @author pablo
 * 
 * Panel on which the cylinder is drawn.
 */
public class CylinderPanel extends JPanel {
    Cylinder cylinder;

    public Cylinder getCylinder() {
        return cylinder;
    }

    public void setCylinder(Cylinder cylinder) {
        this.cylinder = cylinder;
    }   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cylinder.draw(g);
    }

}

