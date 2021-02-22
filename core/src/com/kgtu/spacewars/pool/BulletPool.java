package com.kgtu.spacewars.pool;

import com.kgtu.spacewars.base.SpritesPool;
import com.kgtu.spacewars.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

}
