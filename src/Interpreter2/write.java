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
    File file=null;
    @Override
    public void start(Stage stage) throws Exception {

        Button compilebtn = new Button("compile");
        compilebtn.setTextFill(Color.web("#222224"));
        Label showLb = new Label("choose a name for your file:  ");
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
                        if (userInput != null) {
                             file=new File("src//Interpreter2//TextFiles//"+userInput+"");
                          /*  String[]names=textFiles.list();
                            for (int i=0;i<names.length;i++){
                                if (names[i].equals(userInput+".txt")){
                                    showLb.setText("Already Exists!");
                                    showLb.setTextFill(Color.web("#c21b2f"));
                                    sw=1;
                                    break;
                                }
                            }*/
                            //if (sw==0) {
                                showLb.setText(userInput + "  is successfully chosen");
                                showLb.setTextFill(Color.web("#1bc226"));
                           // }
                        }
                    }
                };
        okbtn.setOnAction(event3);

        ///////////
        compilebtn.setOnAction(actionEvent -> {
            code.set(grammer.getText());
            try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("src//Interpreter2//TextFiles//"+textname.getText()+""+".txt", true)))) {
                out.println(grammer.getText());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println(file.getAbsolutePath());
            Graphics.path = file.getAbsolutePath();
            stage.close();
        });
        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://image.freepik.com/free-vector/white-minimal-hexagons-background_79603-1453.jpg'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(400);
        vbox.setLayoutY(100);
        vbox.getChildren().addAll(showLb, textname, okbtn, grammer, compilebtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 600, 400);
        stage.setScene(scene1);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }
}
