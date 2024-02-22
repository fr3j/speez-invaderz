package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Enemy extends SpriteEntity {
    protected Enemy(Coordinate2D initialLocation) {
        super("spaceinvader.png", initialLocation);
    }
}
