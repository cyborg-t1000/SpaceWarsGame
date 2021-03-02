package com.kgtu.spacewars.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.kgtu.spacewars.base.BaseButton;
import com.kgtu.spacewars.base.Sprite;
import com.kgtu.spacewars.math.Rect;

public class GameOver extends Sprite {

    private static final float HEIGHT = 0.1f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }

}
