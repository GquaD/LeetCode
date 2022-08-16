package LeetCode.medium;

import java.util.Arrays;

public class Problem1442 {
    //https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,6,7};
        System.out.println("Result of " + Arrays.toString(arr) + " is " + countTriplets(arr));
        System.out.println();
        int[] arr1 = new int[]{1,1,1,1,1};
        System.out.println("Result of " + Arrays.toString(arr) + " is " + countTriplets(arr1));
    }

    //todo
    //35 mins
    //Runtime: 270 ms, faster than 5.10% of Java online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
    //Memory Usage: 41.2 MB, less than 82.35% of Java online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
    static int countTriplets(int[] arr) {
        int countResult = 0;

        int xor1;
        for (int i = 0; i < arr.length; i++) {
            xor1 = arr[i];
            for (int j = 1; j < arr.length; j++) {
                if (i < j && j - 1 != i) {
                    xor1 ^= arr[j - 1];
                }
                int xor2 = arr[j];
                for (int k = 1; k < arr.length; k++) {
                    if (j < k) {
                        xor2 ^= arr[k];
                    }
                    if (i < j && xor1 == xor2 && j <= k) {
                        countResult++;
                        System.out.println("i = " + i + ", j = " + j + ", k = " + k);
                    }
                }
            }
        }
        return countResult;
    }
}
