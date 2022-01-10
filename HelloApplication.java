// Grace Biemans
// geb965
// 11279874
// Assignment 1

package com.example.assignment1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private ObservableList<ColorPalette> listItems;

    private Circle colorPicker; // the large color swatch

    private ColorSlider redSlider;
    private ColorSlider greenSlider;
    private ColorSlider blueSlider;

    private PaletteView palette;
    private ColorPalette paletteColors;

    private Color currentColor; // store the current color set by the sliders

    @Override
    public void start(Stage stage) {

        // setting up the color swatch circle
        colorPicker = new Circle();
        colorPicker.setCenterX(100.0f);
        colorPicker.setCenterY(100.0f);
        colorPicker.setRadius(100.0f);

        // TODO sliders are not centered
        redSlider = new ColorSlider("Red:");
        redSlider.slider.valueProperty().addListener((observable, oldValue, newValue) -> setColor());

        greenSlider = new ColorSlider("Green:");
        greenSlider.slider.valueProperty().addListener((observable, oldValue, newValue) -> setColor());

        blueSlider = new ColorSlider("Blue:");
        blueSlider.slider.valueProperty().addListener((observable, oldValue, newValue) -> setColor());

        setColor(); // initialize currentColor - in case addToPal button if pressed before sliders are moved from default

        // the HBox that holds all the slider info
        VBox slidersHBox = new VBox(redSlider, greenSlider, blueSlider);
        slidersHBox.setSpacing(10);

        paletteColors = new ColorPalette();
        palette = new PaletteView(null);

        // "Add to Palette" Button
        Button paletteBtn = new Button("Add to Palette");
        paletteBtn.setOnAction(actionEvent -> addToPalHandler());

        // "Add to List" Button
        Button addListBtn = new Button("Add to List");
        addListBtn.setOnAction(actionEvent -> addListHandler());

        // Left half of the widget (VBox)
        VBox leftBox = new VBox(colorPicker, slidersHBox, paletteBtn, palette, addListBtn);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(15);

        // The list on the right side of the widget
        ListView<ColorPalette> paletteList = new ListView<>();
        paletteList.setCellFactory(listItem -> new PaletteCell());
        listItems = FXCollections.observableArrayList();
        paletteList.setItems(listItems);

        // container for everything
        HBox bigContainer = new HBox(leftBox, paletteList);
        bigContainer.setAlignment(Pos.CENTER);
        bigContainer.setSpacing(10);

        Scene scene = new Scene(bigContainer, 650, 525);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Color of the swatch and the necessary slider Labels will be changed to new values
     */
    private void setColor() {
        currentColor = Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue());
        colorPicker.setFill(currentColor); // update the swatch color
        redSlider.setValue(redSlider.getValue());
        greenSlider.setValue(greenSlider.getValue());
        blueSlider.setValue(blueSlider.getValue());
    }

    /**
     * Handler method: Adds the swatch color to the palette
     */
    private void addToPalHandler() {
        palette.paletteColors.addColor(currentColor);   // add current color to the PaletteView palette and update its circles with the new palette
        palette.circle1.setFill(palette.paletteColors.color1);
        palette.circle2.setFill(palette.paletteColors.color2);
        palette.circle3.setFill(palette.paletteColors.color3);
        paletteColors.addColor(currentColor);   // add current color to color palette
    }

    /**
     * Handler method: Adds the ColorPalette to the palette list
     */
    private void addListHandler() {
        ColorPalette newColors = new ColorPalette(paletteColors.color1, paletteColors.color2, paletteColors.color3);
        PaletteView newPalette = new PaletteView(newColors);
        listItems.add(newPalette.paletteColors);
    }


    public static void main(String[] args) {
        launch();
    }
}

