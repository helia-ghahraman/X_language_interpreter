package Interpreter2;

import java.util.HashMap;

public class Variable {
    static HashMap<String, Integer> intVariables = new HashMap<>();
    static HashMap<String, Float> floatVariables = new HashMap<>();

    String pattern = "[a-zA-Z]+[0-9$_]*";


    public Variable(String type, String name) {
        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("Variable`s name is wrong!");
        } else {
            if (type.equals("int"))
                intVariables.put(name, (int) 0);
            else if (type.equals("float"))
                floatVariables.put(name, (float) 0.0);
        }
    }

    public Variable(String name, int amount) {
        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("Variable`s name is wrong!");
        } else
            intVariables.put(name, amount);
    }

    public Variable(String name, float amount) {
        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("Variable`s name is wrong!");
        } else
            floatVariables.put(name, amount);
    }


}
