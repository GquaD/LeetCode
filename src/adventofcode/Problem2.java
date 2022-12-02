package adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem2 {
    //https://adventofcode.com/2022/day/2
    private static final String PATH1 = Utility.FILE_PATH + "input2_1.txt";
    private static final String PATH2 = Utility.FILE_PATH + "input2_2.txt";
    public static void main(String[] args) {
        System.out.println("///////////input2_1///////////");
        one(PATH1);
        two(PATH1);
        System.out.println("///////////input2_2///////////");
        one(PATH2);
        two(PATH2);

    }
    //input2_1
    //result = 13446
    //result = 13 509

    ///input2_2
    //result = 13005
    //result = 11373
    public static void two(String path) {
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String s = in.readLine();
            int sum = 0;
            while (s != null) {
                char one = s.charAt(0), two = s.charAt(2);
                two = findNextMove(one, two);
                sum += calculateGameResult(one, two);
                s = in.readLine();
            }
            System.out.println("result = " + sum);
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public static void one(String path) {
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String s = in.readLine();
            int sum = 0;
            while (s != null) {
                char one = s.charAt(0), two = s.charAt(2);
                sum += calculateGameResult(one, two);
                s = in.readLine();
            }
            System.out.println("result = " + sum);
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    private static int calculateGameResult(char one, char two) {
        switch (one) {
            case 'A': {
                switch (two) {
                    case 'X': {
                        return 4;// 1 + 3 draw
                    }
                    case 'Y': {
                        return  8; //2 + 6 win
                    }
                    case 'Z': {
                        return  3; //3 + 0 lose
                    }
                }
                break;
            }
            case 'B': {
                switch (two) {
                    case 'X': {
                        return  1; // 1 + 0 lose
                    }
                    case 'Y': {
                        return  5; // 2 + 3 draw
                    }
                    case 'Z': {
                        return  9; //3 + 6 win
                    }
                }
                break;
            }
            case 'C': {
                switch (two) {
                    case 'X': {
                        return  7; // 1 + 6 win
                    }
                    case 'Y': {
                        return  2; //2 + 0 lose
                    }
                    case 'Z': {
                        return  6; //3 + 3 draw
                    }
                }
                break;
            }
        }
        return 0;
    }

    private static char findNextMove(char one, char two) {
        if (two == 'Y') {//draw
            switch (one) {
                case 'A': {
                    two = 'X';
                    break;
                }
                case 'B': {
                    two = 'Y';
                    break;
                }
                case 'C': {
                    two = 'Z';
                    break;
                }
            }
        } else if (two == 'X') {//lose
            switch (one) {
                case 'A': {
                    two = 'Z';
                    break;
                }
                case 'B': {
                    two = 'X';
                    break;
                }
                case 'C': {
                    two = 'Y';
                    break;
                }
            }
        } else if (two == 'Z') { //win
            switch (one) {
                case 'A': {
                    two = 'Y';
                    break;
                }
                case 'B': {
                    two = 'Z';
                    break;
                }
                case 'C': {
                    two = 'X';
                    break;
                }
            }
        }
        return two;
    }
}
