package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeUtils {
    public static void printList(List list) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(obj + ", ");
        }
        String s = sb.toString();
        System.out.println(s.substring(0, s.length() - 2));
    }

    public static Map<Integer, Integer> getFrequencyMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
