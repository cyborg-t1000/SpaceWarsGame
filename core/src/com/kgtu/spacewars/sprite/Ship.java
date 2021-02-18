package com.kgtu.spacewars.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.kgtu.spacewars.base.Sprite;
import com.kgtu.spacewars.math.Rnd;

public class Ship extends Sprite {

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        regions[0].setRegionWidth(regions[0].getRegionWidth()/2);
        setHeightProportion(0.1f);
    }
}


