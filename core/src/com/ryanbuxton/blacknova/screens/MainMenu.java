package com.ryanbuxton.blacknova.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.ryanbuxton.blacknova.entity.Star;
import com.ryanbuxton.blacknova.main.Main;

public class MainMenu implements Screen{
	private final Main game;
	private OrthographicCamera cam;
	private Sprite title, header, footer;
	private Star[] stars;
	
	public MainMenu(final Main game) {
		this.game = game;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 1920, 1080);
		
		title = game.atlas.createSprite("title");
		Sprite s = game.atlas.createSprite("star");
		footer = game.atlas.createSprite("option_footer");
		header = game.atlas.createSprite("option_footer");
		
		title.setPosition(0, Gdx.graphics.getHeight() - title.getHeight());
		header.setPosition((Gdx.graphics.getWidth()/2) - (header.getWidth()/2), Gdx.graphics.getHeight() - title.getHeight() - header.getHeight());
		footer.setRotation(180);
		footer.setPosition((Gdx.graphics.getWidth()/2) - (header.getWidth()/2), footer.getHeight());
		
		stars = new Star[25];
		for(int i = 0; i < 25; i ++) {
			stars[i] = new Star(s);
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.025f, .025f, 0.025f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		cam.update();
		game.batch.setProjectionMatrix(cam.combined);
		
		game.batch.begin();
		for(Star s : stars) {
			s.render(game.batch);
		}
		
		header.draw(game.batch);
		footer.draw(game.batch);
		title.draw(game.batch);
		game.testFont.draw(game.batch, "ART AND CONCEPT BY JOSEPH AHN\nCODE BY RYAN BUXTON (RYANBUXTON.COM)\nVERSION " + game.ver, 0, game.testFont.getCapHeight()*5);
		game.batch.end();
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void show() {}
	@Override
	public void resize(int width, int height) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	@Override
	public void dispose() {}
}
	