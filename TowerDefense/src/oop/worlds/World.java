package oop.worlds;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import oop.Game;
import oop.Handler;
import oop.entities.Player;
import oop.entities.monster.BatMonster;
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

    private UIManager uiManager;

    Menu menu;

    CountDownThread countDownThread;
    Thread timeDown;

    public int time = 10;

    public int lvWord = 1;
    
    public World(Handler handler, String path) {
        this.handler = handler;

        this.towerManager = new TowerManager(handler, new TowerBasic(handler, 900, 700));

        loadWorld(path);

        this.player = new Player(handler);

        this.monsterManager = new MonsterManager(handler, player);

//        uiManager = new UIManager(handler);
//        this.handler.getMouseManager().setUIManager(uiManager);
//        uiManager.addObject(new UIImageButton(950, 770, 128, 64, Assets.btn_start, new ClickListener() {
//            @Override
//            public void onClick() {
//                System.out.println("bat dau game");
//
//            }
//        }));
        gameStart();
    }

    public void gameStart() {
        timeDown = new Thread() {
            @Override
            public void run() {
                int count = 2;
                for (time = count; time > 0; time--) {;
                    try {
                        Thread.sleep(1000);
                        System.out.println("i: " + time);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                System.out.println("Hết giờ, Game chạy");
                if (time <= 0) {
                    countDownThread = new CountDownThread();
                    countDownThread.start();
                    this.stop();                   
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
        this.player.tick();
        //uiManager.tick();
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

        if(time > 0){
            g.drawString("Dem nguoc: " + time, 1000, 800);
        }else{
            g.drawString("Start" , 1000, 800);
        }
        
       //uiManager.render(g);
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
        //System.out.println("ss");
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    class CountDownThread extends Thread {

        @Override
        public void run() {
            int count = 10;
            for (int i = count; i > 0; i--) {
                System.out.println(i);
                try {
                    Monster monster = new BatMonster(0, 510, handler, lvWord);
                    monsterManager.addMonster(monster);

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Chạy hết quái");

        }
    }
}
