package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2938 {
    //https://leetcode.com/problems/separate-black-and-white-balls/
    public static void main(String[] args) {
        System.out.println(minimumSteps("101"));
        System.out.println(minimumSteps("100"));
        System.out.println(minimumSteps("0111"));
    }

    //https://leetcode.com/problems/separate-black-and-white-balls/solutions/4309707/java-o-n-4-lines-solution/
    //5min
    //Runtime
    //9 ms
    //Beats
    //66.67%
    //Memory
    //44.4 MB
    //Beats
    //100%
    static long minimumSteps(String s) {
        long count = 0;
        int idx = s.length() - 1;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '1') count += idx-- - i;
        return count;
    }

    static long minimumSteps1(String s) {
        List<Integer> listIdx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '1') listIdx.add(i);
        long count = 0;
        int idx = s.length() - 1;
        for (int i = listIdx.size() - 1; i >= 0; i--) count += idx-- - listIdx.get(i);
        return count;
    }
}
