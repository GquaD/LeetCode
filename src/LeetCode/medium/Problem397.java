package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem397 {
    //https://leetcode.com/problems/integer-replacement/
    public static void main(String[] args) {
        System.out.println(integerReplacement(Integer.MAX_VALUE-1));
        System.out.println(integerReplacement(Integer.MAX_VALUE));
        System.out.println(integerReplacement(413));
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));
        System.out.println(integerReplacement(13));
    }

    //https://leetcode.com/problems/integer-replacement/solutions/3593817/java-greedy-using-memoization-100-faster/
    //20-25 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.9 MB
    //Beats
    //18.15%
    static Map<Integer, Integer> map;
    static int integerReplacement(int n) {
        if (map == null) {
            map = new HashMap<>();
            map.put(Integer.MAX_VALUE, 32);
        }
        if (map.containsKey(n)) return map.get(n);

        int temp = n, count = 0;
        while (temp > 1 && !map.containsKey(temp)) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                if ((temp - 1) / 2 == 1 || ((temp - 1) / 2) % 2 == 0) {
                    temp--;
                } else {
                    temp++;
                }
            }
            count++;
        }
        if (temp > 1) {
            map.put(n, map.get(temp) + count);
            return map.get(n);
        }
        map.put(n, count);
        return count;
    }
}
