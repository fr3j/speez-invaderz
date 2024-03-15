package com.github.speezinvaders.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.speezinvaders.entities.GameOverText;

public class GameOverScene extends DynamicScene {
    public GameOverScene(){

    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background.jpg");
    }

    @Override
    public void setupEntities() {
        GameOverText gameOverText = new GameOverText(new Coordinate2D(getWidth() / 2, 0));
        addEntity(gameOverText);
    }
}
