package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2610 {
    //https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(findMatrix(new int[]{1,3,4,1,2,3,1}));
    }

    //https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/solutions/3373315/java-using-frequency-map/
    //5 min
    //Runtime
    //3 ms
    //Beats
    //63.64%
    //Memory
    //43.3 MB
    //Beats
    //18.18%
    static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
            for (int i = 0; i < freq; i++) {
                if (list.size() - i > 0) {
                    list.get(i).add(key);
                } else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(key);
                    list.add(sub);
                }
            }
        }
        return list;
    }

    //5-10min
    //Runtime
    //4 ms
    //Beats
    //45.45%
    //Memory
    //43.5 MB
    //Beats
    //18.18%
    static List<List<Integer>> findMatrix1(int[] nums) {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        list.add(set);
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i], count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (!list.get(j).add(curr)) count++;
                else break;
            }
            if (count == list.size()) {
                Set<Integer> set1 = new HashSet<>();
                set1.add(curr);
                list.add(set1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Set<Integer> s : list) res.add(new ArrayList<>(s));
        return res;
    }
}
