package com.github.speezinvaders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.speezinvaders.entities.Invader;
import com.github.speezinvaders.entities.StandardInvader;
import com.github.speezinvaders.explosion.ExplosionAdder;
import com.github.speezinvaders.scenes.GameLevel;

public class InvaderSpawner extends EntitySpawner {
    private final double speed;
    private ExplosionAdder explosionAdder;
    private GameLevel gameLevel;
    private Speezinvaderz game;
    public InvaderSpawner(ExplosionAdder explosionAdder, long spawnInterval, double speed, GameLevel gameLevel, Speezinvaderz game) {
        super(spawnInterval);
        this.explosionAdder = explosionAdder;
        this.speed = speed;
        this.gameLevel = gameLevel;
        this.game = game;
    }

    @Override
    protected void spawnEntities() {
        for (int i = 0; i < 10; i++) {
            Invader invader = new StandardInvader(new Coordinate2D((75 * i+50), 100),explosionAdder, gameLevel, game);
            invader.setMotion(speed, 0);
            invader.attack();
            invader.makeNoise();
            spawn(invader);
        }
    }
}
