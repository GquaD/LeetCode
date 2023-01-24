package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem405 {
    //https://leetcode.com/problems/convert-a-number-to-hexadecimal/
    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(5));
        System.out.println(toHex(-5));
    }

    //https://leetcode.com/problems/convert-a-number-to-hexadecimal/solutions/3093151/java-1ms-solution/
    //Runtime
    //1 ms
    //Beats
    //65%
    //Memory
    //42.1 MB
    //Beats
    //10.61%
    static char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static String toHex(int num) {
        if (num == 0) return "0";
        long val = num;
        if (num < 0) val = 4_294_967_296L + num; // 2 ^ 32

        List<Integer> list = new ArrayList<>();
        while (val > 0) {
            list.add((int) (val % 16));
            val /= 16;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(hex[list.get(i)]);
        }
        return sb.toString();
    }

}

