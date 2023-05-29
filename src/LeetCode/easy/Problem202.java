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
    //1 ms
    //Beats
    //88.80%
    //Memory
    //39.9 MB
    //Beats
    //43.39%

    static boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, temp = n;
        while (!map.containsKey(sum)) {
            sum = 0;
            int meme = temp;
            while (temp > 0) {
                int digit = temp % 10;
                temp /= 10;
                sum += digit * digit;
            }
            if (sum == 1) {
                return true;
            }
            map.put(meme, sum);
            temp = sum;
        }
        return false;
    }
}
