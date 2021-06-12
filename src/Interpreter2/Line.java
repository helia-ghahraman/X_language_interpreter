package Interpreter2;

import java.io.*;

public class Line {
    String string;
    BufferedReader bufferedReader =
            new BufferedReader(
                    new FileReader("TextFiles//src1.txt"));

    public Line() throws IOException {
    }
    public String getLine(int line) throws IOException {
        for (int i=0;i<line-1;i++){
         bufferedReader.readLine();
        }
        string = bufferedReader.readLine();
        return this.string;
    }
    public void print(){
        System.out.println(this.string);
    }
}
