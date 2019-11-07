/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities;

import oop.Handler;
import oop.entities.tower.Tower;
import oop.entities.tower.TowerBasic;
import oop.entities.tower.TowerManager;
import oop.gfx.Assets;
import oop.item.TowerItem;
import oop.menu.Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ASUS
 */
public class Player {

    public int health = 300;
    private int money = 100;
    private Handler handler;

    private Menu menu;
    public int hand = 0;
    public boolean clickTower = false;
    private TowerManager towerManager;
    public boolean StatusLive = true;

    public Player(Handler handler) {
        this.handler = handler;
        this.menu = new Menu(handler, this);
        this.menu.loadMenuItem("res/menu/menuitem.txt");
    }

    public int getHealt() {
        return health;
    }

    public void setHealt(int healt) {
        this.health = healt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Health: " + this.health, 100, 750);
        g.drawString("Money: " + this.money + "$", 100, 800);
        this.menu.render(g);

        if (hand == 1) {
            if (this.money < 10) {
                //aler
            } else {
                g.drawImage(Assets.selectTower, handler.getMouseManager().getMouseX() - 32, handler.getMouseManager().getMouseY() - 32, 64, 64, null);
                g.drawImage(TowerItem.towerBasicItem.getTexture(), handler.getMouseManager().getMouseX() - 25, handler.getMouseManager().getMouseY() - 25, 50, 50, null);

                if (!clickTower) {
                    this.handler.getWorld().addTower(new TowerBasic(handler, handler.getMouseManager().getMouseX() - 25, handler.getMouseManager().getMouseY() - 25));
                    this.money -= 10;
                    hand = 0;
                }
            }

        }

    }

    public void tick() {
        handler.getMouseManager().setBuyTower(this);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
