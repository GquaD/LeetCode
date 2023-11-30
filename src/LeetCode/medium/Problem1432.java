package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1432 {
    //https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
    public static void main(String[] args) {
        System.out.println(maxDiff(9990));
        System.out.println(maxDiff(555));
        System.out.println(maxDiff(9));
    }

    //https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/solutions/4346527/java-o-length-2-solution/
    //10-15min
    //Runtime
    //5 ms
    //Beats
    //18.87%
    //Memory
    //40.2 MB
    //Beats
    //9.43%
    static int maxDiff(int num) {
        //first digit to 9
        //then first digit to 1
        Set<Character> set = new HashSet<>();
        String s = String.valueOf(num);
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    sb.append('9');
                } else {
                    sb.append(s.charAt(i));
                }
            }
            int temp = Integer.parseInt(sb.toString());
            max = Math.max(max, temp);
            sb.setLength(0);
        }

        for (char c : set) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    sb.append('0');
                } else {
                    sb.append(s.charAt(i));
                }
            }
            if (sb.toString().startsWith("0")) {
                sb.setLength(0);
                continue;
            }
            int temp = Integer.parseInt(sb.toString());
            min = Math.min(min, temp);
            sb.setLength(0);
        }

        for (char c : set) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    sb.append('1');
                } else {
                    sb.append(s.charAt(i));
                }
            }
            int temp = Integer.parseInt(sb.toString());
            min = Math.min(min, temp);
            sb.setLength(0);
        }
        return max - min;
    }
}
