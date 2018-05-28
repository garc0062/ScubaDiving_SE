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
 * Class representing the oxygen - nitrogen cylinder that represents the
 * mixture.
 */
public class Cylinder {

    //Scale fot the cylinder drawing
    public static int SCALE = 4;
    //max length of cylinder that should equal 100%
    public static int MAX_WIDTH = 100;

    int widthOxygen, widthNitrogen, height, curveLevel, x, y;

    public Cylinder(int oxygenPercentage) {
        this.widthOxygen = oxygenPercentage;
        this.widthNitrogen = MAX_WIDTH - widthOxygen;
        this.height = 50;
        curveLevel = 10;
        x = 200;
        y = 70;
    }

    public int getWidthOxygen() {
        return widthOxygen;
    }

    public void setWidthCylinder(int widthOxygen) {
        this.widthOxygen = widthOxygen;
        this.widthNitrogen = MAX_WIDTH - widthOxygen;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath oxygen = new GeneralPath();
        oxygen.moveTo(x, y);
        oxygen.curveTo(x, y, x - curveLevel * SCALE, y + (height / 2) * SCALE, x, y + height * SCALE);
        oxygen.lineTo(x + widthOxygen * SCALE, y + height * SCALE);
        oxygen.lineTo(x + widthOxygen * SCALE, y);
        oxygen.closePath();
        g2d.setColor(new Color(0, 0, 180));
        g2d.fill(oxygen);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Calibri", Font.PLAIN, 20));
        g2d.drawString("Oxygen " + widthOxygen + "%", x, y - 20);

        GeneralPath nitrogen = new GeneralPath();
        nitrogen.moveTo(x + widthOxygen * SCALE, y);
        nitrogen.lineTo(x + MAX_WIDTH * SCALE, y);
        nitrogen.curveTo(x + MAX_WIDTH * SCALE, y, x + (MAX_WIDTH + curveLevel) * SCALE, (height / 2) * SCALE + y, x + MAX_WIDTH * SCALE, y + height * SCALE);
        nitrogen.lineTo(x + widthOxygen * SCALE, y + height * SCALE);
        nitrogen.closePath();
        g2d.setColor(new Color(180, 0, 0));
        g2d.fill(nitrogen);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Calibri", Font.PLAIN, 20));
        g2d.drawString("Nitrogen " + widthNitrogen + "%", x + 72 * SCALE, y - 20);
    }
}
