package com.kgtu.spacewars.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.kgtu.spacewars.base.Sprite;

public class Logo extends Sprite {

    Vector2 v;
    Vector2 to;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        pos.setZero();
        halfWidth = 0.25f;
        halfHeight = 0.25f;
        v = new Vector2();
        to = new Vector2();
    }

    @Override
    public void update(float delta) {
        if(to.cpy().sub(pos).len() > v.len()) {
            pos.add(v);
        } else {
            pos.set(to);
            v.setZero();
        }
        super.update(delta);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        to = touch;
        v = touch.cpy().sub(pos).setLength(0.01f);
        return super.touchDown(touch, pointer, button);
    }
}
