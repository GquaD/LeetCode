package LeetCode.easy;

import java.util.Arrays;

public class Problem492 {
    //https://leetcode.com/problems/construct-the-rectangle/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(37)));
        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(122122)));
    }

    static int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area), w = area / l;
        while (l * w != area) {
            l = Math.min(area, l + 1);
            w = Math.max(1, w - 1);
        }
        return new int[]{l, w};
    }
}
