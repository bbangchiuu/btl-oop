/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.monster;

import oop.Handler;
import java.awt.Graphics;
import oop.roadmap.RoadMap;
import oop.roadmap.RoadMapLv1;

/**
 *
 * @author ASUS
 */
public abstract class Monster {
    public int heath;
    private int money;
    public float x, y;
    protected Handler handler;
    public static int width = 64, height = 64;
    public boolean StatusLive = true;
    public boolean StatusFinish = false;
    private int Damege;
    public float speed;
    public float xMove = 0, yMove = 0;
    public int effect = 0;
    public int timeEffec = 50;
    protected RoadMap roadMap = new RoadMapLv1(this);
    
    public Monster(float x, float y, Handler handler, float speed, int Damge,  int heath, int money) {
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.speed = speed;
        this.Damege = Damge;       
        this.heath = heath;
        this.money = money;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public void MonsterMove(){
        if(timeEffec > 0){
            timeEffec--;
        } else {
            effect = 0;
        }
        
        if(effect == 1){
            speed = (float) 0.5;
        }else{
            speed = (float) 1.2;
        }
       
        xMove = 0;
        yMove = 0;
        roadMap.MonsterMove();
    }
    
    public int getDamege() {
        return Damege;
    }

    public void setDamege(int Damege) {
        this.Damege = Damege;
    }

    public int getMoney() {
        return money;
    }
    
    public boolean equals(Monster monster){
        if(this instanceof BatMonster && monster instanceof BatMonster){
            return true; 
        }else if(this instanceof BeetleMonster && monster instanceof BeetleMonster){
            return true;
        }
        
        return false;
    }
}
