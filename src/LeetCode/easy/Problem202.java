package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem202 {
    //https://leetcode.com/problems/happy-number/
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy(23));
    }

    //https://leetcode.com/problems/happy-number/solutions/2799159/java-solution-using-map/
    //Runtime
    //3 ms
    //Beats
    //55.19%
    //Memory
    //41.5 MB
    //Beats
    //33.92%
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean isHappy(int n) {
        int sum = 0, temp = n, lastKey = -1;
        while (!map.containsKey(sum)) {
            sum = 0;
            int meme = temp;
            while (temp > 0) {
                int digit = temp % 10;
                temp /= 10;
                sum += digit * digit;
            }
            if (sum == 1) {
                map.remove(lastKey);
                return true;
            }
            map.put(meme, sum);
            lastKey = meme;
            temp = sum;
        }
        return false;
    }
}
