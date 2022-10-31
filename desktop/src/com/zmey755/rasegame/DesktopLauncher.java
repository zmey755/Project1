package com.zmey755.rasegame;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.zmey755.rasegame.Main;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(854, 480);
        config.setForegroundFPS(5);
		config.useVsync(false);
		//config.setForegroundFPS(60);

		config.setTitle("RaseGame");

		new Lwjgl3Application(new Main(), config);
	}
}
