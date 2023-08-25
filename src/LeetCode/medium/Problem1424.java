package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1424 {
    //https://leetcode.com/problems/diagonal-traverse-ii/
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
//        nums.add(Arrays.asList(1, 2, 3, 4, 5));
//        nums.add(Arrays.asList(6, 7));
//        nums.add(Arrays.asList(8));
//        nums.add(Arrays.asList(9, 10, 11));
//        nums.add(Arrays.asList(12, 13, 14, 15, 16));
        nums.add(Arrays.asList(14, 12, 19, 16, 9));
        nums.add(Arrays.asList(13, 14, 15, 80, 11));
        nums.add(Arrays.asList(11, 13, 10));
        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

    //nnn the idea of i + j
    //30min
    //Runtime
    //18 ms
    //Beats
    //96.83%
    //Memory
    //61.2 MB
    //Beats
    //93.65%
    static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (list.size() <= i + j) list.add(new ArrayList<>());
                list.get(i + j).add(nums.get(i).get(j));
                count++;
            }
        }
        int arr[] = new int[count], c = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.get(i).size() - 1; j >= 0; j--) {
                arr[c++] = list.get(i).get(j);
            }
        }
        return arr;
    }

    //Time Limit Exceeded
    //53 / 56
    static int[] findDiagonalOrder1(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();
        int idxMax = 0, maxSize = 0;
        for (int i = 0; i < nums.size(); i++) {
            int r = i, j = 0;
            while (r >= 0) {
                if (r < nums.size() && j < nums.get(r).size()) list.add(nums.get(r).get(j));
                r--;
                j++;
            }
            if (maxSize < nums.get(i).size()) {
                maxSize = nums.get(i).size();
                idxMax = i;
            }
        }
        List<Integer> listMax = nums.get(idxMax);
        if (listMax.size() > 1) {
            for (int i = 1; i < listMax.size(); i++) {
                int c = i;
                for (int j = nums.size() - 1; j >= 0; j--) {
                    if (c < nums.get(j).size()) list.add(nums.get(j).get(c));
                    c++;
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}
