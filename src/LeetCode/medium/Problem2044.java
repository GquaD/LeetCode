package LeetCode.medium;

public class Problem2044 {
    //https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3, 2, 1, 5})); //6
        System.out.println(countMaxOrSubsets(new int[]{3, 1})); //2
        System.out.println(countMaxOrSubsets(new int[]{2, 2, 2})); // 7
    }

    //2-3 hours
    //Runtime: 14 ms, faster than 65.34% of Java online submissions for Count Number of Maximum Bitwise-OR Subsets.
    //Memory Usage: 41.2 MB, less than 87.25% of Java online submissions for Count Number of Maximum Bitwise-OR Subsets.
    static int count;
    static int max;
    static int[] arr;

    static int countMaxOrSubsets(int[] nums) {
        count = 0;
        max = 0;
        arr = nums;
        for (int i = 0; i < nums.length; i++) {
            max |= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            findCount(i, 0);
        }
        return count;
    }

    private static void findCount(int idxStart, int orResult) {
        if (idxStart >= arr.length) return;
        orResult |= arr[idxStart];
        if (orResult == max) {
            count++;
        }
        for (int i = idxStart + 1; i < arr.length; i++) {
            findCount(i, orResult);
        }
    }



    //wrong
    private static int findCount1(int idxStart, int idxCurr, int orResult) {
        if (idxStart >= arr.length || idxCurr >= arr.length) return count;
        if (idxStart == idxCurr) {
            orResult = arr[idxStart];
        } else {
            orResult |= arr[idxCurr];
        }
        if (orResult == max) {
            count++;
        }
        return findCount1(idxStart, idxCurr + 1, orResult) + findCount1(idxStart + 1, idxCurr, orResult);
    }

    private static void findCount(int idxStart, int idxCurr, int orResult) {
        if (idxStart >= arr.length || idxCurr >= arr.length) return;
        if (idxStart == idxCurr) {
            orResult = arr[idxStart];
        } else {
            orResult |= arr[idxCurr];
        }
        if (orResult == max) {
            count++;
        }

        for (int i = idxStart; i < arr.length; i++) {
            findCount(i, idxCurr + 1, orResult);
        }
    }

    private static void findCountArray(int[] nums, int index) {
        if (index >= nums.length) return;
        int or = 0;

        for (int i = 0; i < nums.length; i++) {
            or |= nums[i];
        }

        if (or == max) count++;

        int temp = nums[index];
        nums[index] = 0;
        for (int i = index; i < nums.length; i++) {
            findCountArray(nums, index + 1);
        }
        nums[index] = temp;
    }


    /*private static void findMaxSubsetsRecursively(int[] nums) {
        if (nums.length == 0) return;
        int n = nums[0];
        int or = n;

        for (int i = 1; i < nums.length; i++) {
            or |= nums[i];
        }
        if (or == max) {
            count++;
        }
        or = n;
        int[]
    }*/
}
