package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;

public class Problem3 {
    private static final String PATH1 = Utility.FILE_PATH + "input3_1.txt";
    private static final String PATH2 = Utility.FILE_PATH + "input3_2.txt";

    public static void main(String[] args) {
        try {
            one(PATH1);
            two(PATH2);
            System.out.println("////////////////////");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    static boolean[] aLow1 = new boolean[26], aUp1 = new boolean[26];
    static boolean[] aLow2 = new boolean[26], aUp2 = new boolean[26];
    static boolean[] aLow3 = new boolean[26], aUp3 = new boolean[26];

    public static void two(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        int sum = 0, count = 0;
        clearArrays();
        while (line != null) {
            if (count % 3 == 0 && count > 2) {
                sum += findBadge();
                clearArrays();
            }
            int personInGroup = count % 3;
            if (personInGroup == 0) {
                countTypesInRuckSack(line, aLow1, aUp1);
            } else if (personInGroup == 1) {
                countTypesInRuckSack(line, aLow2, aUp2);
            } else {
                countTypesInRuckSack(line, aLow3, aUp3);
            }
            count++;
            line = in.readLine();
        }
        sum += findBadge();
        System.out.println("Sum of group priorities is " + sum);
    }

    private static void countTypesInRuckSack(String line, boolean[] aLow1, boolean[] aUp1) {
        for (char c : line.toCharArray()) {
            if (Character.isLowerCase(c)) {
                aLow1[c - 'a'] = true;
            } else {
                aUp1[c - 'A'] = true;
            }
        }
    }
    private static int findBadge() {
        for (int i = 0; i < aLow1.length; i++) {
            if (aLow1[i] && aLow2[i] && aLow3[i]) {
                return i + 1;
            }
        }
        for (int i = 0; i < aLow1.length; i++) {
            if (aUp1[i] && aUp2[i] && aUp3[i]) {
                return i + 27;
            }
        }
        return 0;
    }
    private static void clearArrays() {
        clearArray(aLow1);
        clearArray(aLow2);
        clearArray(aLow3);
        clearArray(aUp1);
        clearArray(aUp2);
        clearArray(aUp3);
    }

    public static void one(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        int[] alphabetLow = new int[26], alphabetUp = new int[26];
        String line = in.readLine();
        int sum = 0;
        while (line != null) {
            String one = line.substring(0, line.length() / 2);
            String two = line.substring(line.length() / 2);
            for (char c : one.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    alphabetLow[c - 'a']++;
                } else {
                    alphabetUp[c - 'A']++;
                }
            }
            //finding letter in both and adding to sum
            for (char c : two.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    if (alphabetLow[c - 'a'] > 0) {
                        sum += (c - 'a') + 1;
                        break;
                    }
                } else {
                    if (alphabetUp[c - 'A'] > 0) {
                        sum += (c - 'A') + 27;
                        break;
                    }
                }
            }
            //clear alph arrays
            clearArray(alphabetLow);
            clearArray(alphabetUp);
            line = in.readLine();
        }
        System.out.println("Sum of priorities is " + sum);
    }

    private static void clearArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private static void clearArray(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
    }
}
