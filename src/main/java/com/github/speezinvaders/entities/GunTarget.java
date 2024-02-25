package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Set;


public class GunTarget extends DynamicCircleEntity implements KeyListener {

    private static final double RADIUS = 20;

    public GunTarget(final Coordinate2D location) {
        super(location);
        setStrokeWidth(1);
        setStrokeColor(Color.RED);
        setFill(Color.WHITE);
        setRadius(RADIUS);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }
}