package com.example.ex2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Color {
    private static int nc = 10;

    @FXML
    Circle circle;
    @FXML
    ListView choices;

    public void initialize(){
        choices.getSelectionModel().select(0);
        changeColor();
    }

    public void changeColor(){
        Rectangle color = (Rectangle) choices.getSelectionModel().getSelectedItem();
        circle.setFill(color.getFill());
    }

    public void left(){
        int index = choices.getSelectionModel().getSelectedIndex() - 1;
        index = (index + nc) % nc;
        choices.getSelectionModel().select(index);
        changeColor();
    }

    public void right(){
        int index = choices.getSelectionModel().getSelectedIndex();
        index = (index + 1) % nc;
        choices.getSelectionModel().select(index);
        changeColor();
    }

    public void quit(){
        System.exit(0);
    }
}
