/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.bullets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import oop.Handler;
import oop.entities.monster.Monster;
import oop.entities.tower.Tower;
import oop.entities.tower.TowerFrozen;
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
    public boolean statusFinish = false;

    private float sinX, cosX;
    private float damge;

    public float speed = 2;
    private int effect;
    private int timeEffect;
    
    public Bullet(Handler handler, Monster monster, Tower tower) {
        this.handler = handler;
        this.monster = monster;
        this.tower = tower;
        this.damge = 10;
        x = tower.getX() + Tower.TOWERWIDTH / 2;
        y = tower.getY() + Tower.TOWERHEIGHT / 4;
        damge = tower.getDamege();
        effect = tower.getEffect();
        timeEffect = tower.timeEffect;
    }

    public void tick() {
        if (monster == null) {
            System.out.println("da chet");
            statusFinish = true;
        } else {

            if (monster.x + Monster.width/2 >= tower.getX() + Tower.TOWERWIDTH) {
                x += speed;
                if (x > monster.x) {
                    x = monster.x;
                }
            } else {
                x -= speed;
                if (x < monster.x + monster.width / 2) {
                    x = monster.x + monster.width / 2;
                }
            }
            
            if (monster.y + Monster.height/2 > tower.getY() + Tower.TOWERHEIGHT/2) {
                y += speed;
                if (y > monster.y) {
                    y = monster.y;
                }
            } else {
                y -= speed;
                if (y < monster.y + monster.height) {
                    y = monster.y + monster.height;
                }
            }

            if (x >= monster.x && x <= monster.x + Monster.width && y >= monster.y && y <= monster.y + Monster.height) {
                monster.heath -= damge;
                statusFinish = true;
                if(effect == 1){
                    monster.effect = 1;
                    monster.timeEffec = timeEffect;
                }
            }
        }

    }

    public void render(Graphics g) {
        g.drawImage(getTypeBullet(), (int) x, (int) y, 22, 15, null);
    }
    
    public BufferedImage getTypeBullet(){
        if(this.tower instanceof TowerFrozen){
            return Assets.freezeBulllet;
        }
        
        return Assets.bulletBasic;
    }
}
