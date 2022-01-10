package com.example.assignment1;

import javafx.scene.paint.Color;

public class ColorPalette {

    Color color1;
    Color color2;
    Color color3;

    int counter = 1;    // keep track of which palette circle needs to be filled

    /**
     * Constructor for the class
     */
    public ColorPalette() {
        color1  = Color.WHITE;
        color2 = Color.WHITE;
        color3 = Color.WHITE;
    }

    /**
     * Constructor for the class - created with palette colors set
     * @param c1: color to be added to the palette
     * @param c2: color to be added to the palette
     * @param c3: color to be added to the palette
     */
    public ColorPalette(Color c1, Color c2, Color c3) {
        color1 = c1;
        color2 = c2;
        color3 = c3;
    }

    /**
     * Adds a color c to the palette
     * @param c: The color to be added to the palette
     */
    public void addColor(Color c) {
        if (counter == 1) {
            color1 = c;
            counter ++;
        }
        else if (counter == 2) {
            color2 = c;
            counter ++;
        }
        else if (counter == 3) {
            color3 = c;
            counter = 1;
        }
    }
}
