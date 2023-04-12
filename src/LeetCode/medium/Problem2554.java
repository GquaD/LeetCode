package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2554 {
    //https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/

    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1,6,5}, 5, 6));
    }

    //https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/solutions/3407381/java-using-set/
    //5 min
    //Runtime
    //59 ms
    //Beats
    //59.78%
    //Memory
    //44 MB
    //Beats
    //67.7%
    static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> setBan = new HashSet<>();
        for (int k : banned) setBan.add(k);
        int runSum = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (!setBan.contains(i)) {
                runSum += i;
                if (runSum <= maxSum) count++;
                else break;
            }
        }
        return count;
    }

}
