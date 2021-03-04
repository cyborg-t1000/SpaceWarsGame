package com.kgtu.spacewars.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.kgtu.spacewars.base.BaseButton;
import com.kgtu.spacewars.math.Rect;
import com.kgtu.spacewars.screen.GameScreen;

public class NewGame extends BaseButton {

    private static final float HEIGHT = 0.06f;

    private GameScreen gameScreen;

    public NewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
