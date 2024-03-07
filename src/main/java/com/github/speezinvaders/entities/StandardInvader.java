package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.speezinvaders.Speezinvaderz;
import com.github.speezinvaders.explosion.ExplosionAdder;
import com.github.speezinvaders.scenes.GameLevel;

public class StandardInvader extends Invader {
    public StandardInvader(Coordinate2D initialLocation, final ExplosionAdder explosionAdder, GameLevel gameLevel, Speezinvaderz game) {
        super("spaceinvader.png", initialLocation, explosionAdder, gameLevel, game);
    }

    @Override
    public int getScoreValue() {
        return 10;
    }
}
