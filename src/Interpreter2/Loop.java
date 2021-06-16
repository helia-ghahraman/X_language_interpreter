package Interpreter2;

import java.io.IOException;
import java.util.ArrayList;

public class Loop extends Statement {
    private int startLoopLine;
    private int endLoopLine;
    private static ArrayList<String> codes = null;

    public Loop(String[] tokens, int start, int finish, ArrayList<String> codes) throws IOException {
        this.codes = codes;
        startLoopLine = start;
        endLoopLine = finish;
        execute(tokens);
    }

    //*********************************************************

    @Override
    public void execute(String[] tokens) throws IOException {
        String line = null;
        int length = endLoopLine - startLoopLine;
        System.out.printf("length: %d\n", length + 1);
        for (int j = 0; j < Integer.parseInt(tokens[1]); j++) {
            for (int i = 0; i <= length; i++) {
                line = codes.get(i);
                Program.makeTokens(line);
            }
        }
    }
}

