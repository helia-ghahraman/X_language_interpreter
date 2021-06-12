package Interpreter2;

import java.io.*;

public class Line {
    String string;
    BufferedReader bufferedReader = null;

    public Line(String path) throws FileNotFoundException {
        bufferedReader = new BufferedReader(
                new FileReader(path));
    }

    public String getLine(int line) throws IOException {
        for (int i = 0; i < line - 1; i++) {
            bufferedReader.readLine();
        }
        string = bufferedReader.readLine();
        return this.string;
    }

    public void print() {
        System.out.println(this.string);
    }
}
