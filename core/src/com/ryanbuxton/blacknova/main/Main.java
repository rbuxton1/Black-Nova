package com.ryanbuxton.blacknova.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.ryanbuxton.blacknova.screens.MainMenu;

public class Main extends Game {
	public SpriteBatch batch;
	public TextureAtlas atlas;
	public BitmapFont testFont, titleFont;
	public String ver = "0.0.1";
	public OrthographicCamera cam;

	public void create() {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("blacknova.atlas");
		
		//fonts
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("blacknova_font.ttf"));
		FreeTypeFontParameter par = new FreeTypeFontParameter();
		
		//testFont is a small font for debugging
		par.size = 20;
		par.color = Color.WHITE;
		testFont = gen.generateFont(par);
		
		
		//titleFont is big for menu items
		par = new FreeTypeFontParameter();
		par.size = 40;
		par.shadowOffsetX = 5;
		par.shadowOffsetY = 5;
		par.color = Color.WHITE;
		par.shadowColor = Color.BLACK;
		titleFont = gen.generateFont(par);
		
		gen.dispose();
		
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 1920, 1080);
		
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
