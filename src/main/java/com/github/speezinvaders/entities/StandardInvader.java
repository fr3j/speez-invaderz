package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.speezinvaders.Speezinvaderz;
import com.github.speezinvaders.explosion.ExplosionAdder;
import com.github.speezinvaders.scenes.GameLevel;

import java.util.Random;

public class StandardInvader extends Invader {
    public StandardInvader(Coordinate2D initialLocation, final ExplosionAdder explosionAdder, GameLevel gameLevel, Speezinvaderz game) {
        super("spaceinvader.png", initialLocation, explosionAdder, gameLevel, game);
    }

    @Override
    public void makeNoise() {
        Random rand = new Random();

        if (rand.nextInt(10) == 0) {
            new SoundClip("spaceinvadersound.wav").play();
        }
    }

    @Override
    public int getScoreValue() {
        return 10;
    }
}
