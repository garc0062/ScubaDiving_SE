/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 *
 * Class to create a panel with a help icon. Rxtrnds JPanel.
 *
 * Icon reproduced from https://www.iconfinder.com/search/?q=help
 */
public class HelpPanel extends JPanel {

    private BufferedImage image;

    /**
     * Constructor of the HelpPanel
     */
    public HelpPanel() {
        super();
        setToolTipText("Click on the icon for help.");
        try {
            image = ImageIO.read(this.getClass().getResource("/docs/help_icon.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Load an image in the Panel Object, the image takes the whole size of the
     * panel.
     *
     * @param g graph component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
