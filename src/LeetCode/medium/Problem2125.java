package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2125 {
    //https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(numberOfBeams(new String[]{"000", "111", "000"}));
    }

    //O(2N) done in 20 mins
    //Runtime: 33 ms, faster than 23.87% of Java online submissions for Number of Laser Beams in a Bank.
    //Memory Usage: 54 MB, less than 61.01% of Java online submissions for Number of Laser Beams in a Bank.
    static int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            int count = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    count++;
                }
            }
            if (count != 0) {
                list.add(count);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size(); i++) {
            sum += list.get(i - 1) * list.get(i);
        }
        return sum;
    }


    static int numberOfBeams1(String[] bank) {
        int sumBeams = 0;
        int count1Row = 0, count2row = 0;
        boolean firstRowDone = false;
        for (int i = 0; i < bank.length; i++) {
            if (!bank[i].contains("1")) {
                continue;
            }
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    if (!firstRowDone) {
                        count1Row++;
                    } else {
                        count2row++;
                    }
                }
            }
            firstRowDone = !firstRowDone;

            if (!firstRowDone) {
                sumBeams += count1Row * count2row;
                count1Row = 0;
                count2row = 0;
            }
        }
        return sumBeams;
    }
}
