// Grace Biemans
// geb965
// 11279874
// Assignment 1

package com.example.assignment1;

import javafx.scene.control.ListCell;

public class PaletteCell extends ListCell<ColorPalette> {


    public void updateItem(ColorPalette item, boolean empty) {
        super.updateItem(item, empty);
        PaletteView pv = new PaletteView(item);
        setGraphic(pv);
    }
}
