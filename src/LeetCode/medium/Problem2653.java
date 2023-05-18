package LeetCode.medium;

import java.util.*;

public class Problem2653 {
    //https://leetcode.com/problems/sliding-subarray-beauty/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{1,-1,-3,-2,3}, 3, 2)));
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{1,-1,-3,-2,3}, 3, 3)));
    }

    //https://leetcode.com/problems/sliding-subarray-beauty/solutions/3538695/java-treemap-slow-solution/
    //50 min
    //Runtime
    //2010 ms
    //Beats
    //5.2%
    //Memory
    //62.2 MB
    //Beats
    //10.77%
    static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        int count = 0, c = 0;
        int[] res = new int[nums.length - k + 1];
        for (int key : map.keySet()) {
            count += map.get(key);
            if (count >= x) {
                res[c] = Math.min(key, 0);
                break;
            }
        }
        for (int i = k; i < nums.length; i++) {
            int kk = map.get(nums[c]);
            if (kk == 0) map.remove(nums[c]);
            else map.put(nums[c], kk - 1);
            c++;
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
            count = 0;
            for (int key : map.keySet()) {
                count += map.get(key);
                if (count >= x) {
                    res[c] = Math.min(key, 0);
                    break;
                }
            }
        }
        return res;
    }

    static int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) list.add(nums[i]);
        List<Integer> listSort = new ArrayList<>(list);
        Collections.sort(listSort);
        res[0] = Math.min(listSort.get(x - 1), 0);
        for (int i = k; i < nums.length; i++) {
            list.remove(0);
            list.add(nums[i]);
            listSort = new ArrayList<>(list);
            Collections.sort(listSort);
            res[i - k + 1] = Math.min(listSort.get(x - 1), 0);
        }
        return res;
    }

    //TLE 703 / 717
    static int[] getSubarrayBeauty1(int[] nums, int k, int x) {
        int[] arr = new int[k], res = new int[nums.length - k + 1];
        for (int i = k; i <= nums.length; i++) {
            int c = 0;
            for (int j = i - k; j < i; j++) arr[c++] = nums[j];
            Arrays.sort(arr);
            res[i - k] = Math.min(arr[x - 1], 0);
        }
        return res;
    }
}
