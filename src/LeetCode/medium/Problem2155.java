package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2155 {
    //https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
    public static void main(String[] args) {
        LeetCodeUtils.printList(maxScoreIndices(new int[]{0}));
        LeetCodeUtils.printList(maxScoreIndices(new int[]{1}));
        LeetCodeUtils.printList(maxScoreIndices(new int[]{0,0,1,0}));
        LeetCodeUtils.printList(maxScoreIndices(new int[]{0,0,0}));
        LeetCodeUtils.printList(maxScoreIndices(new int[]{1,1}));
    }

    //https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/solutions/4218399/java-o-n-optimized-from-70ms-to-17ms/
    //10 min
    //Runtime
    //17 ms
    //Beats
    //61.98%
    //Memory
    //59.2 MB
    //Beats
    //96.69%
    static List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length, left[] = new int[len + 1], right[] = new int[len], count0 = 0, count1 = 0;
        for (int i = 0; i < len; i++) {
            left[i] = count0;
            if (nums[i] == 0) count0++;
        }
        left[len] = count0;

        for (int i = len - 1; i >= 0 ; i--) {
            if (nums[i] == 1) count1++;
            right[i] = count1;
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int score = left[i] + right[i];
            if (max < score) {
                max = score;
                list.clear();
                list.add(i);
            } else if (max == score) {
                list.add(i);
            }
        }

        int score = left[len];
        if (max < score) {
            list.clear();
            list.add(len);
        } else if (max == score) {
            list.add(len);
        }
        return list;
    }


    //15-20min
    //Runtime
    //70 ms
    //Beats
    //12.40%
    //Memory
    //74.9 MB
    //Beats
    //5.79%
    static List<Integer> maxScoreIndices1(int[] nums) {
        int len = nums.length, left[] = new int[len + 1], right[] = new int[len], count0 = 0, count1 = 0;
        for (int i = 0; i < len; i++) {
            left[i] = count0;
            if (nums[i] == 0) count0++;
        }
        left[len] = count0;

        for (int i = len - 1; i >= 0 ; i--) {
            if (nums[i] == 1) count1++;
            right[i] = count1;
        }

        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int score = left[i] + right[i];
            max = Math.max(score, max);
            List<Integer> listIdx = map.get(score);
            if (listIdx == null) {
                listIdx = new ArrayList<>();
                map.put(score, listIdx);
            }
            listIdx.add(i);
        }

        int score = left[len];
        max = Math.max(score, max);
        List<Integer> listIdx = map.get(score);
        if (listIdx == null) {
            listIdx = new ArrayList<>();
            map.put(score, listIdx);
        }
        listIdx.add(len);
        return map.get(max);
    }
}
