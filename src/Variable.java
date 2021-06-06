import java.util.HashMap;

public class Variable {
    String pattern = "[a-zA-Z]+[0-9$_]*";
    public Variable(String type, String name) {
        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("Variable`s name is wrong!");
        } else {
            if (type.equals("int"))
                Program.intVariables.put(name, (int) 0);
            else if (type.equals("float"))
                Program.floatVariables.put(name, (float) 0.0);
        }
    }

    public Variable(String name, int amount) {
        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("Variable`s name is wrong!");
        } else
            Program.intVariables.put(name, amount);
    }

    public Variable(String name, float amount) {
        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("Variable`s name is wrong!");
        } else
            Program.floatVariables.put(name, amount);
    }
}
