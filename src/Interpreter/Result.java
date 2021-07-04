package Interpreter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;

public class Result extends Application {
    static TextArea errors=new TextArea();
    static TextArea result = new TextArea();
    @Override
    public void start(Stage stage) throws Exception {
        Label errorLb=new Label("Errors:");
        errorLb.setTextFill(Color.web("#c22d0c"));
        errorLb.setStyle("-fx-font-size:20px");
        errors.setDisable(true);
        errors.setMaxSize(500, 100);
        errors.setMinSize(500, 100);
        Label resultLb=new Label("Result:");
        resultLb.setTextFill(Color.web("#595556"));
        resultLb.setStyle("-fx-font-size:20px");
        result.setMaxSize(500, 300);
        result.setMinSize(500, 300);
        Button back=new Button("back");
        EventHandler<ActionEvent> event4 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        Program.lineNumber=0;
                        Print.builder.setLength(0);
                        result.clear();
                        errors.clear();
                        Graphics graphics=new Graphics();
                        try {
                            graphics.start(stage);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                };
        back.setOnAction(event4);

        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(320);
        vbox.setLayoutY(30);
        vbox.getChildren().addAll(resultLb,result,errorLb,errors,back);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 500, 300);
        stage.setScene(scene1);
        stage.show();

    }
}
