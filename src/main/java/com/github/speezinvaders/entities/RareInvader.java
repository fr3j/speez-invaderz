package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.speezinvaders.Speezinvaderz;
import com.github.speezinvaders.explosion.ExplosionAdder;
import com.github.speezinvaders.scenes.GameLevel;

public class RareInvader extends Invader{
    public RareInvader(Coordinate2D initialLocation, ExplosionAdder explosionAdder, GameLevel gameLevel, Speezinvaderz game) {
        super("otherspaceinvader.png", initialLocation, explosionAdder, gameLevel, game);
    }

    @Override
    public void makeNoise() {
        new SoundClip("ufo_highpitch.wav").play();
    }

    @Override
    public int getScoreValue() {
        return 50;
    }
}
