/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.tower;

import oop.Handler;
import oop.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javafx.beans.property.DoubleProperty;

/**
 *
 * @author ASUS
 */
public class TowerBasic extends Tower {

    public TowerBasic(Handler handler, float x, float y) {
        super(handler, x, y, 10);
        
        radius.setCenterX(130);
        radius.setCenterY(120);
        radius.setRadius(300);
    }
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval((int) (x - radius.getCenterX()),(int) (y - radius.getCenterY()),(int) radius.getRadius(),(int) radius.getRadius());
        g.drawImage(Assets.towerBasic, (int) x, (int) y, TOWERWIDTH, TOWERHEIGHT, null);
    }

}
