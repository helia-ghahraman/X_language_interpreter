package Interpreter;

import Interpreter.write;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;
import javafx.stage.FileChooser;

public class Graphics extends Application {
    static TextArea result = new TextArea();
    static String path;
    static int runSw = 0;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("HAY.Intellij");
        stage.setWidth(1050);
        stage.setHeight(750);
        stage.setX(200);
        stage.setY(20);
       try {
            FileChooser fil_chooser = new FileChooser();
            Label label = new Label("-Choose a text file,then click Compile...or you can write on your own-");
            label.setTextFill(Color.web("#595556"));
            label.setStyle("-fx-font-size: 15px");
            Button button = new Button("Choose File");
            button.setTextFill(Color.web("#222224"));
            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            // get the file selected
                            File file = fil_chooser.showOpenDialog(stage);
                            path = file.getAbsolutePath();
                            System.out.println(path);
                            runSw = 1;
                            if (file != null) {
                                if (!path.endsWith(".txt")) {
                                    label.setText("This is not a text file!Try again!");
                                     label.setTextFill(Color.web("#595556"));}
                                else label.setText(path + "  selected");
                            }
                        }
                    };
           button.setOnAction(event);
           Button button2 = new Button("Compile");
           button2.setTextFill(Color.web("#222224"));
           button2.setStyle("-fx-background-color:#d7d7db ");
           EventHandler<ActionEvent> event2 =
                   new  EventHandler<ActionEvent>() {
                       public void handle(ActionEvent e) {
                           if (runSw == 1) {
                               try {
                                   Program program = new Program();
                               } catch (IOException ioException) {
                                   ioException.getMessage();
                               }
                           } else {
                               label.setText("You have NOT chosen a file yet!");
                           }
                       }
                   };
           button2.setOnAction(event2);
           //////////////
           Button button3 = new Button("write my file");
           button3.setTextFill(Color.web("#222224"));
           button3.setStyle("-fx-background-color:#d7d7db ");
           button3.setOnAction(actionEvent -> {
               try {
                   write write = new write();
                   write.start(stage);
               } catch (Exception exception) {
                   exception.printStackTrace();
               }
           });
           Pane root = new Pane();
           root.setStyle("-fx-background-image: url('https://image.freepik.com/free-vector/white-minimal-hexagons-background_79603-1453.jpg'); -fx-background-size: 100% 100%");
           VBox vbox = new VBox(30);
           vbox.setAlignment(Pos.CENTER);
           vbox.setLayoutX(430);
           vbox.setLayoutY(220);
           vbox.getChildren().addAll(label, button, button2, button3,result);
            root.getChildren().add(vbox);
            Scene scene1 = new Scene(root,600,400);
            stage.setScene(scene1);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    }
