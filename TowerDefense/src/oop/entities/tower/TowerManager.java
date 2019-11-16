/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.tower;

import oop.Handler;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TowerManager {

    private Handler handler;
    private Tower tower;
    private ArrayList<Tower> towers;

    public TowerManager(Handler handler, Tower tower) {
        this.handler = handler;
        this.tower = tower;
        this.towers = new ArrayList<>();

    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }
    
    public void render(Graphics g){
        for (Tower t : towers) {
          t.render(g);          
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
    }
    
}
