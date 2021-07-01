package Interpreter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.*;

public class Result {
    String userInput;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label resultLb;

    @FXML
    private TextArea resultText;

    @FXML
    private TextArea fileText;

    @FXML
    private Button Compile;

    @FXML
    private TextField textName;

    @FXML
    private Label nameLb;

    @FXML
    private Button okbtn;

    @FXML
    private Label showLb;

    @FXML
    void pressCompile(ActionEvent event) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter("TextFiles\\" + userInput + ".txt", true)))) {
            out.println(fileText.getText());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        File file = new File("TextFiles\\" + userInput + ".txt");
        Graphics.path = file.getAbsolutePath();
    }

    @FXML
    void pressOk(ActionEvent event) {
        int sw=0;
        userInput=textName.getText();
        if (userInput != null) {
            File textFiles=new File("TextFiles");
            String[]names=textFiles.list();
            for (int i=0;i<names.length;i++){
                if (names[i].equals(userInput+".txt")){
                    showLb.setText("Already Exists!");
                    showLb.setTextFill(Color.web("#c21b2f"));
                    sw=1;
                    break;
                }
            }
            if (sw==0) {
                showLb.setText("name is chosen successfully");
                showLb.setTextFill(Color.web("#1bc226"));
            }
        }
    }

}
