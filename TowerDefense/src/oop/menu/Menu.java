/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.menu;

import oop.Handler;
import oop.entities.Player;
import oop.entities.tower.Tower;
import oop.gfx.Assets;
import oop.item.TowerItem;
import oop.utils.Utils;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Menu {

    private Handler handler;
    private int x = 500, y = 700;

    private int[][] towers;

    private int width, height;
    
    Player player;

    public Menu(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        towers = new int[2][3];

    }

    public void render(Graphics g) {
        g.drawImage(Assets.menuIMG, this.x, this.y, null);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {        
                getTowerItem(i, j).render(g, (int) (x + TowerItem.ITEMWIDTH * i * 1.5 + 70), (int) (y + TowerItem.ITEMHEIGHT * j * 1.7 + 25));
                if(this.player.getMoney() < getTowerItem(i, j).price){
                    g.setColor(new Color(255, 0, 0, 100));
                    g.fillRect((int) (x + TowerItem.ITEMWIDTH * i * 1.57 + 60), (int) (y + TowerItem.ITEMHEIGHT * j * 1.7 + 20), 66, 66);
                }               
            }
        }
    }

    public void loadMenuItem(String path) {
        String file = Utils.loadFileAsString(path);

        String[] tokens = file.split("\\s+");
        height = Utils.parseInt(tokens[0]);
        width = Utils.parseInt(tokens[1]);

        towers = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                towers[x][y] = Utils.parseInt(tokens[(x + y * width) + 2]);
            }
        }

    }

    private TowerItem getTowerItem(int x, int y) {
        TowerItem t = TowerItem.towerItems[towers[x][y]];

        if (t == null) {//exception
            return TowerItem.towerBasicItem;
        }

        return t;
    }

    public int[][] getTowers() {
        return towers;
    }

    public void setTowers(int[][] towers) {
        this.towers = towers;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
