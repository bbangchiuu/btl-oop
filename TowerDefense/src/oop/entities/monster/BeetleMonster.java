/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.monster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import oop.Handler;
import oop.gfx.Animation;
import oop.gfx.Assets;
import oop.roadmap.RoadMap;
import oop.roadmap.RoadMapLv1;

/**
 *
 * @author ASUS
 */
public class BeetleMonster extends Monster {

    private Animation animDown, animUp, animLeft, animRight;

    public BeetleMonster(float x, float y, Handler handler, int health, int money) {
        super(x, y, handler, (float) 1, 10, health, money);

        animLeft = new Animation(500, Assets.beelteMonterLeft);
        animUp = new Animation(500, Assets.beelteMonsterUp);
        animDown = new Animation(500, Assets.beelteMonsterDown); 
        animRight = new Animation(500, Assets.beelteMonsterRight); 

        roadMap = new RoadMapLv1(this);
        
    }

    @Override
    public void tick() {
        animLeft.tick();
        animUp.tick();
        animDown.tick();
        animRight.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g.drawString(heath + "", (int) x + 20, (int) y);
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, Monster.width, Monster.height, null);
    }

    public BufferedImage getCurrentAnimationFrame() {
        if(xMove > 0){
            return animLeft.getCurrentFrame();
        }else if(xMove < 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else if (yMove > 0){
            return animDown.getCurrentFrame();
        }
                
        return animLeft.getCurrentFrame();
    }
}