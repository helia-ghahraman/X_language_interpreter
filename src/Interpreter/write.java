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
        Button back=new Button("back");
        Button compilebtn = new Button("compile");
        compilebtn.setTextFill(Color.web("#eb6721"));
        Label showLb = new Label("1. choose a name for your file:  ");
        Label writeFileLb=new Label("2. Write your file:");
        TextField textname = new TextField();
        Button savebtn = new Button("Save");
        savebtn.setTextFill(Color.web("#1bc226"));
        TextArea grammer = new TextArea();
        grammer.setMaxSize(400, 300);
        grammer.setMinSize(400, 300);
        AtomicReference<String> code = new AtomicReference<>(new String());
      //***********************************
        EventHandler<ActionEvent> event3 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        int sw=0;
                        String userInput=textname.getText();
                        if (userInput.length()>=1) {
                            file = new File("src//Interpreter//TextFiles//" + userInput);
                            showLb.setText(userInput + "  is successfully made!");
                                showLb.setTextFill(Color.web("#1bc226"));
                        }
                    }
                };
        savebtn.setOnAction(event3);
    //*************************************
        EventHandler<ActionEvent> event4 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        Print.builder.setLength(0);
                        Result.result.clear();
                        Result.errors.clear();
                        Graphics graphics=new Graphics();
                        try {
                            graphics.start(stage);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                };
       back.setOnAction(event4);
       //****************************************
        compilebtn.setOnAction(actionEvent -> {
            code.set(grammer.getText());
            try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("src//Interpreter//TextFiles//" + textname.getText() + ".txt")))) {
                out.println(grammer.getText());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            Graphics.path = String.format("src//Interpreter//TextFiles//" + textname.getText() + ".txt");
            try {
                Result result=new Result();
                result.start(stage);
                Program program = new Program();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //**************************************
        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(400);
        vbox.setLayoutY(30);
        vbox.getChildren().addAll(showLb, textname, savebtn,writeFileLb, grammer, compilebtn,back);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 600, 400);
        stage.setScene(scene1);
        stage.show();
    }
}
