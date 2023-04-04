package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2606 {
    //https://leetcode.com/problems/find-the-substring-with-maximum-cost/
    public static void main(String[] args) {
        System.out.println(maximumCostSubstring("talaqlt", "tqla", new int[]{4,3,3,-2}));
        System.out.println(maximumCostSubstring("adaa", "d", new int[]{-10}));
        System.out.println(maximumCostSubstring("abc", "abc", new int[]{-1, -1, -1}));
    }

    //https://leetcode.com/problems/find-the-substring-with-maximum-cost/solutions/3377237/java-from-18ms-to-6ms/
    //5 min
    //Runtime
    //6 ms
    //Beats
    //95.64%
    //Memory
    //43.4 MB
    //Beats
    //37.19%
    static int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] map = new int[26];
        for (int i = 0; i < map.length; i++) map[i] = i + 1;
        for (int i = 0; i < chars.length(); i++) map[chars.charAt(i) - 'a'] = vals[i];
        int sum = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map[s.charAt(i) - 'a'];
            sum = Math.max(sum + val, 0);
            if (max < sum) max = sum;
        }
        return Math.max(sum, max);
    }

    //10-15min
    //Runtime
    //18 ms
    //Beats
    //65.44%
    //Memory
    //43.2 MB
    //Beats
    //70.66%
    static int maximumCostSubstring1(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) map.put(chars.charAt(i), vals[i]);
        int sum = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = map.getOrDefault(c, c - 'a' + 1);
            if (sum + val > 0) sum += val;
            else sum = 0;
            if (max < sum) max = sum;
        }
        return Math.max(sum, max);
    }
}
