package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class EnemySpawner extends EntitySpawner {



    private final double sceneWidth;
    private final double sceneHeight;
//    protected EnemySpawner(long intervalInMs) {
//        super(intervalInMs);
//    }

    public EnemySpawner(double sceneWidth, double sceneHeight){
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Enemy(new Coordinate2D(20, 100)));
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, sceneHeight);
    }
}
