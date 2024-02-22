package com.github.speezinvaders.explosion;

import com.github.hanyaeger.api.Coordinate2D;

public interface ExplosionAdder {
    void addExplosion(final Coordinate2D anchorLocation, final double speed, final double direction);
}