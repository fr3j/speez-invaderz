package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.speezinvaders.BulletSpawner;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Set;

public class Player extends DynamicRectangleEntity implements UpdateExposer, KeyListener {
    private final BulletSpawner bulletSpawner;

    public Player(final Coordinate2D initialPosition, final BulletSpawner bulletSpawner) {
        super(initialPosition);
        this.bulletSpawner = bulletSpawner;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.BLUE);
        setWidth(15);
        setHeight(15);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
            bulletSpawner.setLocation(getLocationInScene());
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
            bulletSpawner.setLocation(getLocationInScene());
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

}
