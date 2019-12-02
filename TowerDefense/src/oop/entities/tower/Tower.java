/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.tower;

import oop.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javafx.scene.shape.Circle;

/**
 *
 * @author ASUS
 */
public abstract class Tower {
    public static int TOWERWIDTH = 50, TOWERHEIGHT = 50;
    protected Handler handler;
    protected float x, y;
    public int price;
    protected Circle radius;
    protected int damege = 1;
    protected int effect = 0;
    public int timeEffect = 0;

    public Tower(Handler handler, float x, float y, int price, int damege, int effect) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.price = price;
        this.damege = damege;
        this.effect = effect;
        radius = new Circle(0, 0, 100);
    }      
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Circle getRadius() {
        return radius;
    }

    public void setRadius(Circle radius) {
        this.radius = radius;
    }
    
    public int NearestRangeX(){
        int rgMin = (int) (x - radius.getRadius()/2);
        return rgMin;
    }
    
    public int FurthestRangeX(){
        int rgMax = (int) (x - radius.getCenterX() + radius.getRadius());
        return rgMax;
    }
    
    public int NearestRangeY(){
        int rgMin = (int) (y - radius.getCenterY());
        return rgMin;
    }
    
    public int FurthestRangeY(){
        int rgMax = (int) (y - radius.getCenterY() + radius.getRadius());
        return rgMax;
    }

    public int getPrice() {
        return price;
    }

    public int getDamege() {
        return damege;
    }

    public int getEffect() {
        return effect;
    }
    
}
