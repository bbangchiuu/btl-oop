/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.entities.monster;

import java.awt.Graphics;
import java.util.ArrayList;
import oop.Handler;
import oop.entities.Player;

/**
 *
 * @author ASUS
 */
public class MonsterManager {

    private Handler handler;
    private ArrayList<Monster> listMonsters;
    private Player player;

    public MonsterManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        listMonsters = new ArrayList<>();
    }

    public void addMonster(Monster monster) {
        listMonsters.add(monster);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Monster> getListMonsters() {
        return listMonsters;
    }

    public void setListMonsters(ArrayList<Monster> listMonsters) {
        this.listMonsters = listMonsters;
    }

    public void tick() {
        for (int i = 0; i < listMonsters.size(); i++) {
            listMonsters.get(i).tick();
            if(i > 0){
                if(listMonsters.get(i).x + Monster.width/2 >= listMonsters.get(i-1).x && listMonsters.get(i).x + Monster.width/2 <= listMonsters.get(i-1).x + Monster.width
                        && listMonsters.get(i).y >= listMonsters.get(i-1).y && listMonsters.get(i).y <= listMonsters.get(i-1).y + Monster.height/2){
                    
                    if(listMonsters.get(i).equals(listMonsters.get(i-1)))
                        continue;
                                      
                }
            }
            
            if (listMonsters.get(i).StatusFinish) {
                this.player.health -= listMonsters.get(i).getDamege();
                listMonsters.remove(i);
            } else if(listMonsters.get(i).heath <= 0){
                player.money += listMonsters.get(i).getMoney();
                listMonsters.remove(i);              
            } else {
                listMonsters.get(i).MonsterMove();
            }

        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < listMonsters.size(); i++) {
            listMonsters.get(i).render(g);
        }
       
    }
}
