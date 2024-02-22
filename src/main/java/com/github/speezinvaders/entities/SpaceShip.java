package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Set;

/**
 * A {@link SpaceShip} is just a simple {@link DynamicCircleEntity} that can move around the
 * {@link com.github.hanyaeger.api.scenes.DynamicScene}.
 * <p>
 * The interface {@link Collider} is used to registers collisions with a {@link com.github.hanyaeger.showcase.scenes.distance.entities.energyball.EnergyBall}.
 * <p>
 * The interface {@link MouseMovedListener} is used to follow the mouse pointer. The event handler
 * {@link MouseMovedListener#onMouseMoved(Coordinate2D)} is the used to change the appearance of the cursor
 * and set the anchor location of this Entity based on the cursor location. The {@link ControlArea}, which
 * is passed through the constructor is used to decide when the mouse moved should be listened to. Only when the
 * mouse pointer is within the {@link ControlArea}, the spaceship should follow it.
 */
public class SpaceShip extends DynamicCircleEntity implements MouseMovedListener, Collider, KeyListener {

    private static final double RADIUS = 20;

    public SpaceShip(final Coordinate2D location) {
        super(location);
        setStrokeWidth(1);
        setStrokeColor(Color.RED);
        setFill(Color.WHITE);
        setRadius(RADIUS);
    }

    @Override
    public void onMouseMoved(final Coordinate2D coordinate2D) {
//        if (coordinate2D.getX() > RADIUS + controlArea.getBoundingBox().getMinX() &&
//                coordinate2D.getX() < controlArea.getBoundingBox().getMaxX() - RADIUS &&
//                coordinate2D.getY() > RADIUS + controlArea.getBoundingBox().getMinY() &&
//                coordinate2D.getY() < controlArea.getBoundingBox().getMaxY() - RADIUS) {
            setCursor(Cursor.NONE);

            setAnchorLocation(coordinate2D);
          if (getCursor() == null || getCursor().equals(Cursor.NONE)) {
            setCursor(Cursor.DEFAULT);
        }
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