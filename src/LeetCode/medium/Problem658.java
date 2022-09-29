package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem658 {
    //https://leetcode.com/problems/find-k-closest-elements/
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,5,5,6,6,7,7,8,9}, 7, 7));
        System.out.println(findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5));
        System.out.println(findClosestElements(new int[]{1,2,2,2,5,5,5,8,9,9}, 4, 0));
        System.out.println(findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4));
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9));
    }

    //https://leetcode.com/problems/find-k-closest-elements/discuss/2638469/Java-Simple-Dimple-O(N)-Solution
    //2-3hours
    //Runtime: 12 ms, faster than 51.22% of Java online submissions for Find K Closest Elements.
    //Memory Usage: 61.4 MB, less than 83.15% of Java online submissions for Find K Closest Elements.
    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k == arr.length) return getList(arr, 0, arr.length - 1);
        int start = 0, end = arr.length - 1;
        while (start + k <= end) {
            int a = arr[start], b = arr[end];
            if (Math.abs(x - a) <= Math.abs(x - b)) {
                end--;
            } else {
                start++;
            }
        }
        return getList(arr, start, end);
    }

    private static List<Integer> getList(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<>(end - start + 1);
        for (int i = start; i <= end; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    static List<Integer> findClosestElements4(int[] arr, int k, int x) {
        if (k == arr.length) return getList(arr, 0, arr.length - 1);
        int start = 0, finalStart = 0, end = k - 1;
        int diffStart = Math.abs(arr[start++] - x),  diffEnd = Math.abs(arr[end++] - x);
        while (start + k < arr.length && end < arr.length){
            int tempDiffStart = Math.abs(arr[start] - x);
            int tempDiffEnd = Math.abs(arr[end] - x);
            if (diffStart > tempDiffStart) {
                diffStart = tempDiffStart;
                finalStart = start;
            }
            start++;
        }

        end = finalStart + k - 1;
        return getList(arr, finalStart, end);
    }


    //considered for strictly increasing arrays
    static List<Integer> findClosestElements3(int[] arr, int k, int x) {
        if (k == arr.length) return getList(arr, 0, arr.length - 1);
        if (x < arr[0]) {
            return getList(arr, 0, k - 1);
        } else if (x > arr[arr.length - 1]) {
            return getList(arr, arr.length - k, arr.length - 1);
        } else {
            int idx = Arrays.binarySearch(arr, x);
            if (idx < 0) {
                idx = Math.abs(idx);
            }
            if (k % 2 == 1) {
                int start = idx - (k / 2), end = idx + (k / 2);
                while (end >= arr.length) {
                    start--;
                    end--;
                }
                while (start < 0) {
                    start++;
                    end++;
                }
                return getList(arr, start, end); //check for corner cases
            } else {
                int start = idx - (k / 2), end = idx - 1 + (k / 2);
                while (end >= arr.length) {
                    start--;
                    end--;
                }
                while (start < 0) {
                    start++;
                    end++;
                }
                return getList(arr, start, end); // check for corner cases
            }
        }
    }

    private static void findElements(int[] arr, int k, int index) {
        int idxLeft = Math.max(index - 1, 0), idxRight = Math.min(arr.length - 1, index + 1);
        int diffLeft = arr[idxLeft];
        int diffRight = arr[idxRight];
        List<Integer> list = new ArrayList<>();
        while(list.size() < k) {
            if (diffLeft <= diffRight) {
                list.add(arr[idxLeft]);
                idxLeft--;
            }
        }
    }

}
