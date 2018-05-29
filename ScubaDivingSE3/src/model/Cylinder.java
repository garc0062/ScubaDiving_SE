/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author pablo
 *
 * Class representing the oxygen - nitrogen cylinder that draws the mixture in
 * the cylinder.
 */
public class Cylinder {

    //Scale for drawing the cylinder.
    public static int SCALE = 4;
    //max length of cylinder, which must equal 100%
    public static int MAX_WIDTH = 100;

    int widthOxygen, widthNitrogen, height, curveLevel, x, y;

    /**
     * Sets the position of the cylinder. Additionally it sets the percentages
     * of the mixture.
     *
     * @param oxygenPercentage
     */
    public Cylinder(int oxygenPercentage) {
        this.widthOxygen = oxygenPercentage;
        this.widthNitrogen = MAX_WIDTH - widthOxygen;
        this.height = 50;
        curveLevel = 10;
        x = 200;
        y = 70;
    }

    /**
     *
     * @return width of oxygen in percentage.
     */
    public int getWidthOxygen() {
        return widthOxygen;
    }

    /**
     *
     * @param widthOxygen percentage of oxygen.
     */
    public void setWidthCylinder(int widthOxygen) {
        this.widthOxygen = widthOxygen;
        this.widthNitrogen = MAX_WIDTH - widthOxygen;
    }

    /**
     * Draw cylinder in container.
     *
     * @param g Graphics
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath oxygen = new GeneralPath();
        //Draw the half cylinder of oxygen
        oxygen.moveTo(getXUpperLeftOxygen(), getYUpperLeftOxygen());
        oxygen.curveTo(getXUpperLeftOxygen(), getYUpperLeftOxygen(), getXOxygenCurve(), getYOxygenCurve(), getXLowerLeftOxygen(), getYLowerLeftOxygen());
        oxygen.lineTo(getXLowerRightOxygen(), getYLowerRightOxygen());
        oxygen.lineTo(getXUpperRightOxygen(), getYUpperRightOxygen());
        oxygen.closePath();
        g2d.setColor(new Color(0, 0, 180));
        g2d.fill(oxygen);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Calibri", Font.PLAIN, 20));
        g2d.drawString("Oxygen " + widthOxygen + "%", x, y - 20);

        GeneralPath nitrogen = new GeneralPath();
        //Draw the half cylinder of nitrogen
        nitrogen.moveTo(getXUpperLeftNitrogen(), getYUpperLeftNitrogen());
        nitrogen.lineTo(getXUpperRightNitrogen(), getYUpperRightNitrogen());
        nitrogen.curveTo(getXUpperRightNitrogen(), getYUpperRightNitrogen(), getXNitrogenCurve(), getYNitrogenCurve(), getXLowerRightNitrogen(), getYLowerRightNitrogen());
        nitrogen.lineTo(getXLowerLeftNitrogen(), getYLowerLeftNitrogen());
        nitrogen.closePath();
        g2d.setColor(new Color(180, 0, 0));
        g2d.fill(nitrogen);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Calibri", Font.PLAIN, 20));
        g2d.drawString("Nitrogen " + widthNitrogen + "%", x + 72 * SCALE, y - 20);
    }

    public double getXUpperLeftOxygen() {
        return x;
    }

    public double getYUpperLeftOxygen() {
        return y;
    }

    public double getXOxygenCurve() {
        return x - curveLevel * SCALE;
    }

    public double getYOxygenCurve() {
        return y + (height / 2) * SCALE;
    }

    public double getXLowerLeftOxygen() {
        return x;
    }

    public double getYLowerLeftOxygen() {
        return y + height * SCALE;
    }

    public double getXLowerRightOxygen() {
        return x + widthOxygen * SCALE;
    }

    public double getYLowerRightOxygen() {
        return y + height * SCALE;
    }

    public double getXUpperRightOxygen() {
        return x + widthOxygen * SCALE;
    }

    public double getYUpperRightOxygen() {
        return y;
    }

    public double getXUpperLeftNitrogen() {
        return x + widthOxygen * SCALE;
    }

    public double getYUpperLeftNitrogen() {
        return y;
    }

    public double getXNitrogenCurve() {
        return x + (MAX_WIDTH + curveLevel) * SCALE;
    }

    public double getYNitrogenCurve() {
        return (height / 2) * SCALE + y;
    }

    public double getXLowerLeftNitrogen() {
        return x + widthOxygen * SCALE;
    }

    public double getYLowerLeftNitrogen() {
        return y + height * SCALE;
    }

    public double getXLowerRightNitrogen() {
        return x + MAX_WIDTH * SCALE;
    }

    public double getYLowerRightNitrogen() {
        return y + height * SCALE;
    }

    public double getXUpperRightNitrogen() {
        return x + MAX_WIDTH * SCALE;
    }

    public double getYUpperRightNitrogen() {
        return y;
    }
}
