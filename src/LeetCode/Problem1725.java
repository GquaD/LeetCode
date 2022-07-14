package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1725 {
    //https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
    public static void main(String[] args) {
        System.out.println(countGoodRectangles(new int[][]{
                {5, 8},
                {3, 9},
                {5, 12},
                {16, 5}
        }));

        System.out.println(countGoodRectangles(new int[][]{
                {2, 3},
                {3, 7},
                {4, 3},
                {3, 7}
        }));
    }

    //Runtime: 1 ms, faster than 99.68% of Java online submissions for Number Of Rectangles That Can Form The Largest Square.
    //Memory Usage: 54.8 MB, less than 8.21% of Java online submissions for Number Of Rectangles That Can Form The Largest Square.
    static int countGoodRectangles(int[][] recs) {
        int max = 0, countMax = 0;
        for (int i = 0; i < recs.length; i++) {
            int sizeTemp = Math.min(recs[i][0], recs[i][1]);
            if (max < sizeTemp) {
                countMax = 1;
                max = sizeTemp;
            } else if (max == sizeTemp) {
                countMax++;
            }
        }
        return countMax;
    }
}
