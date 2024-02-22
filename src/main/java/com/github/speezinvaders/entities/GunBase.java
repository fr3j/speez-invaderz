package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import javafx.scene.paint.Color;

public class GunBase extends CircleEntity {

    public GunBase(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(60);
        setFill(Color.RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
