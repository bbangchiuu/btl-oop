package oop.gfx;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Assets {
	
	private static final int width = 32, height = 32;
	
        public static Font font28;
        
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage wood;
	public static BufferedImage[] btn_start;
        public static BufferedImage towerBasic, menuIMG;
        public static BufferedImage selectTower;
        
        public static BufferedImage[] batMonterLeft, batMonsterUp, batMonsterDown, batMonsterRight;
        
        public static int sizeBatMonster = 32;
	public static void init(){
                font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
            
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
                
                SpriteSheet bat_monster = new SpriteSheet(ImageLoader.loadImage("/textures/batAnimationSheet.png"));
                
                SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/TowerMenuGraphic2.png"));
                
                SpriteSheet towerBS = new SpriteSheet(ImageLoader.loadImage("/tower/SniperTowerGraphic.png"));
                
                SpriteSheet select = new SpriteSheet(ImageLoader.loadImage("/tower/SellSelectGraphic.png"));
                
		wood = sheet.crop(width, height, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height * 2);
		rock = sheet.crop(0, height * 2, width, height);
                
                menuIMG = menu.crop(0, 0, 300, 190);
                towerBasic = towerBS.crop(0, 0, 36, 31);
                selectTower = select.crop(0, 0, 38, 38);
                
                batMonsterDown = new BufferedImage[3];
                batMonsterDown[0] = bat_monster.crop(sizeBatMonster, 0, sizeBatMonster, sizeBatMonster);
                batMonsterDown[1] = bat_monster.crop(sizeBatMonster*2, 0, sizeBatMonster, sizeBatMonster);
                batMonsterDown[2] = bat_monster.crop(sizeBatMonster*3, 0, sizeBatMonster, sizeBatMonster);
                
                batMonterLeft = new BufferedImage[3];
                batMonterLeft[0] = bat_monster.crop(sizeBatMonster, sizeBatMonster, sizeBatMonster, sizeBatMonster);
                batMonterLeft[1] = bat_monster.crop(sizeBatMonster*2, sizeBatMonster, sizeBatMonster, sizeBatMonster);
                batMonterLeft[2] = bat_monster.crop(sizeBatMonster*3, sizeBatMonster, sizeBatMonster, sizeBatMonster);
                
                batMonsterUp = new BufferedImage[3];
                batMonsterUp[0] = bat_monster.crop(sizeBatMonster, sizeBatMonster*2, sizeBatMonster, sizeBatMonster);
                batMonsterUp[1] = bat_monster.crop(sizeBatMonster*2, sizeBatMonster*2, sizeBatMonster, sizeBatMonster);
                batMonsterUp[2] = bat_monster.crop(sizeBatMonster*3, sizeBatMonster*2, sizeBatMonster, sizeBatMonster);
             
                batMonsterRight = new BufferedImage[3];
                batMonsterRight[0] = bat_monster.crop(sizeBatMonster, sizeBatMonster*3, sizeBatMonster, sizeBatMonster);
                batMonsterRight[1] = bat_monster.crop(sizeBatMonster*2, sizeBatMonster*3, sizeBatMonster, sizeBatMonster);
                batMonsterRight[2] = bat_monster.crop(sizeBatMonster*3, sizeBatMonster*3, sizeBatMonster, sizeBatMonster);
	}
	
}
