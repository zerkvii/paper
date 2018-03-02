package sample;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private HashMap<String, String> record;
    @FXML

    private GridPane loginpane;
    @FXML
    private JFXPasswordField password;

    @FXML
    private Pane imgpane;

    @FXML
    private Label copyrights;

    @FXML
    private JFXButton sign;

    @FXML
    private JFXButton login;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField username;

    @FXML
    void log(ActionEvent event) {
        String usertemp = username.getText();
        String passtemp = password.getText();
        if (check(usertemp, passtemp)) {
            System.out.println("welcome");
        } else {
            System.out.println("retry");
        }

    }


    @FXML
    void enterlog(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) log(new ActionEvent());
    }

    @FXML
    void signdialog(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认信息");
        alert.setHeaderText("All Rights Reserved for Bamboo\n"+
                           "All for Trial\n");
        alert.setContentText("是否接受?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //access login rights
        record = new HashMap<>();
        record.put("zerk", "a147258369");
        //login validator
        RequiredFieldValidator validator = new RequiredFieldValidator();
        username.getValidators().add(validator);
        validator.setMessage("请输入一个用户名");
        username.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) username.validate();
            }
        });
        try {
            validator.setIcon(new ImageView(new Image(getClass().getResourceAsStream("../pics/sweat1.png"))));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean check(String usr, String code) {
        if (record.containsKey(usr) && record.get(usr).equals(code)) return true;
        else return false;

    }
}
