package com.github.speezinvaders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.speezinvaders.entities.Bullet;
import com.github.speezinvaders.explosion.ExplosionAdder;

import java.util.Random;

public class BulletSpawner extends EntitySpawner {

    private final Coordinate2D location;
    private final ExplosionAdder explosionAdder;
    private double direction = Direction.UP.getValue();

    private double requestedHue = 0D;
    private double requestedSaturation = 0D;

    public BulletSpawner(final Coordinate2D location, final ExplosionAdder explosionAdder) {
        super(500);
        this.location = location;
        this.explosionAdder = explosionAdder;
    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextBoolean()) {
            var newBall = new Bullet(location, direction, explosionAdder);
            newBall.setHue(requestedHue);
            newBall.setSaturation(requestedSaturation);
            newBall.setViewOrder(42);
            spawn(newBall);
        }
    }

    public void setDirection(final double direction) {
        this.direction = direction;
    }


}