package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2442 {
    //https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/

    public static void main(String[] args) {
        System.out.println(countDistinctIntegers(new int[]{1,13,10,12,31}));
        System.out.println(countDistinctIntegers(new int[]{2,2,2}));
        System.out.println(countDistinctIntegers(new int[]{2,2,1010}));
    }

    //https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/solutions/2739398/java-97-faster-solution/
    //20 mins
    //Runtime
    //73 ms
    //Beats
    //97.48%
    //Memory
    //63.7 MB
    //Beats
    //89.10%
    static int countDistinctIntegers(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 9) {
                int r = 0;
                while (n > 0) {
                    r += n % 10;
                    if (n > 9) {
                        r *= 10;
                    }
                    n /= 10;
                }
                unique.add(r);
            }
            unique.add(nums[i]);
        }
        return unique.size();
    }
}
