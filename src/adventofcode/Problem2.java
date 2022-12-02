package adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem2 {
    //https://adventofcode.com/2022/day/2
    public static void main(String[] args) {
        one(); //result = 13446
        two(); // 12k+ is low, 15 536 is high| answer is 13 509
    }

    public static void two() {
        File file = new File(Utility.FILE_PATH + "input2_1.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String s = in.readLine();
            int sum = 0, count = 1;
            while (s != null) {
                char one = s.charAt(0), two = s.charAt(2);
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
                switch (one) {
                    case 'A': {
                        switch (two) {
                            case 'X': {
                                sum += 4;// 1 + 3 draw
                                break;
                            }
                            case 'Y': {
                                sum += 8; //2 + 6 win
                                break;
                            }
                            case 'Z': {
                                sum += 3; //3 + 0 lose
                                break;
                            }
                        }
                        break;
                    }
                    case 'B': {
                        switch (two) {
                            case 'X': {
                                sum += 1; // 1 + 0 lose
                                break;
                            }
                            case 'Y': {
                                sum += 5; // 2 + 3 draw
                                break;
                            }
                            case 'Z': {
                                sum += 9; //3 + 6 win
                                break;
                            }
                        }
                        break;
                    }
                    case 'C': {
                        switch (two) {
                            case 'X': {
                                sum += 7; // 1 + 6 win
                                break;
                            }
                            case 'Y': {
                                sum += 2; //2 + 0 lose
                                break;
                            }
                            case 'Z': {
                                sum += 6; //3 + 3 draw
                                break;
                            }
                        }
                        break;
                    }
                }
                s = in.readLine();
                count++;
            }
            System.out.println("result = " + sum);
            /*System.out.println("count = " + (count - 1));
            System.out.println("Res = " + ((((count - 1) / 3) * 12) + 4));*/
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public static void one() {
        File file = new File(Utility.FILE_PATH + "input2_1.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String s = in.readLine();
            int sum = 0;
            while (s != null) {
                char one = s.charAt(0), two = s.charAt(2);
                switch (one) {
                    case 'A': {
                        switch (two) {
                            case 'X': {
                                sum += 4;// 1 + 3 draw
                                break;
                            }
                            case 'Y': {
                                sum += 8; //2 + 6 win
                                break;
                            }
                            case 'Z': {
                                sum += 3; //3 + 0 lose
                                break;
                            }
                        }
                        break;
                    }
                    case 'B': {
                        switch (two) {
                            case 'X': {
                                sum += 1; // 1 + 0 lose
                                break;
                            }
                            case 'Y': {
                                sum += 5; // 2 + 3 draw
                                break;
                            }
                            case 'Z': {
                                sum += 9; //3 + 6 win
                                break;
                            }
                        }
                        break;
                    }
                    case 'C': {
                        switch (two) {
                            case 'X': {
                                sum += 7; // 1 + 6 win
                                break;
                            }
                            case 'Y': {
                                sum += 2; //2 + 0 lose
                                break;
                            }
                            case 'Z': {
                                sum += 6; //3 + 3 draw
                                break;
                            }
                        }
                        break;
                    }
                }
                s = in.readLine();
            }
            System.out.println("result = " + sum);
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
