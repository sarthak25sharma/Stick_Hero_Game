package com.example.final_propro;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class Tower {
    private int t;
    @FXML
    private Rectangle r1;
    @FXML
    private Rectangle r2;
    @FXML
    private ImageView s;
    static void Tower_mover(int t, Rectangle r1, Rectangle r2,ImageView s, Rectangle stick) {
        if (t == 1) {

            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), r2);
            transition.setToX(0);
            transition.play();
            r2.setLayoutX(0);
            TranslateTransition transitionpic = new TranslateTransition(Duration.seconds(2), s);
            transitionpic.setToX(r1.getLayoutX());
            transitionpic.play();
            s.setX(0);
            stick.setLayoutX(r2.getWidth());
            Random random = new Random();
            int minValue = 40;
            int maxValue = 70;
            int randomInt = random.nextInt((maxValue - minValue) + 1) + minValue;
            r1.setWidth(randomInt);
            r1.setTranslateY(500);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(2), r1);
            transition2.setToY(0);
            transition2.play();
            r1.setLayoutX(200);
            t = 2;
        } else {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), r1);
            transition.setToX(0);
            transition.play();
            r1.setLayoutX(0);
            TranslateTransition transitionpic = new TranslateTransition(Duration.seconds(2), s);
            transitionpic.setToX(r2.getLayoutX());
            transitionpic.play();
            s.setX(0);
            stick.setLayoutX(r1.getWidth());
            Random random = new Random();
            int minValue = 40;
            int maxValue = 70;
            int randomInt = random.nextInt((maxValue - minValue) + 1) + minValue;
            r2.setWidth(randomInt);
            r2.setTranslateY(500);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(2), r2);
            transition2.setToY(0);
            transition2.play();
            r2.setLayoutX(200);
            t = 1;

        }

    }
}
