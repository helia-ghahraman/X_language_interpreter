package Interpreter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

public class write extends Application {
    File file=null;
    @Override
    public void start(Stage stage) throws Exception {
        Button compilebtn = new Button("compile");
        compilebtn.setTextFill(Color.web("#eb6721"));
        Label showLb = new Label("choose a name for your file:  ");
        showLb.setFont(new Font("Fonts/BAHNSCHRIFT.TTF",30));
        TextField textname = new TextField();
        Button okbtn = new Button("ok");
        TextArea grammer = new TextArea();
        grammer.setMaxSize(300, 400);
        grammer.setMinSize(300, 400);
        AtomicReference<String> code = new AtomicReference<>(new String());
        ////////////////
        EventHandler<ActionEvent> event3 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        int sw=0;
                        String userInput=textname.getText();
                        if (userInput.length()>1) {
                            file = new File("src//Interpreter//TextFiles//" + userInput);
                            showLb.setText(userInput + "  is successfully made!");
                                showLb.setTextFill(Color.web("#1bc226"));
                        }
                    }
                };
        okbtn.setOnAction(event3);

        ///////////
        compilebtn.setOnAction(actionEvent -> {
            code.set(grammer.getText());
            try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("src//Interpreter//TextFiles//" + textname.getText() + ".txt")))) {
                out.println(grammer.getText());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            Graphics.path = String.format("src//Interpreter//TextFiles//" + textname.getText() + ".txt");
            System.out.println(Graphics.path);
            try {
                Program program = new Program();
                Result result=new Result();
                result.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(400);
        vbox.setLayoutY(50);
        vbox.getChildren().addAll(showLb, textname, okbtn, grammer, compilebtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 600, 400);
        stage.setScene(scene1);
//        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
}
