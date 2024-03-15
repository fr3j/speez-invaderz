package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreDisplay extends DynamicTextEntity {
    private int score = 0;

    public ScoreDisplay(Coordinate2D initialPosition) {
        super(initialPosition);
        setText("Score: 0");
        setFill(Color.WHITE);
        setFont(Font.font("arial", FontWeight.BOLD, 24));
    }

    public void increaseScore(int points) {
        score += points;
        setText("Score: " + score);
    }
}

