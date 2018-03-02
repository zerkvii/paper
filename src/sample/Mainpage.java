package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by zerk on 2017/3/28.
 */
public class Mainpage implements Initializable {

    private HashMap<String, String> detail;
    @FXML
    private Label toprightlabel;
    @FXML
    private AnchorPane loadchoicepane;
    ArrayList<VBox> popup;

    private JFXNodesList linetool;

    private JFXButton thumb1;
    private JFXButton thumb2;
    private JFXButton thumb3;
    private JFXButton thumb4;
    private File file;


    @FXML
    private AnchorPane choosebuttonpanel;
    @FXML
    private TextArea text;

    @FXML
    private AnchorPane righttoolpane;

    @FXML
    private AnchorPane toppane;

    @FXML
    private JFXButton start;
    @FXML
    private VBox startmenu;

    @FXML
    private VBox bendmenu;

    @FXML
    private VBox pressmenu;

    @FXML
    private VBox pullmenu;

    @FXML
    private VBox othermenu;
    private Stage stage;
    private String currentfilepath = null;
    @FXML
    private javafx.scene.control.Label detaillab;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void choosesteel(ActionEvent event) throws IOException {
        Parent choosesteelpage = FXMLLoader.load(getClass().getResource("../styled/choosesteel.fxml"));
        Scene chosensteel = new Scene(choosesteelpage);
        Stage thisstage = new Stage();
        thisstage.setScene(chosensteel);
        thisstage.show();
    }

    @FXML
    void checksteel(ActionEvent event) throws IOException {
        Parent checksteelpage = FXMLLoader.load(getClass().getResource("../styled/checksteel.fxml"));
        Scene checkedsteel = new Scene(checksteelpage);
        Stage thisstage = new Stage();
        thisstage.setScene(checkedsteel);
        thisstage.show();
    }

    //menu1
    @FXML
    void createfile(ActionEvent event) {
        if (text.getText().toString().length() != 0) {
            savefile(new ActionEvent());
            text.clear();
            currentfilepath = null;
        } else {
            text.clear();
            currentfilepath = null;
        }
    }

