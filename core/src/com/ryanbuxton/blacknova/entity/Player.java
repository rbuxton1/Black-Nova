package com.ryanbuxton.blacknova.entity;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ryanbuxton.blacknova.main.Main;

public class Player implements Entity{
	private Sprite nothing, hg, mg, sg;
	private Main game;
	private ArrayList<Sprite> sprites;
	private int active = 1;
	private ArrayList<Laser> lasers;
	
	public Player(Main game) {
		this.game = game;
		nothing = game.atlas.createSprite("player_nothing");
		hg = game.atlas.createSprite("player_hg");
		mg = game.atlas.createSprite("player_mg");
		sg = game.atlas.createSprite("player_sg");
		
		nothing.setPosition(game.cam.viewportWidth/2, game.cam.viewportHeight/2);
		hg.setPosition(game.cam.viewportWidth/2, game.cam.viewportHeight/2);
		mg.setPosition(game.cam.viewportWidth/2, game.cam.viewportHeight/2);
		sg.setPosition(game.cam.viewportWidth/2, game.cam.viewportHeight/2);
		
		sprites = new ArrayList<Sprite>();
		lasers = new ArrayList<Laser>();
		
		sprites.add(nothing);
		sprites.add(hg);
		sprites.add(mg);
		sprites.add(sg);
		
		Gdx.app.log("debug", "size " + sprites.size());
		Gdx.app.log("debug", "active " + sprites.get(active));
		Gdx.app.log("debug", "batch " + game.batch);
	}
	
	public void render(Vector2 mouse) {
		sprites.get(active).setRotation((float)Math.toDegrees(Math.atan2(mouse.y - sprites.get(active).getY(), mouse.x - sprites.get(active).getX())));
		
		if(Gdx.input.justTouched()) {
			lasers.add(new Laser(game, this, sprites.get(active).getRotation()));
		}
		
		for(int i = lasers.size()-1; i >= 0; i--) {
			lasers.get(i).render();
			if(lasers.get(i).isDead()) {
				lasers.remove(i);
			}
		}
		
		sprites.get(active).draw(game.batch);
	}
	
	public Sprite getActive() {
		return sprites.get(active);
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
