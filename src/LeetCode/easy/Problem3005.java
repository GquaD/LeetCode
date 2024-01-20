package LeetCode.easy;
import java.util.*;

public class Problem3005 {
    //https://leetcode.com/problems/count-elements-with-maximum-frequency/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-elements-with-maximum-frequency/submissions/
    //Runtime
    //2
    //ms
    //Beats
    //72.56%
    //of users with Java
    //Memory
    //42.47
    //MB
    //Beats
    //32.04%
    //of users with Java
    static int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int n : nums) {
            int f = map.getOrDefault(n, 0) + 1;
            map.put(n, f);
            max = Math.max(f, max);
        }
        int count = 0;
        for (int n : map.keySet()) {
            int f = map.get(n);
            if (f == max) {
                count += max;
            }
        }
        return count;
    }
}
