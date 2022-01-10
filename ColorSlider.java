package com.example.assignment1;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ColorSlider extends Pane {

    public Slider slider;
    private Label value;

    /**
     * Constructor for the class
     * @param title: The text that will identify the slider (slider title)
     */
    public ColorSlider(String title) {

        slider = new Slider();
        slider.setMin(0);
        slider.setMax(255);
        slider.setValue(50);
        Label title1 = new Label(title);

        value = new Label(Integer.toString((int)this.getValue()));

        title1.setMinWidth(40); // lines up the sliders

        HBox hbox = new HBox(title1, slider, value);
        hbox.setSpacing(10);

        this.getChildren().add(hbox);

    }

    /**
     * Accessor for the slider value
     * @return: The value that the slider shows
     */
    public double getValue() {
        return slider.getValue();
    }

    /**
     * Mutator for the slider value
     * @param newVal: What the slider value will be set to
     */
    public void setValue(double newVal) {
        this.value.setText(Integer.toString((int)newVal));
    }

}
