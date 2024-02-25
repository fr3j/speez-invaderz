package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.speezinvaders.explosion.ExplosionAdder;

public class Mothership extends Invader{
    public Mothership(Coordinate2D initialLocation, final ExplosionAdder explosionAdder) {
        super("mothership.png", initialLocation, explosionAdder);
    }
}
