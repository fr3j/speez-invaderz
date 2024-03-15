package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;

public class GameOverText extends DynamicTextEntity {
    public GameOverText(Coordinate2D initialLocation) {
        super(initialLocation);
        setText("Your score was: ");
    }


}
