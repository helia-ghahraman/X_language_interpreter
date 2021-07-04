package Interpreter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AboutUs extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button back=new Button("back");
        EventHandler<ActionEvent> event4 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        Graphics graphics=new Graphics();
                        try {
                            graphics.start(stage);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                };
        back.setOnAction(event4);
        TextArea inform=new TextArea("\t\t\t\t\t\t\tWelcome to ‘HEY Intellij’\n\n" +
                "1-This is our final project which is a simple compiler.\n\n" +
                "2-There are some more options that we added to our project such as:\n" +
                "a) The ability to add some comments in your code using ’//’\n" +
                "b) You can also print strings in addition to variables and numbers!\n" +
                "c)If your code did not work, don’t worry because you are able to \n" +
                "see the errors and the reason it occurred!\n" +
                "d) You are able to see which line has made the errors. It’s easier to fix them this way!\n" +
                "e) If you have not made a file for your code ,don’t worry because you have \n" +
                "the option to write your file instantly :D \n" +
                "f) Finally you are able to go back to the first page and try new codes\n" +
                " without rerunning the project multiple times!\n" +
                "e) We added some graphics to the project for you to enjoy 😎😊\n\n" +
                "3- Don’t forget to turn your Wi-Fi on while using this Program(other wise\n" +
                " you won’t be able to enjoy the graphic)\n\n" +
                "4-This project is written by:\n Helia Ghahraman(9822762437)\n Yasamin Azizi(9922762037)\n Ali Hamidzade(9912762529)\n");
        inform.setDisable(true);
        inform.setMinSize(500, 500);
        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(320);
        vbox.setLayoutY(50);
        vbox.getChildren().addAll(inform,back);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 600, 400);
        stage.setScene(scene1);
        stage.show();

    }
}
