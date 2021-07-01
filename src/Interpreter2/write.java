package Interpreter2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

public class write extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       /* Button compilebtn = new Button("compile");
        compilebtn.setTextFill(Color.web("#222224"));
        Label labelname = new Label("choose a name for your file:  ");
        TextField textname = new TextField();
        AtomicReference<String> name = null;
        Button okbtn = new Button("ok");
        TextArea grammer = new TextArea();
        grammer.setMaxSize(300, 400);
        grammer.setMinSize(300, 400);
        AtomicReference<String> code = new AtomicReference<>(new String());
        ////////////////
        EventHandler<ActionEvent> event3 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        try{
                            name.set(textname.getText());
                            if (name == null) {
                                labelname.setText("you have not choosen a name for file!");
                            } else {
                                labelname.setText("you have choosen a name successfully!");
                            }
                        }catch(Exception exception) {
                            exception.getMessage();
                        }
                    }
                };
        okbtn.setOnAction(event3);

        ///////////
        compilebtn.setOnAction(actionEvent -> {
            code.set(grammer.getText());
            try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("TextFiles\\" + name + ".txt", true)))) {
                out.println(grammer.getText());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            File file = new File("TextFiles\\" + name + ".txt");
            Graphics.path = file.getAbsolutePath();
            stage.close();

        });*/
        Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setStyle("-fx-background-image: url('https://image.freepik.com/free-vector/white-minimal-hexagons-background_79603-1453.jpg'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(400);
        vbox.setLayoutY(100);
       // vbox.getChildren().addAll(labelname, textname, okbtn, grammer, compilebtn);
        //root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 600, 400);
        stage.setScene(scene1);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }
}
