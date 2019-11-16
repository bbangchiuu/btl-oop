/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.bullets;

import java.awt.Graphics;
import java.util.ArrayList;
import oop.Handler;

/**
 *
 * @author ASUS
 */
public class BulletManager {
    private Handler handler;
    private ArrayList<Bullet> bullets;
    
    public BulletManager(Handler handler){
        this.handler = handler;
        bullets = new ArrayList<>();
    }
    
    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }
    
    public void tick(){
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).tick();
        }
    }
    
    public void render(Graphics g){
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).render(g);
        }
    }
}
