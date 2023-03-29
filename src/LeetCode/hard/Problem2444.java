package LeetCode.hard;

public class Problem2444 {
    //https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 1,0,1}, 1, 1));
        System.out.println(countSubarrays(new int[]{1, 1,1,1}, 1, 1));
    }

    //nnnn
    //Runtime
    //7 ms
    //Beats
    //74.32%
    //Memory
    //61.3 MB
    //Beats
    //10.99%
    static long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minPos = -1, maxPos = minPos, leftBound = minPos;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) leftBound = i;
            if (nums[i] == minK) minPos = i;
            if (nums[i] == maxK) maxPos = i;
            res += Math.max(0, Math.min(minPos, maxPos) - leftBound);
        }
        return res;
    }

    static long countSubarrays2(int[] nums, int minK, int maxK) {
        long count = 0, countEqual = 0;
        if (minK == maxK) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == minK) countEqual++;
                else {
                    count += ((countEqual + 1L) * countEqual * 1L) / 2L;
                    countEqual = 0;
                }
            }
            if (countEqual > 0) count += ((countEqual + 1L) * countEqual * 1L) / 2L;
        } else {
            boolean containsMin = false, containsMax = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > maxK || nums[i] < minK) {
                    containsMin = false;
                    containsMax = false;
                }
                if (nums[i] == minK) containsMin = true;
                else if (nums[i] == maxK) containsMax = true;
                if (containsMin && containsMax) count++;
            }

        }
        return count;
    }

    //TLE 46/51
    static long countSubarrays1(int[] nums, int minK, int maxK) {
        long count = 0;
        if (minK == maxK) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == minK) count++;
                    else break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                boolean containsMin = false, containsMax = false;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > maxK || nums[j] < minK) break;
                    if (nums[j] == minK) containsMin = true;
                    else if (nums[j] == maxK) containsMax = true;
                    if (containsMin && containsMax) count++;
                }
            }
        }
        return count;
    }
}
