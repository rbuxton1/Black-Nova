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
	private Sprite title, header, footer, optionPlay, optionSettings, optionCredits;
	private Star[] stars;
	
	public MainMenu(final Main game) {
		this.game = game;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 1920, 1080);
		
		
		title = game.atlas.createSprite("title");
		Sprite s = game.atlas.createSprite("star");
		footer = game.atlas.createSprite("option_footer");
		header = game.atlas.createSprite("option_footer");
		optionPlay = game.atlas.createSprite("menu_option");
		optionSettings = game.atlas.createSprite("menu_option");
		optionCredits = game.atlas.createSprite("menu_option");
		
		title.setPosition(0, cam.viewportHeight - title.getHeight());
		header.setPosition((cam.viewportWidth/2) - (header.getWidth()/2), cam.viewportHeight - title.getHeight() - header.getHeight());
		
		
		optionPlay.setPosition((cam.viewportWidth/2) - (optionPlay.getWidth()/2), header.getY() - (optionPlay.getHeight()));
		optionSettings.setPosition((cam.viewportWidth/2) - (optionSettings.getWidth()/2), header.getY() - (optionSettings.getHeight() * 3));
		optionCredits.setPosition((cam.viewportWidth/2) - (optionCredits.getWidth()/2), header.getY() - (optionCredits.getHeight() * 5));
		
		
		footer.setRotation(180);
		footer.setPosition((cam.viewportWidth/2) - (header.getWidth()/2), header.getY() - (optionCredits.getHeight() * 5) - footer.getHeight());
		
		stars = new Star[25];
		for(int i = 0; i < 25; i ++) {
			stars[i] = new Star(s, cam);
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
		optionPlay.draw(game.batch);
		optionSettings.draw(game.batch);
		optionCredits.draw(game.batch);
		
		game.titleFont.draw(game.batch, "PLAY", 0, optionPlay.getY() + 55, cam.viewportWidth, 1, false);
		game.titleFont.draw(game.batch, "SETTINGS", 0, optionSettings.getY() + 55, cam.viewportWidth, 1, false);
		game.titleFont.draw(game.batch, "CREDITS", 0, optionCredits.getY() + 55, cam.viewportWidth, 1, false);
		
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
	