    @FXML
    void openfile(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
//        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        file = fileChooser.showOpenDialog(stage);
        currentfilepath = file.toString();
        if (file != null) {
            try {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader read = new BufferedReader(isr);
                String tempString = null;
                while ((tempString = read.readLine()) != null) {
                    text.appendText(tempString + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @FXML
    void savefile(ActionEvent event) {
        if (currentfilepath == null) {
            savefileas(new ActionEvent());
        } else {
            String savecontent = text.getText().toString();
            String[] savelines = savecontent.split("\n");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(currentfilepath, false));
                for (String line : savelines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("-1");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void savefileas(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        File dest = fileChooser.showSaveDialog(stage);
//        System.out.println(dest.toString());
        if (file != null) {
            String savecontent = text.getText().toString();
            String[] savelines = savecontent.split("\n");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dest, false));
                for (String line : savelines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //menu2
//menu3
//menu4
//menu5
    @FXML
    void visitsource(ActionEvent event) {
        URI uri = URI.create("https://github.com/zerkvi/mechanixs");
        visitpage(uri);
    }

    @FXML
    void feedback(ActionEvent event) {
        URI uri = URI.create("http://www.cnblogs.com/bambooworkshop/p/6739373.html");
        visitpage(uri);
    }

    @FXML
    void contactme(ActionEvent event) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.mail(new URI("mailto:zerkvii@gmail.com"));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setHeaderText("本机无默认邮件系统或者不支持邮件组件");
            alert.setContentText("请手动联系zerkvii@gmail.com");
            alert.showAndWait();
        }
    }

    public void visitpage(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                // 获取当前系统桌面扩展
                Desktop dp = Desktop.getDesktop();
                // 判断系统桌面是否支持要执行的功能
                if (dp.isSupported(Desktop.Action.BROWSE)) {
                    // 获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //endmenu
    @FXML
    void showcheck(MouseEvent event) {
        for (VBox v : popup) {
            v.setDisable(true);
            v.setVisible(false);
        }

    }

    @FXML
    void showchoose(MouseEvent event) {
        for (VBox v : popup) {
            v.setDisable(true);
            v.setVisible(false);
        }
    }

    @FXML
    void showbend(MouseEvent event) {
        for (VBox v : popup) {
            if (v.getId().equals("bendmenu")) {
                v.setDisable(false);
                v.setVisible(true);
            } else {
                v.setDisable(true);
                v.setVisible(false);
            }

        }
    }

    @FXML
    void showother(MouseEvent event) {
        for (VBox v : popup) {
            if (v.getId().equals("othermenu")) {
                v.setDisable(false);
                v.setVisible(true);
            } else {
                v.setDisable(true);
                v.setVisible(false);
            }

        }
    }

    @FXML
    void showpress(MouseEvent event) {
        for (VBox v : popup) {
            if (v.getId().equals("pressmenu")) {
                v.setDisable(false);
                v.setVisible(true);
            } else {
                v.setDisable(true);
                v.setVisible(false);
            }

        }
    }

    @FXML
    void showpull(MouseEvent event) {
        for (VBox v : popup) {
            if (v.getId().equals("pullmenu")) {
                v.setDisable(false);
                v.setVisible(true);
            } else {
                v.setDisable(true);
                v.setVisible(false);
            }

        }

    }

    @FXML
    void showstart(MouseEvent event) {
        for (VBox v : popup) {
            if (v.getId().equals("startmenu")) {
                v.setDisable(false);
                v.setVisible(true);
            } else {
                v.setDisable(true);
                v.setVisible(false);
            }

        }

    }

    //detailshow
    @FXML
    void shownew(MouseEvent event) {
        showdetail("新建");
    }

    @FXML
    void showopen(MouseEvent event) {
        showdetail("打开");

    }

    @FXML
    void showsave(MouseEvent event) {
        showdetail("保存");
    }

    @FXML
    void showsaveas(MouseEvent event) {
        showdetail("另存为");
    }

    @FXML
    void showsinglesq(MouseEvent event) {
        showdetail("单");
    }

    @FXML
    void showdoublesq(MouseEvent event) {
        showdetail("双");
    }

    @FXML
    void showTsq(MouseEvent event) {
        showdetail("Ｔ");

    }

    @FXML
    void showreverseLsq(MouseEvent event) {
        showdetail("倒");

    }

    @FXML
    void shownormal(MouseEvent event) {
        showdetail("普");

    }

    @FXML
    void showspiral(MouseEvent event) {
        showdetail("螺");

    }

    @FXML
    void showsym(MouseEvent event) {
        showdetail("对");

    }

    @FXML
    void showaxial(MouseEvent event) {
        showdetail("轴");

    }

    @FXML
    void shownonsym(MouseEvent event) {
        showdetail("不");

    }

    @FXML
    void showmirror(MouseEvent event) {
        showdetail("镜");

    }

    @FXML
    void shownonmirror(MouseEvent event) {
        showdetail("非镜");

    }

    @FXML
    void showori(MouseEvent event) {
        showdetail("访问");

    }

    @FXML
    void showfeedback(MouseEvent event) {
        showdetail("问题");

    }

    @FXML
    void showauthor(MouseEvent event) {
        showdetail("联系");

    }

    void showdetail(String text) {

        detaillab.setText(detail.get(text));
    }

    void setToprightlabel(String text) {
        this.toprightlabel.setText(text);
    }
    void setLoadchoicepane(Node node){
        loadchoicepane.getChildren().setAll(node);
    }
    //settext
    void appendtext(String[] out){
        for(String e:out) {
            text.appendText(e.concat("\n"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        detail = new HashMap<String, String>();
        try {
//            InputStream is = new FileInputStream("src/information/detail.txt");
            InputStream is = getClass().getResourceAsStream("../information/detail");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));
            String str = null;
            while (true) {
                str = reader.readLine();
                if (str != null) {
                    String[] collections = str.split("：");
                    detail.put(collections[0], collections[1]);
//                    System.out.println(collections[0]+"get"+collections[1]);
                } else break;
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //djjxload
        //            loadchoicepane.getChildren().setAll((Collection<? extends Node>) FXMLLoader.load(getClass().getResource("../styled/loaddjjx.fxml")));

        try {
            Node node;
            node = (Node) FXMLLoader.load(getClass().getResource("../styled/loaddjjx.fxml"));
            loadchoicepane.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //choosepanelload
        //            loadchoicepane.getChildren().setAll((Collection<? extends Node>) FXMLLoader.load(getClass().getResource("../styled/loaddjjx.fxml")));
//            node = (Node) FXMLLoader.load(getClass().getResource("../styled/choosepanel.fxml"));

        try {
            Node node;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../styled/choosepanel.fxml"));
            node = (Node) loader.load();
            choosebuttonpanel.getChildren().setAll(node);
            Choosepanel choosepanel = loader.getController();
            choosepanel.getcontroller(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        popupbutton
        ArrayList<JFXButton> toolist = new ArrayList<JFXButton>();
        thumb1 = new JFXButton("编辑");
        thumb2 = new JFXButton("插入");
        thumb3 = new JFXButton("重写");
        thumb4 = new JFXButton("后退");
        toolist.add(thumb1);
        toolist.add(thumb2);
        toolist.add(thumb3);
        toolist.add(thumb4);
        linetool = new JFXNodesList();
        for (JFXButton bt : toolist) {
            bt.setButtonType(JFXButton.ButtonType.RAISED);
            bt.getStyleClass().addAll("animated-option-button", "animated-option-sub-button");
            linetool.addAnimatedNode(bt);
        }
        linetool.setSpacing(10d);
        righttoolpane.getChildren().add(linetool);
        AnchorPane.setLeftAnchor(linetool, righttoolpane.getPrefWidth() / 2);
//        above is tooline
        popup = new ArrayList<VBox>();
        popup.add(startmenu);
        popup.add(bendmenu);
        popup.add(pressmenu);
        popup.add(pullmenu);
        popup.add(othermenu);
        for (VBox v : popup) {
            v.setDisable(true);
            v.setVisible(false);
        }
        file = new File("../text/init.txt");
    }

//    left tool


}

