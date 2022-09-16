package LeetCode.easy;

public class Problem1295 {
    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
    }

    //Runtime: 2 ms, faster than 64.78% of Java online submissions for Find Numbers with Even Number of Digits.
    //Memory Usage: 43.6 MB, less than 40.68% of Java online submissions for Find Numbers with Even Number of Digits.
    static int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int d6 = nums[i] / 100_000;
            if (d6 > 0 && d6 < 10) {
                res++;
                continue;
            }
            d6 = nums[i] / 1_000;
            if (d6 > 0 && d6 < 10) {
                res++;
                continue;
            }
            d6 = nums[i] / 10;
            if (d6 > 0 && d6 < 10) {
                res++;
                continue;
            }
        }
        return res;
    }

    //Runtime: 3 ms, faster than 26.88% of Java online submissions for Find Numbers with Even Number of Digits.
    //Memory Usage: 44.7 MB, less than 5.78% of Java online submissions for Find Numbers with Even Number of Digits.
    static int findNumbers1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            if (s.length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
