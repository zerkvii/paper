package sample;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by zerk on 2017/4/17.
 */
public class Choosesteel implements Initializable {

    @FXML
    private JFXComboBox<Label> dchoosebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dchoosebox.getItems().add(new Label("6"));
        dchoosebox.getItems().add(new Label("6.5"));
        dchoosebox.getItems().add(new Label("8"));
        dchoosebox.getItems().add(new Label("8.2"));
        dchoosebox.getItems().add(new Label("10"));
        dchoosebox.getItems().add(new Label("12"));
        dchoosebox.getItems().add(new Label("14"));
        dchoosebox.getItems().add(new Label("16"));
        dchoosebox.getItems().add(new Label("18"));
        dchoosebox.getItems().add(new Label("20"));
        dchoosebox.getItems().add(new Label("22"));
        dchoosebox.getItems().add(new Label("25"));
        dchoosebox.getItems().add(new Label("28"));
        dchoosebox.getItems().add(new Label("32"));
        dchoosebox.getItems().add(new Label("36"));
        dchoosebox.getItems().add(new Label("40"));
        dchoosebox.getItems().add(new Label("50"));

        dchoosebox.setPromptText("请选择直径");
    }
}
