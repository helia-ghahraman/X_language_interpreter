public class Variable {

    public Variable(String type, String name) {
        if (type.equals("int"))
            Program.intVariables.put(name, (int) 0);
        else if (type.equals("float"))
            Program.floatVariables.put(name, (float) 0.0);
    }

    public Variable(String name, int amount) {
        Program.intVariables.put(name, amount);
    }

    public Variable(String name, float amount) {
        Program.floatVariables.put(name, amount);
    }

}
