package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2928 {
    //https://leetcode.com/problems/distribute-candies-among-children-i
    public static void main(String[] args) {

    }

    //10min
    //Runtime
    //45
    //ms
    //Beats
    //6.01%
    //Analyze Complexity
    //Memory
    //45.43
    //MB
    //Beats
    //5.08%
    public int distributeCandies(int n, int limit) {
        if (n > limit * 3) return 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= n ; i++) {
            if (i > limit) break;
            for (int j = 0; j <= n - i; j++) {
                if (j > limit) break;
                for (int k = 0; k <= n - i - j; k++) {
                    if (k > limit) break;
                    if (i + j + k == n) set.add(i + "_" + j + "_" + k);
                }
            }
        }
        return set.size();
    }
}
