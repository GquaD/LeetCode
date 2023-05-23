package LeetCode.easy;

import java.util.*;

public class Problem703 {
    //https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

    public static void main(String[] args) {
        KthLargest largest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(largest.add(3));
        System.out.println(largest.add(5));
        System.out.println(largest.add(10));
        System.out.println(largest.add(9));
        System.out.println(largest.add(4));
    }
}

//https://leetcode.com/problems/kth-largest-element-in-a-stream/solutions/3556153/java-simple-solution/
//Runtime
//26 ms
//Beats
//10.62%
//Memory
//49.6 MB
//Beats
//5.82%
class KthLargest {

    List<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) list.add(nums[i]);
    }

    public int add(int val) {
        int idx = Collections.binarySearch(list, val);
        list.add(idx < 0 ? -idx - 1 : idx, val);
        return list.get(list.size() - k);
    }
}
