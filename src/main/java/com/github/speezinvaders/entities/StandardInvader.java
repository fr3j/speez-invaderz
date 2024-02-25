package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.speezinvaders.explosion.ExplosionAdder;

public class StandardInvader extends Invader {
    public StandardInvader(Coordinate2D initialLocation, final ExplosionAdder explosionAdder) {
        super("spaceinvader.png", initialLocation, explosionAdder);
    }
}
