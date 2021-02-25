package com.kgtu.spacewars.pool;

import com.badlogic.gdx.audio.Sound;

import com.kgtu.spacewars.base.SpritesPool;
import com.kgtu.spacewars.math.Rect;
import com.kgtu.spacewars.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private BulletPool bulletPool;
    private Rect worldBounds;
    private Sound sound;

    public EnemyPool(BulletPool bulletPool, Rect worldBounds, Sound sound) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.sound = sound;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, worldBounds, sound);
    }
}
