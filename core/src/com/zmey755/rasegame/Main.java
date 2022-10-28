package com.zmey755.rasegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.zmey755.rasegame.view.GameScreen;

public class Main extends Game {
private Screen gameScreen;
	@Override
	public void create() {
    gameScreen = new GameScreen();
	//назначаем экран
	setScreen(gameScreen);
	}
}

