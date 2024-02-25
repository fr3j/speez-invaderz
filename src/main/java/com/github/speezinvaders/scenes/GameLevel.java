package com.github.speezinvaders.scenes;

import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.scenes.DynamicScene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.speezinvaders.BulletSpawner;
import com.github.speezinvaders.entities.*;
import com.github.speezinvaders.explosion.Explosion;
import com.github.speezinvaders.explosion.ExplosionAdder;
import javafx.animation.AnimationTimer;
import java.util.HashSet;
import java.util.Set;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, ExplosionAdder {
    private AnimationTimer movementTimer;
    private BulletSpawner bulletSpawner;
    private Set<Invader> currentWave = new HashSet<>();
    private double screenWidth;
    private boolean movingRight = true;
    private final double speed = 1.0; // Example speed value
    private final double downwardSpeed = 1.5; // Speed for moving down
    private final double moveDownDuration = 5000; // Time in milliseconds to move down
    private long lastDirectionChangeTime = 0;

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background.jpg");
        bulletSpawner = new BulletSpawner(new Coordinate2D(getWidth() / 2, getHeight()), this);
    }

    @Override
    public void setupEntities() {

        var spaceShip = new GunTarget(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        spaceShip.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(spaceShip);

        addAntiAircraftGun(spaceShip);
        startNewWave();
        setupInvaderMovement();
    }

    private boolean shouldChangeDirection(long currentTime) {
        // Implement logic to decide when to change direction
        // This might involve checking if enough time has passed since the last change
        return currentTime - lastDirectionChangeTime >= calculateTimeForDirectionChange();
    }




    private long calculateTimeForDirectionChange() {
        // Calculate the time interval after which direction should change
        // This can be based on the speed of the invaders and the width of the screen,
        // or simply a fixed time interval for simplicity
        return 1000; // Placeholder
    }
    private void setupInvaderMovement() {
        movementTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Continuously update invader positions based on their current motion.
                // This block intentionally left empty for this explanation.

                // Example check for changing direction
                if (shouldChangeDirection(now)) {
                    moveInvadersDownThenChangeDirection();
                }
            }
        };
        movementTimer.start();
    }
    private void moveInvadersDownThenChangeDirection() {
        // Temporarily increase speed and change direction downwards
        currentWave.forEach(invader -> invader.setMotion(speed, 90)); // 90 degrees for down

        // Schedule the continuation of horizontal movement after moving down is complete
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        // Change direction horizontally
                        double directionAngle = movingRight ? 180 : 0; // Reverse direction
                        movingRight = !movingRight; // Update the movingRight flag after the direction change
                        currentWave.forEach(invader -> invader.setMotion(speed, directionAngle));
                    }
                },
                (long) moveDownDuration
        );
    }

    private void maybeShoot() {
        // Randomly decide if an invader should shoot.
        // Ensure that only invaders at the bottom row have a chance to shoot.
    }

    private void startNewWave() {
        currentWave.clear();
        for (int i = 0; i < 10; i++) {
            Invader invader = new StandardInvader(new Coordinate2D(50 * i, 100), this);
            addEntity(invader);
            currentWave.add(invader);
        }

        // Reset or initialize movement direction for the new wave
        currentWave.forEach(invader -> invader.setMotion(speed, movingRight ? 0 : 180));
    }

    private void addAntiAircraftGun(final GunTarget gunTarget) {
        var gunBase = new GunBase(new Coordinate2D(getWidth() / 2, getHeight()));
        addEntity(gunBase);

        var gunLoop = new GunLoop(new Coordinate2D(getWidth() / 2, getHeight()), gunTarget, bulletSpawner);
        addEntity(gunLoop);

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(bulletSpawner);
    }

    @Override
    public void addExplosion(final Coordinate2D anchorLocation, double speed, double direction) {
        addEntity(new Explosion(anchorLocation));
    }



}