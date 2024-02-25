package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.speezinvaders.explosion.ExplosionAdder;

import java.util.List;

public abstract class Invader extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided {

    private ExplosionAdder explosionAdder;
    public Invader(String resource, Coordinate2D initialLocation, final ExplosionAdder explosionAdder) {
        super(resource, initialLocation);
        this.explosionAdder = explosionAdder;
    }
    @Override
    public void onCollision(List<Collider> collidingObject) {
        remove();
        explode();
    }
    private void explode() {
            explosionAdder.addExplosion(getAnchorLocation(), getSpeed(), getDirection());
    }
    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }

    // Add common behavior for invaders here
    // For example, movement logic, which can be overridden by subclasses if needed

}
