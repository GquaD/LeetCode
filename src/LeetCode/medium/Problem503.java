package LeetCode.medium;

import javafx.util.Pair;

import java.util.*;

public class Problem503 {
    //https://leetcode.com/problems/next-greater-element-ii/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,8,-1,-100,-1,222,1111111,-111111})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    //https://leetcode.com/problems/next-greater-element-ii/solutions/4192652/java-from-1630-ms-to-24-ms/
    //10 min
    //Runtime
    //24 ms
    //Beats
    //13.29%
    //Memory
    //47.3 MB
    //Beats
    //5.5%
    static int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            if (i < nums.length) {
                List<Integer> list = map.get(nums[i]);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(nums[i], list);
                }
                list.add(i);
            }
            int id = i % nums.length;
            for (int key : map.keySet()) {
                if (key < nums[id]) {
                    List<Integer> listIdx = map.get(key);
                    for (int idx : listIdx) arr[idx] = nums[id];
                    toRemove.add(key);
                } else break;
            }
            if (toRemove.size() > 0) {
                for (int key : toRemove) map.remove(key);
                toRemove.clear();
            }
        }
        return arr;
    }

    //
    //20 min
    //Runtime
    //1630 ms
    //Beats
    //5.50%
    //Memory
    //46.5 MB
    //Beats
    //5.5%
    static int[] nextGreaterElements1(int[] nums) {
        // 5 4 3 2 1
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            if (i < nums.length) {
                stack.add(new Pair<>(nums[i], i));
                Stack<Pair<Integer, Integer>> stack1 = new Stack<>();
                while (!stack.isEmpty()) {
                    Pair<Integer, Integer> pair = stack.pop();
                    if (pair.getKey() < nums[i]) {
                        arr[pair.getValue()] = nums[i];
                    } else {
                        stack1.push(pair);
                    }
                }
                stack = stack1;
            } else {
                if (stack.empty()) break;
                int idx = i % nums.length;
                Stack<Pair<Integer, Integer>> stack1 = new Stack<>();
                while (!stack.isEmpty()) {
                    Pair<Integer, Integer> pair = stack.pop();
                    if (pair.getKey() < nums[idx]) {
                        arr[pair.getValue()] = nums[idx];
                    } else {
                        stack1.push(pair);
                    }
                }
                stack = stack1;
            }
        }
        return arr;
    }
}
