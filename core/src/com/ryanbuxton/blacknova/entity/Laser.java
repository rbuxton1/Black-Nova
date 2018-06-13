package com.ryanbuxton.blacknova.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ryanbuxton.blacknova.main.Main;

public class Laser implements Entity{
	private Sprite laser;
	private Main game;
	private float speed = 10;
	private int dist = 0;
	private boolean dead = false;
	
	public Laser(Main game, Player player, float rot) {
		this.game = game;
		laser = game.atlas.createSprite("laser");
		laser.setRotation(rot);
		//Gdx.app.log("debug", "active laser " + rot);
		laser.setPosition(game.cam.viewportWidth/2 + player.getActive().getWidth()/2, game.cam.viewportHeight/2 + player.getActive().getHeight()/2);
	}

	public void render() {
		Vector2 dir = new Vector2((float)Math.cos(Math.toRadians(laser.getRotation())), (float)Math.sin(Math.toRadians(laser.getRotation())));
		if(dir.len() > 0) {
			dir.nor();
		}
		Vector2 vel = new Vector2(dir.x * speed, dir.y * speed);
		
		laser.setPosition(laser.getX() + vel.x * dist, laser.getY() + vel.y *dist);
		laser.draw(game.batch);
		dist ++;
	}
	
	public boolean isDead() {
		return (dist > 100);
	}
	
	@Override
	public void setPos(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation(float deg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pointTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
