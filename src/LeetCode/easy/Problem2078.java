package LeetCode.easy;

public class Problem2078 {
    //https://leetcode.com/problems/two-furthest-houses-with-different-colors/
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}));
        System.out.println(maxDistance(new int[]{1, 8, 3, 8, 3}));
        System.out.println(maxDistance(new int[]{0, 1}));
    }

    //Runtime: 3 ms, faster than 26.68% of Java online submissions for Two Furthest Houses With Different Colors.
    //Memory Usage: 41.4 MB, less than 83.36% of Java online submissions for Two Furthest Houses With Different Colors.
    static int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j] && j - i > max) {
                    max = j - i;
                }
            }
        }
        return max;
    }
}
