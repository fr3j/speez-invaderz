package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LiveDisplay extends DynamicTextEntity {
    private int lives;

    public LiveDisplay(Coordinate2D initialLocation, int lives) {
        super(initialLocation);
        this.lives = lives;
        setText("Lives: " + lives);
        setFill(Color.WHITE);
        setFont(Font.font("arial", FontWeight.BOLD, 24));
    }
    public void decreaseLife(int lives) {
        this.lives -= lives;
        setText("Lives: " + lives);
    }
}
