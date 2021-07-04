package Interpreter;

import Interpreter.write;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;
import java.util.concurrent.TimeUnit;

import javafx.stage.FileChooser;

public class Graphics extends Application {
    static String path;
    static int runSw = 0;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("HAY.Intellij");
        stage.setResizable(false);
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.setX(200);
        stage.setY(20);
       try {
            FileChooser fil_chooser = new FileChooser();
            Label chooseLB = new Label("-Choose a text file,then click Compile...or you can write on your own-");
            chooseLB.setTextFill(Color.web("#595556"));
            chooseLB.setStyle("-fx-font-size:20px");
            Button chooseBtn = new Button("Choose File");
            chooseBtn.setTextFill(Color.web("#222224"));
            Button aboutUs=new Button("About us");
            aboutUs.setTextFill(Color.web("#e3c91e"));
            aboutUs.setStyle("-fx-background-color: #1d5dde");
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            File file = fil_chooser.showOpenDialog(stage);
                            path = file.getAbsolutePath();
                            runSw = 1;
                            if (file != null) {
                                if (!path.endsWith(".txt")) {
                                    chooseLB.setText("This is not a text file!Try again!");
                                    chooseLB.setTextFill(Color.web("#595556"));}
                                else {
                                    chooseLB.setText(path + "  selected");
                                    chooseLB.setTextFill(Color.web("#87147e"));
                                }
                            }
                        }
                    };
           chooseBtn.setOnAction(event);
           //***************************************************
           Button compileB = new Button("Compile");
           compileB.setTextFill(Color.web("#eb6721"));
           EventHandler<ActionEvent> event2 =new  EventHandler<ActionEvent>() {
                       public void handle(ActionEvent e) {
                           if (runSw == 1) {
                               try {
                                   Result result=new Result();
                                   result.start(stage);
                                   Program program = new Program();
                               } catch (Exception ioException) {
                                   ioException.printStackTrace();
                               }
                           } else {
                               chooseLB.setText("You have NOT chosen a file yet!");
                               chooseLB.setTextFill(Color.web("#e6173d"));
                           }
                       }
                   };
           compileB.setOnAction(event2);
           //****************************************
           Button writeBtn = new Button("Write File");
           writeBtn.setTextFill(Color.web("#222224"));
           writeBtn.setOnAction(actionEvent -> {
               try {
                   write write = new write();
                   write.start(stage);
               } catch (Exception exception) {
                   exception.printStackTrace();
               }
           });
           //********************************************
           EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
                       public void handle(ActionEvent e) {
                            AboutUs aboutUs1=new AboutUs();
                           try {
                               aboutUs1.start(stage);
                           } catch (Exception exception) {
                               exception.printStackTrace();
                           }
                       }
                   };
           aboutUs.setOnAction(event3);
           Pane root = new Pane();
           root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
           VBox vbox = new VBox(30);
           vbox.setAlignment(Pos.CENTER);
           vbox.setLayoutX(340);
           vbox.setLayoutY(220);
           vbox.getChildren().addAll(chooseLB, chooseBtn, compileB, writeBtn,aboutUs);
            root.getChildren().add(vbox);
            Scene scene1 = new Scene(root, 500, 300);
            stage.setScene(scene1);
           stage.alwaysOnTopProperty();
           stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    }
