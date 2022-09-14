package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem969 {
    //https://leetcode.com/problems/pancake-sorting/
    public static void main(String[] args) {
        LeetCodeUtils.printList(pancakeSort(new int[]{3,2,4,1}));
        LeetCodeUtils.printList(pancakeSort(new int[]{5,4,3,2,1}));
        LeetCodeUtils.printList(pancakeSort(new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/pancake-sorting/discuss/2574714/Java-Solution
    //Runtime: 3 ms, faster than 23.59% of Java online submissions for Pancake Sorting.
    //Memory Usage: 43.7 MB, less than 15.12% of Java online submissions for Pancake Sorting.
    static List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int max = n;
        int idxToPlace = n - 1;
        for (int i = 0; i < n; i++) {
            if (arraySorted(arr)) {
                return list;
            }
            int k = findIndexOfMax(max, arr);
            if (k != 0) {
                flipArray(k, arr);
                list.add(k + 1);
            }
            if (arraySorted(arr)) {
                return list;
            }
            flipArray(idxToPlace, arr);
            list.add(idxToPlace + 1);
            max--;
            idxToPlace--;
        }
        return list;
    }

    private static int findIndexOfMax(int max, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) return i;
        }
        return -1;
    }

    private static void flipArray(int k, int[] arr) {
        for (int i = 0; i <= k / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[k - i];
            arr[k - i] = temp;
        }
    }

    private static boolean arraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    private static void flipArrayToPlaceMaxToEnd(int idxToPlace, int[] arr) {
        for (int i = 0; i <= idxToPlace / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[idxToPlace - i];
            arr[idxToPlace - i] = temp;
        }
    }

}
