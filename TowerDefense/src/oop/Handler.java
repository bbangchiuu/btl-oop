package oop;

import oop.input.KeyManager;
import oop.input.MouseManager;
import oop.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
        public MouseManager getMouseManager(){
                return game.getMouseManager();
        }
        
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

        public Game getGame() {
            return game;
        }

        public void setGame(Game game) {
            this.game = game;
        }

}
