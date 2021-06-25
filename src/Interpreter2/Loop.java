package Interpreter2;

import java.io.IOException;
import java.util.ArrayList;

public class Loop<length> extends Statement {
    private static int  length;
    private static ArrayList<String> codes = null;

    public Loop(String[] tokens, int start, int finish, ArrayList<String> codes) throws IOException {
        this.codes = codes;
        length = finish - start;
        execute(tokens);
    }
    //*********************************************************
    @Override
    public void execute(String[] tokens) throws IOException {
        String line=null;
        for (int j = 0; j < Integer.parseInt(tokens[1]); j++) {
            for (int i=0; i < length; i++) {
                if (codes.get(i).startsWith("for")) {
                    i= loop2(codes,i);
                }else {
                    Program.makeTokens(codes.get(i));
                }
            }
        }
    }

    public int loop2(ArrayList<String> codes,int i) throws IOException {
        int start = i;
        int finish = 0;
//        String line=codes.get(i).replaceAll(" +"," ");
        String line = codes.get(i).trim();
        String[] tokens = line.split(" ");
        int v = Integer.parseInt(tokens[1]);
        for (int k = 0; k < v; k++) {
            while (!codes.get(i + 1).startsWith("end")) {
                if (codes.get(i + 1).startsWith("for")) {
                    i = loop2(codes, i + 1) - 1;
                } else Program.makeTokens(codes.get(i + 1));
                i++;
            }
            finish = i + 1;
            i=start;
        }
        return finish;
    }
}

