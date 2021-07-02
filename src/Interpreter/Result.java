package Interpreter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

public class Result extends Application {
    static TextArea result = new TextArea();
    @Override
    public void start(Stage stage) throws Exception {
        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(400);
        vbox.setLayoutY(200);
        vbox.getChildren().addAll(result);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 600, 400);
        stage.setScene(scene1);
        stage.show();

    }
}
