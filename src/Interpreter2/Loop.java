package Interpreter2;

import java.io.IOException;
import java.util.ArrayList;

public class Loop<length> extends Statement {
    public static int x;
    private int startLoopLine;
    private int endLoopLine;
    private static int  length;
    private static ArrayList<String> codes = null;

    public Loop(String[] tokens, int start, int finish, ArrayList<String> codes) throws IOException {
        this.codes = codes;
        startLoopLine = start;
        endLoopLine = finish;
        length = endLoopLine - startLoopLine;
        getStart(codes);
        execute(tokens);
    }

    //*********************************************************

    @Override
    public void execute(String[] tokens) throws IOException {
        String line = null;
        for (int j = 0; j < Integer.parseInt(tokens[1]); j++) {
            for (int i = 0; i < length; i++) {
                line = codes.get(i);
                Program.makeTokens(line);
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
   /* @Override
    public void execute(String[] tokens) throws IOException {
        int endCount=0;
        int forCount=0;
        int length = endLoopLine - startLoopLine;
        for (int i=0;codes.get(i)!=null)
        for (int j = 0; j < Integer.parseInt(tokens[1]); j++) {
            for (int i = 0; i <= length; i++) {
                if (codes.get(i).equals("for"))forCount++;
                Program.makeTokens(codes.get(i));
            }
        }
    }*/
}

