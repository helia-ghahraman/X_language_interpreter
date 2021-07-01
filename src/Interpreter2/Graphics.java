package Interpreter2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import javafx.stage.FileChooser;
import java.util.Collection;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Graphics extends Application {
    static String path;
    static int runSw = 0;
    @Override
    public void init() throws Exception {
        System.out.println("before");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("HAY.Intellij");
        stage.setWidth(1050);
        stage.setHeight(750);
        stage.setX(200);
        stage.setY(20);
        // launch the application
       try {
            // create a File chooser
            FileChooser fil_chooser = new FileChooser();
            // create a Label
            Label label = new Label("-Choose a text file,then click Compile-");
            label.setTextFill(Color.web("#595556"));
            label.setStyle("-fx-font-size: 15px");
            // create a Button
            Button button = new Button("Choose File");
            button.setTextFill(Color.web("#222224"));
            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            // get the file selected
                            File file = fil_chooser.showOpenDialog(stage);
                            path=file.getAbsolutePath();
                            runSw =1;
                            if (file != null) {
                                label.setText(path + "  selected");
                            }
                        }
                    };

            button.setOnAction(event);
            // create a Button
            Button button1 = new Button("Show save dialog");
           button1.setTextFill(Color.web("#222224"));
           //button1.setStyle("-fx-background-color:#d7d7db ");
            // create an Event Handler
            EventHandler<ActionEvent> event1 =
                    new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            // get the file selected
                            File file = fil_chooser.showSaveDialog(stage);
                            path=file.getAbsolutePath();
                            if (file != null) {
                                label.setText(path + "  selected");
                            }
                        }
                    };

            button1.setOnAction(event1);
           Button button2 = new Button("Compile");
           button2.setTextFill(Color.web("#222224"));
           button2.setStyle("-fx-background-color:#d7d7db ");
           EventHandler<ActionEvent> event2 =
                   new  EventHandler<ActionEvent>() {
                       public void handle(ActionEvent e) {
                           if (runSw==1) {try{
                               Program program=new Program();
                           }catch (IOException ioException){
                               ioException.getMessage();
                           }
                           }else {
                               label.setText("You have NOT chosen a file yet!");
                           }
                       }
                   };
           button2.setOnAction(event2);
           //////////////
           Button button3 = new Button("write my file");
           button3.setTextFill(Color.web("#222224"));
           button3.setStyle("-fx-background-color:#d7d7db ");

           EventHandler<ActionEvent> event3 =
                   new  EventHandler<ActionEvent>() {
                       public void handle(ActionEvent e) {
                           try {
                               write write=new write();
                               write.start(stage);
                              /*Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
                               Scene scene=new Scene(root,500,800);
                               stage.setScene(scene);
                               stage.show();*/
                           } catch (Exception exception) {
                               exception.printStackTrace();
                           }

                       }
                   };
           button3.setOnAction(event3);
            // create a VBox
            Pane root=new Pane();
           root.setStyle("-fx-background-image: url('https://image.freepik.com/free-vector/white-minimal-hexagons-background_79603-1453.jpg'); -fx-background-size: 100% 100%");
            VBox vbox = new VBox(30);
            vbox.setAlignment(Pos.CENTER);
            vbox.setLayoutX(430);
            vbox.setLayoutY(220);
            vbox.getChildren().addAll(label, button, button1,button2,button3);
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
