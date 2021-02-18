package com.kgtu.spacewars;

import com.badlogic.gdx.Game;
import com.kgtu.spacewars.screen.MenuScreen;

public class SpaceWarsGame extends Game {
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}
}
