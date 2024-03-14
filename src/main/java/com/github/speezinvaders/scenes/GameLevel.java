package com.github.speezinvaders.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.speezinvaders.BulletSpawner;
import com.github.speezinvaders.InvaderSpawner;
import com.github.speezinvaders.Speezinvaderz;
import com.github.speezinvaders.entities.*;
import com.github.speezinvaders.explosion.Explosion;
import com.github.speezinvaders.explosion.ExplosionAdder;

import java.util.HashSet;
import java.util.Set;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, ExplosionAdder {
    private BulletSpawner bulletSpawner;
    private EntitySpawner invaderSpawner;
    private ScoreDisplay scoreBoard;
    private LiveDisplay liveDisplay;

    private Speezinvaderz speezinvaderz;

    private int lives = 3;


    public GameLevel(Speezinvaderz speezinvaderz) {
        this.speezinvaderz = speezinvaderz;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background.jpg");
        bulletSpawner = new BulletSpawner(new Coordinate2D(getWidth() / 2, getHeight()), this);
        invaderSpawner = new InvaderSpawner(this, 10000, 0.25, this, speezinvaderz);
    }

    @Override
    public void setupEntities() {
        this.scoreBoard = new ScoreDisplay(new Coordinate2D(0, 0));
        addEntity(scoreBoard);
        var player = new Player(new Coordinate2D(getWidth() / 2, getHeight()-30), bulletSpawner);
        addEntity(player);
        this.liveDisplay = new LiveDisplay(new Coordinate2D(getWidth() - 100, 0), lives);
        addEntity(liveDisplay);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(bulletSpawner);
        addEntitySpawner(invaderSpawner);
    }

    @Override
    public void addExplosion(final Coordinate2D anchorLocation, double speed, double direction) {
        addEntity(new Explosion(anchorLocation));
    }
    public ScoreDisplay getScoreBoard(){
        return this.scoreBoard;
    }

    public void loseLife() {
        lives--;
        if (lives <= 0) {
            speezinvaderz.setActiveScene(1);
        }
    }


}
