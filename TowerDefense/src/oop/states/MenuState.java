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
		uiManager.addObject(new UIImageButton(550, 420, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
                                System.out.println("da click");
				handler.getMouseManager().setUIManager(null);
				State.setState(new GameState(handler));
			}
		}));
	}

	@Override
	public void tick() {
            uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
                g.drawImage(Assets.Screen, -10, -10, handler.getWidth() + 10, handler.getHeight(), null);
                uiManager.render(g);
	}
	
}
