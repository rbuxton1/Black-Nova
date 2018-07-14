package com.ryanbuxton.blacknova.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ryanbuxton.blacknova.main.Main;
import com.ryanbuxton.blacknova.map.tiles.Tile;

public class TileMap {
	private Tile[][] map;
	
	public TileMap(int width, int height) {
		map = new Tile[width][height];
	}
	
	public void render(SpriteBatch batch, Vector2 pos, Main game) {
		for(int y = 0; y < map.length; y++){
			for(int x = 0; x < map[y].length; x++) {
				if(get(x,y) != null) batch.draw(get(x,y).getImg(), x * get(x,y).getImg().getWidth() - pos.x + game.cam.viewportWidth/2, y * get(x,y).getImg().getHeight() - pos.y + game.cam.viewportHeight/2);
			}
		}
	}
	
	public Tile get(int x, int y) {
		if(x >= map[0].length || x < 0 || y >= map.length || y < 0) return null;
		return map[(map.length-1) - y][x];
	}
	public void set(int x, int y, Tile t) {
		map[(map.length-1) - y][x] = t;
	}
}
