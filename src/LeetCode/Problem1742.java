package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem1742 {
    //https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
    public static void main(String[] args) {
        System.out.println(countBalls(1, 10));
        System.out.println(countBalls(5, 15));
        System.out.println(countBalls(19, 28));
        System.out.println(countBalls(8, 16));
    }

    //Runtime: 96 ms, faster than 12.18% of Java online submissions for Maximum Number of Balls in a Box.
    //Memory Usage: 50.6 MB, less than 20.16% of Java online submissions for Maximum Number of Balls in a Box.
    static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i < highLimit + 1 ; i++) {
            int sumOfDigits = calcSumOfDigits(i);
            if (map.containsKey(sumOfDigits)) {
                map.put(sumOfDigits, map.get(sumOfDigits) + 1);
            } else {
                map.put(sumOfDigits, 1);
            }
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            int num = map.get(key);
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    private static int calcSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
