package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;

public class Problem4 {
    //https://adventofcode.com/2022/day/4
    private static final String PATH1 = Utility.FILE_PATH + "input4_1.txt";
    public static void main(String[] args) {
        try {
            one(PATH1);
            System.out.println("////////////////");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void one(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        int countFullOverlap = 0;
        int countOverlap = 0;
        while (line != null) {
            int one = 0, two = 0, three = 0, four = 0;
            String s = line.replaceAll("-", " ").replaceFirst(",", " ");
            String[] nums = s.split(" ");
            one = Integer.parseInt(nums[0]);
            two = Integer.parseInt(nums[1]);
            three = Integer.parseInt(nums[2]);
            four = Integer.parseInt(nums[3]);

            if (one <= three && two >= four || three <= one && four >= two)
                countFullOverlap++;

            if (one <= four && three <= two || three <= two && one <= four)
                countOverlap++;

            line = in.readLine();
        }
        System.out.println("Count full overlap of 1st task: " + countFullOverlap);
        System.out.println("Count of overlaps of 2st task: " + countOverlap);
    }
}
