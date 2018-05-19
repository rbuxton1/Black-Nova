package com.ryanbuxton.blacknova.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {
	
	public void render(SpriteBatch batch);
	public void setPos(float x, float y);
	public void setRotation(float deg);
	public void pointTo(int x, int y);
}
