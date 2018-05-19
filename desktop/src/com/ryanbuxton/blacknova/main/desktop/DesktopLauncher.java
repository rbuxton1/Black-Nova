package com.ryanbuxton.blacknova.main.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ryanbuxton.blacknova.main.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = true;
		config.resizable = false;
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width; 
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.title = "Black Nova";
		new LwjglApplication(new Main(), config);
	}
}
