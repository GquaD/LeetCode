package LeetCode.easy;

import java.util.*;

public class Problem3507 {
    //
    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{689,-360,234,673,663,-741,480,860,-707,209,246,792,930,696,-305}));
        System.out.println(minimumPairRemoval(new int[]{-2,1,2,-1,-1,-2,-2,-1,-1,1,1}));
        System.out.println(minimumPairRemoval(new int[]{2,2,-1,3,0,1,1,1,-1}));
        System.out.println(minimumPairRemoval(new int[]{2,2,-1,3,-2,2,1,1,1,0,-1}));

    }

    //https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/solutions/6699416/my-3ms-java-solution-by-tbekpro-h0xf/
    //1hour
    //Runtime
    //3
    //ms
    //Beats
    //62.14%
    //Analyze Complexity
    //Memory
    //42.88
    //MB
    //Beats
    //61.00%
    public static int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n: nums) list.add(n);
        int count = 0, min = 2001;
        while (!isIncreasing(list)) {
            int idx = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int a = list.get(i), b = list.get(i + 1);
                if (a + b < min) {
                    min = a + b;
                    idx = i;
                }
            }
            list.remove(idx);
            list.remove(idx);
            list.add(idx, min);
            min = 1_000_000_001;
            count++;
        }
        return count;
    }

    private static boolean isIncreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }
}
