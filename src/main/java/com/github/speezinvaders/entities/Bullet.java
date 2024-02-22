package com.github.speezinvaders.entities;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.speezinvaders.explosion.ExplosionAdder;

import java.util.List;

public class Bullet extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided, TimerContainer {

    private ExplosionAdder explosionAdder;

    public Bullet(final Coordinate2D location, final double direction, final ExplosionAdder explosionAdder) {
        super("energyball.jpg", location, new Size(20), 1, 9);
        this.explosionAdder = explosionAdder;

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(10, direction);

        new SoundClip("laser.mp3").play();
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        remove();
    }

    public void explode() {
        explosionAdder.addExplosion(getAnchorLocation(), getSpeed(), getDirection());
    }

    @Override
    public void setupTimers() {
        addTimer(new BulletTimer(this));
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        remove();
        explode();
    }
}