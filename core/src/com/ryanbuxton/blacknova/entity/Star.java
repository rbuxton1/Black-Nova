package com.ryanbuxton.blacknova.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class Star implements Entity{
	private Sprite img;
	private Vector2 pos;
	private Camera cam;
	
	public Star(Sprite s, Camera cam) {
		img = s;
		pos = new Vector2(-1f, 0f);
		this.cam = cam;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		// fly along
		move();
		img.setPosition(pos.x, pos.y);
		img.draw(batch);
	}
	
	private void move() {
		if(pos.x > 0) {
			pos.x = (float) (pos.x - (Math.random() * 15));
		} else {
			pos.x = (float) (Math.random() * cam.viewportWidth);
			pos.y = (float) (Math.random() * cam.viewportHeight);
		}
	}
	
	@Override
	public void setPos(float x, float y) {
		pos.x = x;
		pos.y = y;
	}

	@Override
	public void setRotation(float deg) {}
	@Override
	public void pointTo(int x, int y) {}
}
