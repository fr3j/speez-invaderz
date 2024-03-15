package com.github.speezinvaders;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.speezinvaders.scenes.GameLevel;
import com.github.speezinvaders.scenes.GameOverScene;

public class Speezinvaderz extends YaegerGame {


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Speezinvaderz");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new GameLevel(this));
        addScene(1, new GameOverScene());
    }


}
