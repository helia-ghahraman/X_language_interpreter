package Interpreter2;

public class Print extends Statement {
    private int charNumber;

    public Print(String[] tokens) {
        execute(tokens);
    }

    //*********************************************************
    @Override
    public void execute(String[] tokens) {
        if (Variable.intVariables.containsKey(tokens[1])) {
            System.out.println(Variable.intVariables.get(tokens[1]));
            setCharNumber(getDigitI(Variable.intVariables.get(tokens[1])));

        } else if (Variable.floatVariables.containsKey(tokens[1])) {
            System.out.println(Variable.floatVariables.get(tokens[1]));
            setCharNumber(getDigitF(Variable.floatVariables.get(tokens[1])));
        } else {
            System.out.println(tokens[1]);
            setCharNumber(tokens[1].length());
        }
    }

    public int getCharNumber() {
        return charNumber;
    }

    public void setCharNumber(int charNumber) {
        this.charNumber = charNumber;
    }

    public int getDigitF(float number) {
        int num = 0;
        //Todo change here
//        while (number != 0){
//            number /= 10;
//            num++;
//        }
        return num;
    }

    public int getDigitI(int number) {
        int num = 0;
        while (number != 0) {
            number /= 10;
            num++;
        }
        return num;
    }

}
