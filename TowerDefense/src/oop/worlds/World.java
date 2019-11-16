package oop.worlds;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import oop.Game;
import oop.Handler;
import oop.entities.Player;
import oop.entities.bullets.Bullet;
import oop.entities.bullets.BulletManager;
import oop.entities.monster.BatMonster;
import oop.entities.monster.BeetleMonster;
import oop.entities.monster.Monster;
import oop.entities.monster.MonsterManager;
import oop.entities.tower.Tower;
import oop.entities.tower.TowerBasic;
import oop.entities.tower.TowerManager;
import oop.gfx.Assets;
import oop.menu.Menu;
import oop.roadmap.RoadMapLv1;
import oop.states.State;
import oop.tiles.Tile;
import oop.ui.ClickListener;
import oop.ui.UIImageButton;
import oop.ui.UIManager;
import oop.utils.Utils;

public class World {

    private Handler handler;
    private int width, height;
    private int[][] tiles;

    //Entities
    private TowerManager towerManager;
    private Player player;
    private MonsterManager monsterManager;
    private BulletManager bulletManager;

    private UIManager uiManager;

    Menu menu;

    Thread timeDown;

    public int time = 3;

    int typeMonster = 1;
    int healthMonsterUp = 0;
    int moneyMonterUp = 0;
    
    public World(Handler handler, String path) {
        this.handler = handler;

        this.towerManager = new TowerManager(handler, new TowerBasic(handler, 900, 700));

        loadWorld(path);

        this.player = new Player(handler);

        this.monsterManager = new MonsterManager(handler, player);
        this.bulletManager = new BulletManager(handler);
        
        gameStart();
    }

    public void gameStart() {
        
        timeDown = new Thread() {
            @Override
            public void run() {
                while (true) {              
                    if(typeMonster == 2){
                        for (int i = 0; i < 10; i++) {
                            monsterManager.addMonster(new BeetleMonster(0, 510, handler, 
                                    200 + healthMonsterUp, 10 + moneyMonterUp));
                            try {
                                this.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        typeMonster = 1;
                    }else{
                        for (int i = 0; i < 10; i++) {
                            monsterManager.addMonster(new BatMonster(0, 510, handler, 
                                    100 + healthMonsterUp, 10 + moneyMonterUp));
                            try {
                                this.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }        
                        typeMonster = 2;
                    }
                    healthMonsterUp += 100;
                    moneyMonterUp += 5;
                    try {
                        this.sleep(10000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        timeDown.start();
    }

    public void addTower(Tower tower) {
        System.out.println("da them");
        towerManager.addTower(tower);
    }

    public void tick() {
        Collision();
        this.player.tick();
        this.bulletManager.tick();
        this.monsterManager.tick();
    }

    public void render(Graphics g) {
        //world

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH), (int) (y * Tile.TILEHEIGHT));
            }
        }

        player.render(g);
        towerManager.render(g);
        bulletManager.render(g);
        monsterManager.render(g);
    }

    public Tile getTile(int x, int y) {

        if (x < 0 || y < 0 || x >= width || y >= height) {   //exception                
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];

        if (t == null) {//exception

            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);

        tiles = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 2]);
            }
        }

    }

    private void Collision() {
        for (int i = 0; i < towerManager.getTowers().size(); i++) {
            for (int j = 0; j < monsterManager.getListMonsters().size(); j++) {
                if (CollisionX(i, j) && CollisionY(i, j)) {
//                    bulletManager.addBullet(new Bullet(handler, monsterManager.getListMonsters().get(j), towerManager.getTowers().get(i)));
                    if (towerManager.getTowers().get(i).getEffect() == 1) {
                        monsterManager.getListMonsters().get(j).speed = (float) 0.3;
                    }
                    monsterManager.getListMonsters().get(j).heath -= towerManager.getTowers().get(i).getDamege();
                    if (monsterManager.getListMonsters().get(j).heath <= 0) {
                        player.money += monsterManager.getListMonsters().get(j).getMoney();
                        monsterManager.getListMonsters().remove(j);
                    }
                    break;
                }
            }
        }
    }

    public boolean CollisionX(int i, int j) {
        if (monsterManager.getListMonsters().get(j).x + Monster.width / 2 >= towerManager.getTowers().get(i).NearestRangeX()
                && monsterManager.getListMonsters().get(j).x <= towerManager.getTowers().get(i).FurthestRangeX()) {
            return true;
        }
        return false;
    }

    public boolean CollisionY(int i, int j) {
        if (monsterManager.getListMonsters().get(j).y + Monster.height / 2 >= towerManager.getTowers().get(i).NearestRangeY()
                && monsterManager.getListMonsters().get(j).y <= towerManager.getTowers().get(i).FurthestRangeY()) {
            return true;
        }
        return false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    
}
