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
import oop.states.GameState;
import oop.states.State;
import oop.tiles.Tile;
import oop.ui.ClickListener;
import oop.ui.UIImageButton;
import oop.ui.UIImageButton_NewGame;
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

    private UIImageButton_NewGame newgame;

    Menu menu;

    Thread timeDown;
    public int time = 10;
    GameStart gameStart;

    int typeMonster = 1;
    int healthMonsterUp = 0;
    int moneyMonterUp = 0;

    long timeBullet = 0;

    boolean NewGame = false;

    public World(Handler handler, String path) {
        this.handler = handler;

        this.towerManager = new TowerManager(handler, new TowerBasic(handler, 900, 700));

        loadWorld(path);

        this.player = new Player(handler);

        this.monsterManager = new MonsterManager(handler, player);
        this.bulletManager = new BulletManager(handler);

        newgame = new UIImageButton_NewGame(handler, new ClickListener() {
            @Override
            public void onClick() {
                if(NewGame){
                    State.setState(new GameState(handler));
                }               
            }
        });
        handler.getMouseManager().setNewGame(newgame);
        countdown_time();
    }

    public void countdown_time() {

        timeDown = new Thread() {
            @Override
            public void run() {
                for (time = 5; time >= 0; time--) {                   
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                gameStart = new GameStart();
                gameStart.start();
            }
        };
        timeDown.start();
    }

    public void addTower(Tower tower) {
        towerManager.addTower(tower);
    }

    public void tick() {
        if (player.StatusLive) {
            Collision();
            this.player.tick();
            this.bulletManager.tick();
            this.monsterManager.tick();
            if (timeBullet <= 0) {
                timeBullet = 50;
            } else {
                timeBullet -= 1;
            }

            //System.out.println("thoi gian ban: " + timeBullet);
        } else {
            NewGame = true;
            newgame.tick();
        }

    }

    public void render(Graphics g) {
        //world

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH), (int) (y * Tile.TILEHEIGHT));
            }
        }

        player.render(g);
        if (time >= 0) {
            g.drawString("Bạn còn: " + time, 950, 770);
        } else {
            g.drawString("Run", 950, 770);
        }
        towerManager.render(g);
        bulletManager.render(g);
        monsterManager.render(g);

        if (NewGame) {
            newgame.render(g);
        }
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
                    if (timeBullet <= 0) {
                        bulletManager.addBullet(new Bullet(handler, monsterManager.getListMonsters().get(j), towerManager.getTowers().get(i)));
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

    class GameStart extends Thread {

        public void run() {
            while (true) {
                if (typeMonster == 2) {
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
                } else {
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
                
                if(NewGame){
                    break;
                }
            }
            
        }
    }
}
