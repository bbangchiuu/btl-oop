/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.item;

import oop.Handler;
import oop.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author ASUS
 */
public class TowerItem {

    public static TowerItem[] towerItems = new TowerItem[256];
    public static TowerItem towerBasicItem = new TowerBasicItem(0);

    public static final int ITEMWIDTH = 50, ITEMHEIGHT = 50;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    public int price;
    
    public TowerItem(BufferedImage texture, String name, int id, int price) {
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.price = price;
        
        towerItems[id] = this;
    }
    
    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
    
    
}
