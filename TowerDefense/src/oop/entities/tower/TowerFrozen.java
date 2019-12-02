/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.tower;

import java.awt.Graphics;
import oop.Handler;
import static oop.entities.tower.Tower.TOWERHEIGHT;
import static oop.entities.tower.Tower.TOWERWIDTH;
import oop.gfx.Assets;

/**
 *
 * @author ASUS
 */
public class TowerFrozen extends Tower{

    public TowerFrozen(Handler handler, float x, float y) {
        super(handler, x, y, 20, 100, 1);
        timeEffect = 200;
        radius.setCenterX(130);
        radius.setCenterY(120);
        radius.setRadius(300);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.towerFrozen, (int) x, (int) y, TOWERWIDTH, TOWERHEIGHT, null);
    }
    
}
