package Interpreter2;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import javafx.stage.FileChooser;
import java.awt.*;

public class Graphics extends Application {
    @Override
    public void init() throws Exception {
        System.out.println("before");
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*stage.setTitle("HAY.Intellij");
        stage.setWidth(1150);
        stage.setHeight(800);
        stage.setX(200);
        stage.setY(20);*/
        // launch the application

        try {
            // set title for the stage
            stage.setTitle("FileChooser");

            // create a File chooser
            FileChooser fil_chooser = new FileChooser();

            // create a Label
            Label label = new Label("no files selected");

            // create a Button
            Button button = new Button("Show open dialog");

            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent e) {
                            // get the file selected
                            File file = fil_chooser.showOpenDialog(stage);

                            if (file != null) {
                                label.setText(file.getAbsolutePath()
                                        + "  selected");
                            }
                        }
                    };

            button.setOnAction(event);
            // create a Button
            Button button1 = new Button("Show save dialog");
            // create an Event Handler
            EventHandler<ActionEvent> event1 =
                    new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent e) {

                            // get the file selected
                            File file = fil_chooser.showSaveDialog(stage);

                            if (file != null) {
                                label.setText(file.getAbsolutePath()
                                        + "  selected");
                            }
                        }
                    };

            button1.setOnAction(event1);

            // create a VBox
            VBox vbox = new VBox(30, label, button, button1);

            // set Alignment
            vbox.setAlignment(Pos.CENTER);

            // create a scene
            Scene scene = new Scene(vbox, 800, 500);

            // set the scene
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        //modality
       /* Stage newWindow=new Stage();
        newWindow.initModality(Modality.APPLICATION_MODAL);//ta kar bahash tamom nashe az baghie nemishe estefade kard
        //style
        newWindow.initStyle(StageStyle.UTILITY);//just have close option
        newWindow.show();

        VBox parent=new VBox();

        javafx.scene.control.Label label1=new javafx.scene.control.Label("this is a text lable");//child node
        boolean add = parent.getChildren().add(label1);

        Scene scene=new Scene(parent);
        scene.setCursor(Cursor.CROSSHAIR);//different shapes of mouse on scene
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop(){
        System.out.println("after");
    }*/
    }
}
