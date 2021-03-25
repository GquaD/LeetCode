package LeetCode;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by Behzod on 25, March, 2021
 */
public class Problem1672 {
    public static void main(String[] args) {
        int[][] one = {{1, 2, 3}, {3, 2, 1}};
        int[][] two = {{1, 5}, {7, 3}, {3, 5}};
        int[][] three = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(maximumWealth1(one));
        System.out.println(LocalDateTime.now());
        System.out.println(maximumWealth1(two));
        System.out.println(maximumWealth1(three));
    }

    public static int maximumWealth(int[][] accounts) {
        System.out.println(LocalDateTime.now());
        return Arrays.stream(accounts)
                .map(p -> Arrays.stream(p).sum())
                .collect(Collectors.toList()).stream().max(Comparator.comparing(Integer::intValue)).get();
    }

    public static int maximumWealth1(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int current = Arrays.stream(accounts[i]).sum();
            if (max < current) max = current;
        }
        return max;
    }
}
