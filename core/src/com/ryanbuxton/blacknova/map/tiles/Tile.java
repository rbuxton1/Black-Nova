package com.ryanbuxton.blacknova.map.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Tile {
	private boolean solid;
	private Sprite img;
	private Vector2 pos;
	
	public Tile(Sprite img, boolean solid) {
		this.img = img;
		this.solid = solid;
	}
	public Sprite getImg() { return img; }
}
