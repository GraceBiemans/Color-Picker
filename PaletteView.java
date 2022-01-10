// Grace Biemans
// geb965
// 11279874
// Assignment 1

package com.example.assignment1;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PaletteView extends Pane {

    Circle circle1;
    Circle circle2;
    Circle circle3;

    ColorPalette paletteColors;

    /**
     * Constructor for the class
     * @param c: The colors that will be in the palette
     */
    public PaletteView(ColorPalette c) {
        if (c != null) {
            paletteColors = c;
        }
        else {
            paletteColors = new ColorPalette();
        }

        circle1 = new Circle();
        circle1.setCenterX(100.0f);
        circle1.setCenterY(100.0f);
        circle1.setRadius(50.0f);
        circle1.setFill(paletteColors.color1);

        circle2 = new Circle();
        circle2.setCenterX(100.0f);
        circle2.setCenterY(100.0f);
        circle2.setRadius(50.0f);
        circle2.setFill(paletteColors.color2);

        circle3 = new Circle();
        circle3.setCenterX(100.0f);
        circle3.setCenterY(100.0f);
        circle3.setRadius(50.0f);
        circle3.setFill(paletteColors.color3);

        HBox hbox = new HBox(circle1, circle2, circle3);
        hbox.setAlignment(Pos.CENTER);

        this.getChildren().add(hbox);
    }
}
