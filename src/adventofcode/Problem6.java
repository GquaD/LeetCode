package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Problem6 {
    private static final String PATH1 = Utility.FILE_PATH + "input6_1.txt";

    public static void main(String[] args) {
        try {
            one(PATH1); //CNHFPJRJG not correct | CVCWCRTVQ correct
            System.out.println("////////////////");
            two(PATH1);
            System.out.println("////////////////");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void two(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        int result = -1;
        while (line != null) {
            for (int i = 14; i < line.length(); i++) {
                Set<Character> set = new HashSet<>();
                for (int j = i - 14; j < i; j++) {
                    if (set.contains(line.charAt(j))) {
                        break;
                    }
                    set.add(line.charAt(j));
                }
                if (set.size() == 14) {
                    result = i;
                    break;
                }
            }
            line = in.readLine();
        }
        System.out.println("Result: " + result);
    }

    public static void one(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        int result = -1;
        while (line != null) {
            for (int i = 4; i < line.length(); i++) {
                char a = line.charAt(i - 4);
                char b = line.charAt(i - 3);
                char c = line.charAt(i - 2);
                char d = line.charAt(i - 1);
                if (a != b && a != c && a != d && b != c && b != d && c != d) {
                    result = i;
                    break;
                }
            }
            line = in.readLine();
        }
        System.out.println("Result: " + result);
    }
}
