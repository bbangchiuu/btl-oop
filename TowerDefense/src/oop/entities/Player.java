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
import oop.entities.tower.TowerFrozen;
import oop.tiles.Tile;

/**
 *
 * @author ASUS
 */
public class Player {

    public int health = 300;
    public int money = 100;
    private Handler handler;

    private Menu menu;
    public int hand = 0;
    public boolean clickTower = false;
    private TowerManager towerManager;
    public boolean StatusLive = true;
    public int typeItem = 0;
    public boolean checkTower = true;
    
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
       
        this.menu.render(g);

        if (hand == 1) {

                g.drawImage(Assets.selectTower, handler.getMouseManager().getMouseX() - 32, handler.getMouseManager().getMouseY() - 32, 64, 64, null);              
                
                //click type tower
                if(typeItem == 0){
                    g.drawImage(TowerItem.towerBasicItem.getTexture(), handler.getMouseManager().getMouseX() - 25, handler.getMouseManager().getMouseY() - 25, 50, 50, null);
                }else if(typeItem == 1){
                    g.drawImage(TowerItem.towerFrozenItem.getTexture(), handler.getMouseManager().getMouseX() - 25, handler.getMouseManager().getMouseY() - 25, 50, 50, null);
                }                               
                
                //check position to set up tower
                if(handler.getWorld().getTile((handler.getMouseManager().getMouseX()-Tower.TOWERWIDTH/2)/Tile.TILEWIDTH, (handler.getMouseManager().getMouseY()-Tower.TOWERHEIGHT/2)/Tile.TILEHEIGHT).isSolid()
                 ||handler.getWorld().getTile((handler.getMouseManager().getMouseX()-Tower.TOWERWIDTH/2)/Tile.TILEWIDTH, (handler.getMouseManager().getMouseY()+Tower.TOWERHEIGHT/2)/Tile.TILEHEIGHT).isSolid()
                 ||handler.getWorld().getTile((handler.getMouseManager().getMouseX()+Tower.TOWERWIDTH/2)/Tile.TILEWIDTH, (handler.getMouseManager().getMouseY()-Tower.TOWERHEIGHT/2)/Tile.TILEHEIGHT).isSolid()
                 ||handler.getWorld().getTile((handler.getMouseManager().getMouseX()+Tower.TOWERWIDTH/2)/Tile.TILEWIDTH, (handler.getMouseManager().getMouseY()+Tower.TOWERHEIGHT/2)/Tile.TILEHEIGHT).isSolid()){
                    g.setColor(new Color(255, 0, 0, 100));
                    g.fillRect(handler.getMouseManager().getMouseX() - 32, handler.getMouseManager().getMouseY() - 32, 66, 66);
                    checkTower = false;
                }else{
                    checkTower = true;
                }
                
                //set up tower
                if (!clickTower) {
                    if(typeItem == 0){
                        this.handler.getWorld().addTower(new TowerBasic(handler, handler.getMouseManager().getMouseX() - 25, handler.getMouseManager().getMouseY() - 25));
                        this.money -= 10;
                    }else if(typeItem == 1){
                        this.handler.getWorld().addTower(new TowerFrozen(handler, handler.getMouseManager().getMouseX() - 25, handler.getMouseManager().getMouseY() - 25));
                        this.money -= 20;
                    }
             
                    hand = 0;
                }

        }
        
        g.setColor(Color.yellow);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Health: " + this.health, 100, 750);
        g.drawString("Money: " + this.money + "$", 100, 800);
    }

    public void tick() {
        handler.getMouseManager().setBuyTower(handler, this);
        if(health <= 0){
            StatusLive = false;
        }
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
