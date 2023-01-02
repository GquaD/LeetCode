package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem120 {
    //https://leetcode.com/problems/triangle/
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> big = new ArrayList<>();
        big.add(list1);
        big.add(list2);
        big.add(list3);
        big.add(list4);
        System.out.println(minimumTotal(big));
    }

    //https://leetcode.com/problems/triangle/solutions/2983954/java-3-ms-solution/
    //20-30 min
    //Runtime
    //3 ms
    //Beats
    //79.11%
    //Memory
    //41.8 MB
    //Beats
    //94.76%
    static int minimumTotal(List<List<Integer>> t) {
        int[][] sum = new int[t.size()][t.get(t.size() - 1).size()];
        sum[0][0] = t.get(0).get(0);
        for (int i = 0; i < t.size() - 1; i++) {
            List<Integer> listCurr = t.get(i), listNext = t.get(i + 1);
            for (int j = 0; j < listCurr.size(); j++) {
                int curr = sum[i][j];
                if (j == 0) {
                    sum[i + 1][j] = curr + listNext.get(j);
                } else {
                    sum[i + 1][j] = Math.min(sum[i + 1][j], curr + listNext.get(j));
                }
                sum[i + 1][j + 1] = curr + listNext.get(j + 1);
            }
        }
        int min = 100_000;
        for (int n : sum[sum.length - 1]) if (min > n) min = n;
        return min;
    }

    static int minimumTotal1(List<List<Integer>> t) {
        int[][] sum = new int[t.size()][t.get(t.size() - 1).size()];
        for (int i = 0; i < t.size() - 1; i++) {
            List<Integer> listCurr = t.get(i), listNext = t.get(i + 1);
            for (int j = 0; j < listCurr.size(); j++) {
                int curr = listCurr.get(j);
                if (j == 0) {
                    sum[i + 1][j] = curr + listNext.get(j);
                } else {
                    sum[i + 1][j] = Math.min(sum[i + 1][j], curr + listNext.get(j));
                }
                sum[i + 1][j + 1] = curr + listNext.get(j + 1);
            }
        }
        int min = 100_000;
        for (int n : sum[sum.length - 1]) if (min > n) min = n;
        return min;
    }
}
