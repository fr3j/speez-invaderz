package com.github.speezinvaders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.speezinvaders.entities.Bullet;
import com.github.speezinvaders.explosion.ExplosionAdder;

import java.util.Random;

public class BulletSpawner extends EntitySpawner {

    private final Coordinate2D location;
    private ExplosionAdder explosionAdder;
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
        // We use a rondom boolean value to decide if we spawn a new rocket.
        if (new Random().nextBoolean()) {
            var newBall = new Bullet(location, direction, explosionAdder);
            newBall.setHue(requestedHue);
            newBall.setSaturation(requestedSaturation);
            // Set the viewOrder to a value higher that the default to ensure the rockets appear from behind
            // the rocket launcher.
            newBall.setViewOrder(42);
            spawn(newBall);
        }
    }

    public void setDirection(final double direction) {
        this.direction = direction;
    }

    public void setHue(double definedHue) {
        this.requestedHue = definedHue;
    }

    public void setSaturation(double definedSaturation) {
        requestedSaturation = definedSaturation;
    }
}