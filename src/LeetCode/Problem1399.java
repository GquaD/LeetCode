package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem1399 {
    //https://leetcode.com/problems/count-largest-group/
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
        System.out.println(countLargestGroup(100));
        System.out.println(countLargestGroup(2000));
    }

    //Runtime: 19 ms, faster than 37.22% of Java online submissions for Count Largest Group.
    //Memory Usage: 42.6 MB, less than 21.43% of Java online submissions for Count Largest Group.
    static int countLargestGroup(int n) {
        if (n < 10) return n;
        //sum of digits -> count
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sumOfDigits = calcSumOfDigits(i);
            if (map.containsKey(sumOfDigits)) {
                int temp = map.get(sumOfDigits) + 1;
                if (max < temp) {
                    max = temp;
                }
                map.put(sumOfDigits, temp);
            } else {
                map.put(sumOfDigits, 1);
            }
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                count++;
            }
        }
        return count;
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
