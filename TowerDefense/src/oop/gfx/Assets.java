package oop.gfx;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Assets {
	
	private static final int width = 32, height = 32;
	
        public static Font font28;
        
        public static BufferedImage Screen, NewGame;
        
	public static BufferedImage dirt, grass, stone, rock;
	public static BufferedImage[] btn_start;
        
        public static BufferedImage bulletBasic, freezeBulllet;
        public static BufferedImage towerBasic, towerFrozen, menuIMG;
        public static BufferedImage selectTower;
        
        public static BufferedImage[] batMonterLeft, batMonsterUp, batMonsterDown, batMonsterRight;
        public static BufferedImage[] beelteMonterLeft, beelteMonsterUp, beelteMonsterDown, beelteMonsterRight;
        
        public static int sizeBatMonster = 32;
        public static int widthBeelteMonster = 38, heightBeelteMonster = 38;
        
        public static int sizeMonster = 32;
        
	public static void init(){
                font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
            
                SpriteSheet screen = new SpriteSheet(ImageLoader.loadImage("/textures/screen.jpg"));
                SpriteSheet newgame = new SpriteSheet(ImageLoader.loadImage("/textures/MenuBar.png"));
                
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
                
                SpriteSheet bat_monster = new SpriteSheet(ImageLoader.loadImage("/textures/batAnimationSheet.png"));
                SpriteSheet beelte_monster = new SpriteSheet(ImageLoader.loadImage("/textures/beetle_black.png"));
                
                SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/TowerMenuGraphic2.png"));
                
                SpriteSheet towerBS = new SpriteSheet(ImageLoader.loadImage("/tower/SniperTowerGraphic.png"));
                SpriteSheet towerFZ = new SpriteSheet(ImageLoader.loadImage("/tower/FreezeTowerGraphic.png"));
                
                SpriteSheet BasicBullet = new SpriteSheet(ImageLoader.loadImage("/tower/BasicBullet.png"));
                SpriteSheet FreezeBullet = new SpriteSheet(ImageLoader.loadImage("/tower/FreezeBullet.png"));
                //SpriteSheet Bullet = new SpriteSheet(ImageLoader.loadImage("/tower/bullet1.png"));
                
                SpriteSheet select = new SpriteSheet(ImageLoader.loadImage("/tower/SellSelectGraphic.png"));
                
                Screen = screen.crop(0, 0, 516, 389);
                NewGame = newgame.crop(0, 0, 286, 56);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		rock = sheet.crop(0, height * 2, width, height);
                
                menuIMG = menu.crop(0, 0, 300, 190);
                towerBasic = towerBS.crop(0, 0, 36, 31);
                towerFrozen = towerFZ.crop(0, 0, 33, 26);
                selectTower = select.crop(0, 0, 38, 38);
                
                bulletBasic = BasicBullet.crop(0, 0, 15, 7);
                freezeBulllet = FreezeBullet.crop(0, 0, 22, 8);
                
                batMonsterDown = new BufferedImage[3];
                batMonsterDown[0] = bat_monster.crop(sizeBatMonster, 0, sizeMonster, sizeMonster);
                batMonsterDown[1] = bat_monster.crop(sizeBatMonster*2, 0, sizeMonster, sizeMonster);
                batMonsterDown[2] = bat_monster.crop(sizeBatMonster*3, 0, sizeMonster, sizeMonster);
                
                batMonterLeft = new BufferedImage[3];
                batMonterLeft[0] = bat_monster.crop(sizeBatMonster, sizeBatMonster, sizeMonster, sizeMonster);
                batMonterLeft[1] = bat_monster.crop(sizeBatMonster*2, sizeBatMonster, sizeMonster, sizeMonster);
                batMonterLeft[2] = bat_monster.crop(sizeBatMonster*3, sizeBatMonster, sizeMonster, sizeMonster);
                
                batMonsterUp = new BufferedImage[3];
                batMonsterUp[0] = bat_monster.crop(sizeBatMonster, sizeBatMonster*2, sizeMonster, sizeMonster);
                batMonsterUp[1] = bat_monster.crop(sizeBatMonster*2, sizeBatMonster*2, sizeMonster, sizeMonster);
                batMonsterUp[2] = bat_monster.crop(sizeBatMonster*3, sizeBatMonster*2, sizeMonster, sizeMonster);
             
                batMonsterRight = new BufferedImage[3];
                batMonsterRight[0] = bat_monster.crop(sizeBatMonster, sizeBatMonster*3, sizeMonster, sizeMonster);
                batMonsterRight[1] = bat_monster.crop(sizeBatMonster*2, sizeBatMonster*3, sizeMonster, sizeMonster);
                batMonsterRight[2] = bat_monster.crop(sizeBatMonster*3, sizeBatMonster*3, sizeMonster, sizeMonster);
                
                beelteMonsterDown = new BufferedImage[3];
                beelteMonsterDown[0] = beelte_monster.crop(0, 0, sizeMonster, sizeMonster);
                beelteMonsterDown[1] = beelte_monster.crop(widthBeelteMonster, 0, sizeMonster, sizeMonster);
                beelteMonsterDown[2] = beelte_monster.crop(widthBeelteMonster*2, 0, sizeMonster, sizeMonster);
                
                beelteMonsterUp = new BufferedImage[3];
                beelteMonsterUp[0] = beelte_monster.crop(0, heightBeelteMonster, sizeMonster, sizeMonster);
                beelteMonsterUp[1] = beelte_monster.crop(widthBeelteMonster, heightBeelteMonster, sizeMonster, sizeMonster);
                beelteMonsterUp[2] = beelte_monster.crop(widthBeelteMonster*2, heightBeelteMonster, sizeMonster, sizeMonster);
                
                beelteMonterLeft = new BufferedImage[3];
                beelteMonterLeft[0] = beelte_monster.crop(0, heightBeelteMonster*2, sizeMonster, sizeMonster);
                beelteMonterLeft[1] = beelte_monster.crop(widthBeelteMonster, heightBeelteMonster*2, sizeMonster, sizeMonster);
                beelteMonterLeft[2] = beelte_monster.crop(widthBeelteMonster*2, heightBeelteMonster*2, sizeMonster, sizeMonster);
                
                beelteMonsterRight = new BufferedImage[3];
                beelteMonsterRight[0] = beelte_monster.crop(0, heightBeelteMonster*3, sizeMonster, sizeMonster);
                beelteMonsterRight[1] = beelte_monster.crop(widthBeelteMonster, heightBeelteMonster*3, sizeMonster, sizeMonster);
                beelteMonsterRight[2] = beelte_monster.crop(widthBeelteMonster*2, heightBeelteMonster*3, sizeMonster, sizeMonster);
        }
	
}
