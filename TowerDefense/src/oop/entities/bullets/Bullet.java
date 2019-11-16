/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.bullets;

import java.awt.Graphics;
import oop.Handler;
import oop.entities.monster.Monster;
import oop.entities.tower.Tower;
import oop.gfx.Assets;

/**
 *
 * @author ASUS
 */
public class Bullet {
    private float x;
    private float y;
    private Handler handler;
    private Monster monster;
    private Tower tower;
    
    private float sinX, cosX;
    
    public Bullet(Handler handler, Monster monster, Tower tower){
        this.handler = handler;
        this.monster = monster;
        this.tower = tower;
        x = tower.getX() + Tower.TOWERWIDTH/2;
        y = tower.getY() + Tower.TOWERHEIGHT/2;
    }
    
    public void tick(){
        float setX = (monster.x >= tower.getX()) ? monster.x - tower.getX() : tower.getX() - monster.x;
        float setY = (monster.y >= tower.getX()) ? monster.y - tower.getY() : tower.getY() - monster.y;
        float hypotenuse = (float) Math.sqrt(Math.pow(setX, 2) + Math.pow(setY, 2));
        
        sinX = setY/hypotenuse;
        cosX = setX/hypotenuse;
        
        if(monster.x >= tower.getX()){
            x += 1;
        }else{
            x -= 1;
        }
        if(monster.y >= tower.getX()){
            y += 1;
        }else{
            y -= 1;
        }
        
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.bulletBasic,(int) x, (int) y, null);
    }
}
