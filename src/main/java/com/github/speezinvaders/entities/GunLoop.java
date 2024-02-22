package com.github.speezinvaders.entities;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.speezinvaders.BulletSpawner;
import javafx.scene.paint.Color;
public class GunLoop extends DynamicRectangleEntity implements UpdateExposer {

    private final SpaceShip spaceShip;
    private final BulletSpawner bulletSpawner;

    public GunLoop(final Coordinate2D initialPosition, final SpaceShip spaceShip, final BulletSpawner bulletSpawner) {
        super(initialPosition);
        this.spaceShip = spaceShip;
        this.bulletSpawner = bulletSpawner;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.BLUE);
        setWidth(15);
        setHeight(220);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        var angle = angleTo(spaceShip);
        bulletSpawner.setDirection(angle);
        setRotate(angle);
    }


}
