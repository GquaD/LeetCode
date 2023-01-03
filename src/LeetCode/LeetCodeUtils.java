package LeetCode;

import LeetCode.medium.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeUtils {
    public static void printList(List list) {
        if (list.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(obj + ", ");
        }
        String s = sb.toString();
        System.out.println(s.substring(0, s.length() - 2));
        //check
    }

    public static void printListWithListsOfIntegers(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            printList(list.get(i));
        }
    }

    public static void printListWithListsOfStrings(List<List<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            printList(list.get(i));
        }
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

    public static ListNode generateList(int[] arr) {
        ListNode head = new ListNode(arr[0]), temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
}
