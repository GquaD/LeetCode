package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1716 {
    //https://leetcode.com/problems/calculate-money-in-leetcode-bank/
    public static void main(String[] args) {
        System.out.println(totalMoney(1));
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
    }

    //https://leetcode.com/problems/calculate-money-in-leetcode-bank/solutions/2799050/java-100-faster-3-solutions/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.1 MB
    //Beats
    //88.96%

    static int[] values = new int[1000];
    static int totalMoney(int n) {
        if (values[0] == 0) {
            fillArray();
        }
        return values[n - 1];
    }

    static void fillArray() {
        int count = 0, sum = 0, increment = 1;
        for (int i = 1; i <= 1000 ; i++) {
            if (count % 7 == 0) {
                increment = 1 + (count / 7);
            }
            sum += increment;
            values[i - 1] = sum;
            count++;
            increment++;
        }
    }

    //Runtime
    //1 ms
    //Beats
    //80.4%
    //Memory
    //41.6 MB
    //Beats
    //7.64%
    static Map<Integer, Integer> map = new HashMap<>();
    static int totalMoney2(int n) {
        if (map.size() == 0) {
            fillMap();
        }
        return map.get(n);
    }

    static void fillMap() {
        int count = 0, sum = 0, increment = 1;
        for (int i = 1; i <= 1000 ; i++) {
            if (count % 7 == 0) {
                increment = 1 + (count / 7);
            }
            sum += increment;
            map.put(i, sum);
            count++;
            increment++;
        }
    }

    //thinking of O(N) took 15-20 mins
    //code writing 5 mins
    //Runtime
    //1 ms
    //Beats
    //80.4%
    //Memory
    //41.4 MB
    //Beats
    //16.99%
    public int totalMoney1(int n) {
        int whole = n / 7, part = n % 7, sum = 0;
        for (int i = 1; i <= whole; i++) {
            sum += (i + 3) * 7;
        }
        sum += ((whole + 1 + whole + part) * part) / 2;
        return sum;
    }
}
