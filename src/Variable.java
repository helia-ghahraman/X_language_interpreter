import java.util.HashMap;

public class Variable {
    static HashMap<String, Integer> intVariables = new HashMap<>();
    static HashMap<String, Float> floatVariables = new HashMap<>();

    public Variable(String type, String name) {
        if (type == "int")
            intVariables.put(name, 0);
        else if (type == "float")
            floatVariables.put(name, (float) 0);

    }

    public Variable(String name, int amount) {
        intVariables.put(name, amount);
    }

    public Variable(String name, float amount) {
        floatVariables.put(name, amount);
    }

}
