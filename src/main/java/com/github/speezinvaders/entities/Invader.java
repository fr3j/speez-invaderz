package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.speezinvaders.Speezinvaderz;
import com.github.speezinvaders.explosion.ExplosionAdder;
import com.github.speezinvaders.scenes.GameLevel;

import java.util.List;

public abstract class Invader extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided {

    private Speezinvaderz game;
    private ExplosionAdder explosionAdder;
    private GameLevel gameLevel;

    public Invader(String resource, Coordinate2D initialLocation, final ExplosionAdder explosionAdder, GameLevel gameLevel, Speezinvaderz game) {
        super(resource, initialLocation);
        this.explosionAdder = explosionAdder;
        this.gameLevel = gameLevel;
        this.game = game;
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        remove();
        explode();
        gameLevel.getScoreBoard().increaseScore(getScoreValue());
        gameLevel.activateLaserPowerUp();
    }

    private void explode() {
        explosionAdder.addExplosion(getAnchorLocation(), getSpeed(), getDirection());
    }

    public void attack() {

    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        remove();
        gameLevel.loseLife();

    }

    public abstract void makeNoise();

    public abstract int getScoreValue();


}
