package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/4/27.
 */
public class Loaddjjx1 implements Initializable {
    //UTIL
    private Choosepanel choosepanel;
    private model model_;
    //compute moment
    private std collection = new std();
    private String safe_c, concret_c, steel_c;
    private double square_, width_, height_, distance_, moment_;
    @FXML
    private JFXComboBox<Label> safeclass;

    @FXML
    private JFXComboBox<Label> concreteclass;

    @FXML
    private JFXComboBox<Label> steelclass;

    @FXML
    private JFXTextField square;

    @FXML
    private JFXTextField moment;

    @FXML
    private JFXTextField squarewidth;

    @FXML
    private JFXTextField squareheight;

    @FXML
    private JFXTextField distancetextfield;

    //getcontroller
    void getcontroller(Choosepanel choosepanel) {
        this.choosepanel = choosepanel;
    }

    @FXML
    void compute(ActionEvent event) throws IOException {
        //获取参数
        concret_c = concreteclass.getSelectionModel().getSelectedItem().getText();
        safe_c = safeclass.getSelectionModel().getSelectedItem().getText();
        steel_c = steelclass.getSelectionModel().getSelectedItem().getText();
        square_ = Double.valueOf(square.getText());
        height_ = Double.valueOf(squareheight.getText());
        width_ = Double.valueOf(squarewidth.getText());
        distance_ = Double.valueOf(distancetextfield.getText());
//        System.out.println(square_);
//        System.out.println(safe_c+" "+concret_c+" "+steel_c+" "+square_+" "+height_+" "+width_+" "+distance_+" ");
        //获取标准值
        double gama0_ = collection.safe_.get(safe_c);
        double alpha1 = collection.concret_.get(concret_c)[0];
        double beta1 = collection.concret_.get(concret_c)[1];
        double fc = collection.concret_.get(concret_c)[2];
        double ft = collection.concret_.get(concret_c)[3];
        double ecu = collection.concret_.get(concret_c)[4];
        double fyl = collection.steel_.get(steel_c)[0];
        double es = collection.steel_.get(steel_c)[2];
        //开始计算
        double h0 = height_ - distance_,
                eb = beta1 / (1 + fyl / (es * 100000 + ecu)),
                e = square_ * fyl / (alpha1 * fc * width_ * h0);

        if (e <= eb) {
            moment_ = alpha1 * fc * width_ * h0 * h0 * e * (1 - 0.5 * e) / gama0_;
//             System.out.println(moment_);
            String[] out = new String[31];
            DecimalFormat df = new DecimalFormat("0.000");

            model_.djjx1(out);
            out[6] = out[6].concat(String.valueOf(width_)).concat(" mm");
            out[7] = out[7].concat(String.valueOf(height_)).concat(" mm");
            out[8] = out[8].concat(String.valueOf(distance_)).concat(" mm");
            out[9] = out[9].concat(String.valueOf(square_)).concat(" mm2");
            out[12] = out[12].concat(String.valueOf(gama0_));
            out[13] = out[13].replace("C35", concret_c);
            out[14] = out[14].concat(String.valueOf(alpha1));
            out[15] = out[15].concat(String.valueOf(beta1));
            out[16] = out[16].concat(String.valueOf(fc)).concat(" N/mm2");
            out[17] = out[17].concat(String.valueOf(ft)).concat(" N/mm2");
            out[18] = out[18].concat(String.valueOf(ecu));
            out[19] = out[19].replace("HRB400", steel_c);
            out[20] = out[20].concat(String.valueOf(fyl)).concat(" N/mm2");
            out[21] = out[21].concat(String.valueOf(es)).concat("×100000N/mm2");
            out[24] = out[24].concat(String.valueOf(h0)).concat(" mm");
            out[26] = out[26].concat(String.valueOf(df.format(eb)));
            out[27] = out[27].concat(String.valueOf(df.format(e)));
            out[30] = out[30].concat(String.valueOf(df.format(moment_ / 1000000))).concat(" kN.m");
            choosepanel.appendoutput(out);
            moment.setText(String.valueOf(df.format(moment_ / 1000000)));

        } else {
            moment.setText("参数不合理");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        safeclass.setPromptText("一级");
//        steelclass.setPromptText("HPB300");
//        concreteclass.setPromptText("C15");

        Label[] concret = new Label[14];
        for (int i = 0; i < 14; i++) {
            concret[i] = new Label("C" + String.valueOf(15 + i * 5));
            concreteclass.getItems().add(concret[i]);
        }
        safeclass.getItems().add(new Label("一级"));
        safeclass.getItems().add(new Label("二级"));
        safeclass.getItems().add(new Label("三级"));
        safeclass.getItems().add(new Label("地震设计"));
        steelclass.getItems().add(new Label("HPB300"));
        steelclass.getItems().add(new Label("HRB335"));
        steelclass.getItems().add(new Label("HRBF335"));
        steelclass.getItems().add(new Label("HRB400"));
        steelclass.getItems().add(new Label("HRBF400"));
        steelclass.getItems().add(new Label("RRB400"));
        steelclass.getItems().add(new Label("HRB500"));
        steelclass.getItems().add(new Label("HRBF500"));
        safeclass.getSelectionModel().select(2);
        steelclass.getSelectionModel().select(2);
        concreteclass.getSelectionModel().select(3);
        //model init
        this.model_ = new model();
    }
}
