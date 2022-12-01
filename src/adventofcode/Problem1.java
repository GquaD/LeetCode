package adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1 {
    //https://adventofcode.com/2022/day/1
    public static void main(String[] args) {
//        one();
        two();
    }

    public static void one() {
        File file = new File("src/adventofcode/files/input1_2.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            int n = 0, max = -1, count = 1;
            String s = in.readLine();
            while (s != null) {
                if (s.length() != 0) {
                    n += Integer.parseInt(s);
                } else {
                    System.out.println(n + " is carried by elf #" + count);
                    if (max < n) {
                        max = n;
                    }
                    n = 0;
                    count++;
                }
                s = in.readLine();
            }
            System.out.println("///////////");
            System.out.println(max + " is max carried");
        } catch (Exception c) {
            System.out.println("exception while reading");
        }
    }

    public static void two() {
        File file = new File("src/adventofcode/files/input1_2.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            int n = 0, count = 1;
            int max1 = -1, max2 = -1, max3 = -1;
            String s = in.readLine();
            while (s != null) {
                if (s.length() != 0) {
                    n += Integer.parseInt(s);
                } else {
                    System.out.println(n + " is carried by elf #" + count);
                    if (n > max3 && n < max2) {
                        max3 = n;
                    }
                    if (n > max2 && n < max1) {
                        max3 = max2;
                        max2 = n;
                    }
                    if (max1 < n) {
                        max2 = max1;
                        max1 = n;
                    }
                    n = 0;
                    count++;
                }
                s = in.readLine();
            }
            System.out.println((max1 + max2 + max3) + " is carried by top 3");
        } catch (Exception c) {
            System.out.println("exception while reading");
        }
    }
}
