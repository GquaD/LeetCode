package LeetCode.hard;

import java.util.Arrays;

public class Problem2449 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/
    public static void main(String[] args) {
        System.out.println(makeSimilar(new int[]{8, 12, 6}, new int[]{2, 14, 10}));
        System.out.println(makeSimilar(new int[]{1, 2, 5}, new int[]{4, 1, 3}));
        System.out.println(makeSimilar(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/solutions/2945097/java-99-time-99-5-memory-o-n-nlogn/
    //20-30 mins
    //Runtime
    //44 ms
    //Beats
    //98.83%
    //Memory
    //57.5 MB
    //Beats
    //99.16%
    static long makeSimilar(int[] nums, int[] target) {
        //find odd and even and place them into different arrays
        int odd = 0, even = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 2 == 0) even++;

        odd = nums.length - even;
        int[] oddNums = new int[odd], evenNums = new int[even];
        int countOdd = 0, countEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) evenNums[countEven++] = nums[i];
            else oddNums[countOdd++] = nums[i];
        }
        int[] oddT = new int[odd], evenT = new int[even];
        countOdd = 0;
        countEven = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] % 2 == 0) evenT[countEven++] = target[i];
            else oddT[countOdd++] = target[i];
        }

        Arrays.sort(oddNums);
        Arrays.sort(evenNums);
        Arrays.sort(oddT);
        Arrays.sort(evenT);
        long countUp = 0, countDown = 0;
        for (int i = 0; i < oddNums.length; i++) {
            int diff = oddT[i] - oddNums[i];
            if (diff == 0) continue;
            if (diff > 0) countUp += diff / 2;
            else countDown += Math.abs(diff) / 2;
        }
        for (int i = 0; i < evenNums.length; i++) {
            int diff = evenT[i] - evenNums[i];
            if (diff == 0) continue;
            if (diff > 0) countUp += diff / 2;
            else countDown += Math.abs(diff) / 2;
        }
        return Math.min(countUp, countDown);
    }
}
