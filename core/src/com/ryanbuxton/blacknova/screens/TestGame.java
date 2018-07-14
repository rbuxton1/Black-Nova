package com.ryanbuxton.blacknova.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.ryanbuxton.blacknova.entity.Player;
import com.ryanbuxton.blacknova.main.Main;
import com.ryanbuxton.blacknova.map.WorldMap;
import com.ryanbuxton.blacknova.map.StringMap;

public class TestGame implements Screen{
	private Main game;
	private Player player;
	private WorldMap cmap;
	private Vector2 pos;
	private float speed = 10;
	
	public TestGame(final Main game) {
		this.game = game;
		cmap = new WorldMap(8, 8, 16, 16, game);
		player = new Player(game);
		pos = new Vector2();
	}

	@Override
	public void render(float delta) {
		Vector3 mouse3 = game.cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		Vector2 mouse = new Vector2(mouse3.x, mouse3.y);
		
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.cam.update();
		game.batch.setProjectionMatrix(game.cam.combined);
		
		game.batch.begin();
		
		cmap.render(game.batch, pos);
		
		player.render(mouse);
		
		game.debugFont.draw(game.batch, "POS (" + pos.x + " , " + pos.y + ")", 0, 1000);
		game.debugFont.draw(game.batch, "CHUNK LOCATION (" + (int)(pos.x / (64 * 8)) + " , " + (int)(pos.y / (64 * 8)) + ")", 0, 950);
		game.debugFont.draw(game.batch, "CHUNK TYPE >>  '" + cmap.getChunkMap().get((int)(pos.x / (64 * 8)), (int)(pos.y / (64 * 8))) + "'", 100, 920);
		game.batch.end();
		
		if(Gdx.input.isKeyPressed(Keys.W) && pos.y + speed <= cmap.getWorldStringMap().getAsArray().length * 64) {
			pos.y = pos.y + speed;
		}
		if(Gdx.input.isKeyPressed(Keys.S) && pos.y - speed >= 0) {
			pos.y = pos.y - speed;
		}
		if(Gdx.input.isKeyPressed(Keys.A) && pos.x - speed >= 0) {
			pos.x = pos.x - speed;
		}
		if(Gdx.input.isKeyPressed(Keys.D) && pos.x + speed <= cmap.getWorldStringMap().getAsArray()[0].length * 64) {
			pos.x = pos.x + speed;
		}
		
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
