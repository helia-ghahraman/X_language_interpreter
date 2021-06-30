package Interpreter2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class Graphics extends Application {
    static String path;
    static boolean runSw = false;

    @Override
    public void init() throws Exception {
        System.out.println("Start Graphics");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("HAY.Intellij");
        stage.setWidth(1000);
        stage.setHeight(700);
        stage.setX(200);
        stage.setY(20);
        // launch the application
        try {
            // create a File chooser
            FileChooser fil_chooser = new FileChooser();
            // create a Label
            Label label = new Label("-Choose a text file, then click RUN-");
            label.setTextFill(Color.web("#643969"));
            label.setStyle("-fx-font-size: 30px");
            // create a Button
            Button chooseButton = new Button("Choose File");
            chooseButton.setTextFill(Color.web("#222224"));
            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            // get the file selected
                            File file = fil_chooser.showOpenDialog(stage);
                            path = file.getAbsolutePath();
                            runSw = true;
                            if (file.isFile()) {
                                label.setText(path + "  selected");
                                label.setStyle("-fx-text-inner-color: red;");
                            }
                        }
                    };

            chooseButton.setOnAction(event);
            // create a Button
//            Button button1 = new Button("Show save dialog");
//            button1.setTextFill(Color.web("#6e7cde"));
//            // create an Event Handler
//            EventHandler<ActionEvent> event1 =
//                    new EventHandler<ActionEvent>() {
//                        public void handle(ActionEvent e) {
//                            // get the file selected
//                            File file = fil_chooser.showSaveDialog(stage);
//                            path = file.getAbsolutePath();
//                            if (file != null) {
//                                label.setText(path + "  selected");
//                            }
//                        }
//                    };
//
//            button1.setOnAction(event1);

            Button runButton = new Button("RUN");
            runButton.setTextFill(Color.web("#222224"));
            runButton.setStyle("-fx-background-color:#FF7C50");
            EventHandler<ActionEvent> event2 =
                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            if (runSw) {
                                try {
                                    Program program = new Program();
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            } else {
                                label.setText("You have NOT chosen a file yet!");
                            }
                        }
                    };
            runButton.setOnAction(event2);
            // create a VBox
            Pane root = new GridPane();
            root.setStyle("-fx-background-image: url('https://cdn5.vectorstock.com/i/1000x1000/82/74/abstract-orange-gray-triangles-background-vector-8878274.jpg'); -fx-background-size: 100% 120%");

            BackgroundFill background_fill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(background_fill);
            root.setBackground(background);

            VBox vbox = new VBox(30);
            vbox.setAlignment(Pos.CENTER);
            vbox.setLayoutX(430);
            vbox.setLayoutY(220);
            vbox.getChildren().addAll(label, chooseButton, runButton);
            root.getChildren().add(vbox);
            Scene scene1 = new Scene(root, 600, 400);
//            scene1.setFill(new LinearGradient(
//                    0, 0, 1, 1, true,                      //sizing
//                    CycleMethod.NO_CYCLE,                  //cycling
//                    new Stop(0, Color.web("#81c483")),     //colors
//                    new Stop(1, Color.web("#fcc200")))
//            );

            stage.setScene(scene1);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            stage.alwaysOnTopProperty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void stop() throws Exception {
        System.out.println("finished...");
    }
}
