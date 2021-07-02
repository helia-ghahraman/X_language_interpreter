package Interpreter;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.concurrent.TimeUnit;

public class Print extends Statement {
    private int charNumber;
    Pane root = new Pane();
    Scene scene = new Scene(root);
    static StringBuilder builder=new StringBuilder();
    public Print(String[] tokens) {
        execute(tokens);
    }

    //*********************************************************
    @Override
    public void execute(String[] tokens) {
        String pattern = ".+";
        if (Variable.intVariables.containsKey(tokens[1])) {
            builder.append(Variable.intVariables.get(tokens[1])+"\n");
            setCharNumber(getDigitI(Variable.intVariables.get(tokens[1])));

        } else if (Variable.floatVariables.containsKey(tokens[1])) {
            builder.append(Variable.floatVariables.get(tokens[1])+"\n");
            setCharNumber(getDigitF(Variable.floatVariables.get(tokens[1])));
        } else if (tokens[1].matches(pattern)){
            builder.append(tokens[1]+"\n");
            setCharNumber(tokens[1].length());
        }else {throw new IllegalArgumentException("("+tokens[1]+") can NOT be printed!");}
        getCharNumber();
        System.out.println(builder.toString());
        Result.result.setText(builder.toString());
    }

    public int getCharNumber() {
        return charNumber;
    }

    public void setCharNumber(int charNumber) {
        this.charNumber = charNumber;
    }

    public int getDigitF(float number) {
        String addad;
        addad = Float.toString(number);
        return addad.length();
    }

    public int getDigitI(int number) {
        String addad;
        addad = Integer.toString(number);
        return addad.length();
    }

}
