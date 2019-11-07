package oop.states;

import java.awt.Graphics;

import oop.Handler;
import oop.gfx.Assets;
import oop.ui.ClickListener;
import oop.ui.UIImageButton;
import oop.ui.UIManager;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class MenuState extends State {

        private UIManager uiManager;
    
	public MenuState(Handler handler){
		super(handler);
                
                uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);//khởi tạo 1 ArrayList UIObject

                //add 1 đối tượng vào trong list UIObject
		uiManager.addObject(new UIImageButton(550, 240, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
                                System.out.println("da click");
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
            
            //test
//            //ấn cùng lúc chuột trái và phải thì sẽ hiên game
//                if(handler.getMouseManager().isLeftPress() && handler.getMouseManager().isRightPress()){
//                    State.setState(handler.getGame().gameState);
//                }

            uiManager.tick();

	}

	@Override
	public void render(Graphics g) {
                uiManager.render(g);
	}
	
}
