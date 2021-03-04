package com.kgtu.spacewars.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.kgtu.spacewars.base.BaseScreen;
import com.kgtu.spacewars.math.Rect;
import com.kgtu.spacewars.sprite.Background;
import com.kgtu.spacewars.sprite.ButtonExit;
import com.kgtu.spacewars.sprite.ButtonPlay;
import com.kgtu.spacewars.sprite.Star;

public class MenuScreen extends BaseScreen {

    private static final int STAR_COUNT = 256;

    private final Game game;

    private Texture bg;
    private TextureAtlas atlas;

    private Background background;
    private Star[] stars;

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    private Music music;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        atlas = new TextureAtlas(Gdx.files.internal("textures/menuAtlas.tpack"));
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++) {
            stars[i] = new Star(atlas);
        }
        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu.mp3"));
        music.setLooping(true);
        music.play();
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        music.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch, pointer, button);
        buttonPlay.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch, pointer, button);
        buttonPlay.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }
}
