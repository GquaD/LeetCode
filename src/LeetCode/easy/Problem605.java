package LeetCode.easy;

public class Problem605 {
    //https://leetcode.com/problems/can-place-flowers/description/
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,0,1}, 2));
    }

    //https://leetcode.com/problems/can-place-flowers/solutions/3318388/java-100-faster-solution/
    //15 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //44.8 MB
    //Beats
    //10.7%
    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countTemp0 = 0, countAll = 0;
        boolean contains1 = false;
        for (int i = 0; i < flowerbed.length; i++) {
            int curr = flowerbed[i];
            if (curr == 1) {
                if (!contains1 && countTemp0 > 1) countAll += countTemp0 / 2;
                else if (countTemp0 > 2) countAll += (countTemp0 - 1) / 2;
                countTemp0 = 0;
                contains1 = true;
            } else {
                countTemp0++;
            }
        }
        if (!contains1) {
            if (countTemp0 % 2 == 1) countAll = countTemp0 / 2 + 1;
            else countAll = countTemp0 / 2;
        } else if (countTemp0 > 1) countAll += countTemp0 / 2;
        return countAll >= n;
    }
}
