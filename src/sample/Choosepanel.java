package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Choosepanel implements Initializable {
    private Mainpage oricontroller;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void areacompute(ActionEvent event) {
        oricontroller.setToprightlabel("计算面积");
        try {
            Node node;
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../styled/loaddjjx.fxml"));
            node = (Node) loader.load();
            oricontroller.setLoadchoicepane(node);
            Loaddjjx loaddjjx_=loader.getController();
            loaddjjx_.getcontroller(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void bearcompute(ActionEvent event) {
        oricontroller.setToprightlabel("计算承载力");
        try {
            Node node;
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../styled/loaddjjx1.fxml"));
            node = (Node) loader.load();
            oricontroller.setLoadchoicepane(node);
            Loaddjjx1 loaddjjx1_=loader.getController();
            loaddjjx1_.getcontroller(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void appendoutput(String[] output){
        this.oricontroller.appendtext(output);
    }
    void getcontroller(Mainpage oricontroller){
        this.oricontroller=oricontroller;
    }

}
