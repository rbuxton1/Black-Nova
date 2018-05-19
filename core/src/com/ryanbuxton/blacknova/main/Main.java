package com.ryanbuxton.blacknova.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite img;
	float deg = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("blacknova.atlas"));
		img = atlas.createSprite("player_hg");
		if(img != null)System.out.println("Got image I guess");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		img.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		img.draw(batch);
		img.rotate(1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
