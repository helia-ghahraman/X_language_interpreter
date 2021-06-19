package Interpreter2;

import java.io.IOException;
import java.util.ArrayList;

public class Loop<length> extends Statement {
    public static int x;
    private static int  length;
    private static ArrayList<String> codes = null;

    public Loop(String[] tokens, int start, int finish, ArrayList<String> codes) throws IOException {
        this.codes = codes;
        length = finish - start;
        getStart(codes);
        execute(tokens);
    }
    //*********************************************************
    @Override
    public void execute(String[] tokens) throws IOException {
        String line=null;
        for (int j = 0; j < Integer.parseInt(tokens[1]); j++) {
            for (int i=0; i < length; i++) {
                if (codes.get(i).startsWith("for")) {
                    line=codes.get(i);
                    for (; !codes.get(i).startsWith("end"); i++);
                    i++;
                    Program.makeTokens(line);
                    System.out.println("line if: "+codes.get(i)+"line: "+line);
                }else {
                    Program.makeTokens(codes.get(i));
                    System.out.println("line else: "+codes.get(i));
                }
            }
        }
    }

    public void getStart(ArrayList<String> codes ){
        int counter=0;
        for (int i=0;i<codes.size();i++){
           if(codes.get(i).startsWith("for")){
               counter=i+1;
               this.x=length-counter+1;
           }
        }
    }
}

