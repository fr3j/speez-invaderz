package com.github.speezinvaders.entities;

import com.github.hanyaeger.api.Timer;

public class BulletTimer extends Timer {

    private int delta = 1;
    private Bullet bullet;

    public BulletTimer(final Bullet bullet) {
        super(50);
        this.bullet = bullet;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        if (bullet.getCurrentFrameIndex() == 0) {
            delta = 1;
        } else if (bullet.getCurrentFrameIndex() == 8) {
            delta = -1;
        }

        bullet.setCurrentFrameIndex(bullet.getCurrentFrameIndex() + delta);
        bullet.setOpacity(0.2 * bullet.getCurrentFrameIndex());
    }
}