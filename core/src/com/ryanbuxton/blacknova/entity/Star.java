package com.ryanbuxton.blacknova.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class Star implements Entity{
	private Sprite img;
	private Vector2 pos;
	
	public Star(Sprite s) {
		img = s;
		pos = new Vector2(-1f, 0f);
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
			pos.x = (float) (Math.random() * Gdx.graphics.getWidth());
			pos.y = (float) (Math.random() * Gdx.graphics.getHeight());
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
