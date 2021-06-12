package Interpreter2;

import java.io.IOException;

public interface Executable {
    void execute(String[] tokens) throws IOException;
}
