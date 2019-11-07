package oop.states;

import java.awt.Graphics;

import oop.Handler;
import oop.worlds.World;

public class GameState extends State {

	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
            handler.getWorld().tick();
	}

	@Override
	public void render(Graphics g) {
                handler.getWorld().render(g);
	}

}
