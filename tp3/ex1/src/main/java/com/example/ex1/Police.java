package com.example.ex1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Police {
    @FXML
    TextField text;
    @FXML
    TextField size;
    @FXML
    ListView<String> police;

    public void addSubject(){
        int sized = Integer.parseInt(size.getText());
        String policeType = police.getSelectionModel().getSelectedItem();
        text.setFont(Font.font(policeType, FontWeight.NORMAL, sized));

    }
}