package com.github.speezinvaders.entities;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class LaserPowerUpIndicator extends DynamicTextEntity {
    private Timeline fadeTimeline;

    public LaserPowerUpIndicator(Coordinate2D initialPosition) {
        super(initialPosition);
        setText("LASER MODE ACTIVATED!!!");
        setFill(Color.WHITE);
        setFont(Font.font("arial", FontWeight.BOLD, 30));
        setOpacity(0);
        createFadeTimeline();
    }

    private void createFadeTimeline() {
        fadeTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0), evt -> setOpacity(1)),
                new KeyFrame(Duration.seconds(5), evt -> setOpacity(0))
        );
        fadeTimeline.setCycleCount(1);
        fadeTimeline.setOnFinished(e -> setOpacity(0));
    }

    public void activate() {
        if (fadeTimeline != null && fadeTimeline.getStatus() == Timeline.Status.RUNNING) {
            fadeTimeline.stop();
        }
        createFadeTimeline();
        fadeTimeline.play();
    }
}
