package com.kgtu.spacewars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.kgtu.spacewars.base.BaseScreen;
import com.kgtu.spacewars.math.Rect;
import com.kgtu.spacewars.sprite.Background;
import com.kgtu.spacewars.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private Texture logotx;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        logotx = new Texture("badlogic.jpg");
        logo = new Logo(logotx);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        logo.update(delta);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        logotx.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }
}
