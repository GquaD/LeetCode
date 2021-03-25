package LeetCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behzod on 24, March, 2021
 */
public class Problem1431 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println(kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[] {4, 2, 1, 1, 2}, 1));
        System.out.println(kidsWithCandies(new int[] {12, 1, 12}, 10));
        System.out.println(LocalDateTime.now());
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else result.add(false);
        }
        return result;
    }
}
