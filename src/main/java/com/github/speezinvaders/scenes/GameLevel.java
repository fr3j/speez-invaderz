package com.github.speezinvaders.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.userinput.*;
import com.github.speezinvaders.BulletSpawner;
import com.github.speezinvaders.entities.EnemySpawner;
import com.github.speezinvaders.entities.GunBase;
import com.github.speezinvaders.entities.GunLoop;
import com.github.speezinvaders.entities.SpaceShip;
import com.github.speezinvaders.explosion.Explosion;
import com.github.speezinvaders.explosion.ExplosionAdder;
import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements MouseButtonPressedListener, MouseButtonReleasedListener, MouseEnterListener, MouseExitListener, MouseMovedListener, EntitySpawnerContainer, MouseMovedWhileDraggingListener, ExplosionAdder {



    private static final double CONTROL_AREA_MARGIN = 140D;
    private static final double TEXTFIELD_MARGIN = 20D;
    private static final double TEXTFIELD_DELTA = 50D;
    private static final String PRESSED = "PRESSED";
    private static final String RELEASED = "RELEASED";
    private BulletSpawner bulletSpawner;
    private EnemySpawner enemySpawner;

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background.jpg");

        // We instantiate the rocket spawner at this early stage, so we can pass it
        // to the antiAircraftLauncher.
        bulletSpawner = new BulletSpawner(new Coordinate2D(getWidth() / 2, getHeight()), this);
        enemySpawner = new EnemySpawner((getWidth()), getHeight());
    }

    @Override
    public void setupEntities() {

        var spaceShip = new SpaceShip(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        spaceShip.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(spaceShip);

        addAntiAircraftGun(spaceShip);
    }

    private void addAntiAircraftGun(final SpaceShip spaceShip) {
        var gunBase = new GunBase(new Coordinate2D(getWidth() / 2, getHeight()));
        addEntity(gunBase);

        var gunLoop = new GunLoop(new Coordinate2D(getWidth() / 2, getHeight()), spaceShip, bulletSpawner);
        addEntity(gunLoop);

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(bulletSpawner);
        addEntitySpawner(enemySpawner);
    }

//    @Override
//    public void onMouseMoved(final Coordinate2D coordinate2D) {
//        mousePointerTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
//    }
//
//    @Override
//    public void onMouseMovedWhileDragging(final Coordinate2D coordinate2D) {
//        mousePointerWhileDraggedTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
//    }
//
//    @Override
//    public void onMouseEntered() {
//        mouseInSceneTextField.setValue("YES");
//    }
//
//    @Override
//    public void onMouseExited() {
//        mouseInSceneTextField.setValue("NO");
//    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
//        switch (button) {
//            case PRIMARY -> primaryButtonPressedTextField.setValue(PRESSED);
//            case SECONDARY -> secondaryButtonPressedTextField.setValue(PRESSED);
//        }
    }

    @Override
    public void onMouseButtonReleased(final MouseButton button, final Coordinate2D coordinate2D) {
//        switch (button) {
//            case PRIMARY -> primaryButtonPressedTextField.setValue(RELEASED);
//            case SECONDARY -> secondaryButtonPressedTextField.setValue(RELEASED);
//        }
    }

    @Override
    public void addExplosion(final Coordinate2D anchorLocation, double speed, double direction) {
        addEntity(new Explosion(anchorLocation));
    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {

    }

    @Override
    public void onMouseMovedWhileDragging(Coordinate2D coordinate2D) {

    }
}