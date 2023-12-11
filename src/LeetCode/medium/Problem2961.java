package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem2961 {
    //https://leetcode.com/problems/double-modular-exponentiation/
    public static void main(String[] args) {
        LeetCodeUtils.printList(getGoodIndices(new int[][]{{37,1,12,52}}, 1));
        LeetCodeUtils.printList(getGoodIndices(new int[][]{{39,3,1000,1000}}, 17));
        LeetCodeUtils.printList(getGoodIndices(new int[][]{{2,3,3,10},{3,3,3,1},{6,1,1,4}}, 2));
    }

    //https://leetcode.com/problems/double-modular-exponentiation/solutions/4390883/java-solution-using-remainders/
    //20 min
    //Runtime
    //4 ms
    //Beats
    //33.33%
    //Memory
    //44 MB
    //Beats
    //33.33%
    static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            int mult = 1;
            for (int j = 0; j < b; j++) {
                mult *= a;
                mult %= 1000;
            }

            int d = mult % 10;
            mult = 1;
            for (int j = 0; j < c; j++) {
                mult *= d;
                mult %= m;
            }

            if (mult % m == target) list.add(i);
        }
        return list;
    }

    //Wrong Answer
    //517 / 524 testcases passed
    static List<Integer> getGoodIndices1(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            double d = Math.pow(a, b) % 10;
            if (Math.pow(d, c) % m == target) list.add(i);
        }
        return list;
    }
}
