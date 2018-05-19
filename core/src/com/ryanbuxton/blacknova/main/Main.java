package com.ryanbuxton.blacknova.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.ryanbuxton.blacknova.screens.MainMenu;

public class Main extends Game {
	public SpriteBatch batch;
	public TextureAtlas atlas;
	public BitmapFont testFont;
	public String ver = "0.0.1";

	public void create() {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("blacknova.atlas");
		testFont = new BitmapFont();
		
		//last
		this.setScreen(new MainMenu(this));
	}

	public void render() {
		super.render(); //important!
	}
	public void dispose() {
		batch.dispose();
		testFont.dispose();
		atlas.dispose();
	}
}
