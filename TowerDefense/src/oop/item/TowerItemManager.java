/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.item;

import oop.Handler;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TowerItemManager {

    private Handler handler;
    private ArrayList<TowerItem> towerItems;

    public TowerItemManager(Handler handler) {
        this.handler = handler;
        towerItems = new ArrayList<TowerItem>();
    }

    public void render(Graphics g) {
        
    }

    public void addItem(TowerItem t) {
        t.setHandler(handler);
        towerItems.add(t);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
