package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../styled/mainpage.fxml"));
        Parent root =loader.load();
        Mainpage controller=loader.getController();
        controller.setStage(primaryStage);
        primaryStage.setTitle("welcome");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../pics/ico.png")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
