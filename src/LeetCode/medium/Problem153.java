package LeetCode.medium;

import java.util.Arrays;

public class Problem153 {
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }

    //15 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.8 MB
    //Beats
    //92.1%
    static int findMin(int[] nums) {
        int min = 5_001, idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                idx = i;
            }
        }
        return nums[idx];
    }

    private static int binarySearch(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            int valPrev = Math.max(mid - 1, 0);

            if (midVal < key) {
                low = mid + 1;
                key = Math.min(valPrev, midVal);
            } else if (midVal > key) {
                high = mid - 1;
            }
        }
        return key;
    }
}
