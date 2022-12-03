package adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Utility {
    public static String FILE_PATH = "src/adventofcode/files/";

    public static BufferedReader getReader(String path) {
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            return in;
        } catch (Exception e) {
            System.out.println("exception");
        }
        return null;
    }
}
