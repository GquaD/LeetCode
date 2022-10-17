package LeetCode.medium;

import java.util.*;

public class Problem1743 {
    //https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(restoreArray(new int[][]{
                {2,1},
                {3,4},
                {3,2}
        })));
        System.out.println(Arrays.toString(restoreArray(new int[][]{
                {4,-2},
                {1,4},
                {-3,1}
        })));
        System.out.println(Arrays.toString(restoreArray(new int[][]{
                {100000,-100000}
        })));
    }

    //https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/solutions/2713724/java-solution-using-tree-and-hashmap/
    //2-3 hours
    //Runtime
    //325 ms
    //Beats
    //30.71%
    //Memory
    //157.7 MB
    //Beats
    //69.52%
    static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int one = adjacentPairs[i][0];
            int two = adjacentPairs[i][1];
            if (!freq.containsKey(one)) {
                freq.put(one, 1);
            } else {
                freq.put(one, 2);
            }
            if (!freq.containsKey(two)) {
                freq.put(two, 1);
            } else {
                freq.put(two, 2);
            }

            if (!map.containsKey(one)) {
                map.put(one, new TreeNode(one));
            }
            if (!map.containsKey(two)) {
                map.put(two, new TreeNode(two));
            }
        }

        for (int i = 0; i < adjacentPairs.length; i++) {
            int one = adjacentPairs[i][0];
            int two = adjacentPairs[i][1];
            TreeNode node = map.get(one);
            if (node.left == null) {
                node.left = map.get(two);
            } else {
                TreeNode node2 = map.get(two);
                node.right = node2;
            }
            TreeNode node1 = map.get(two);
            if (node1.left == null) {
                node1.left = map.get(one);
            } else {
                TreeNode node2 = map.get(one);
                node1.right = node2;
            }
        }

        int start = 0;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                start = key;
                break;
            }
        }

        int[] result = new int[adjacentPairs.length + 1];
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        while (map.containsKey(start)) {
            TreeNode node = map.get(start);
            result[count++] = node.val;
            if (node.left != null && node.left.val != node.val && !visited.contains(node.left.val)){
                start = node.left.val;
            } else if (node.right != null && !visited.contains(node.right.val)){
                start = node.right.val;
            } else {
                start = Integer.MAX_VALUE;
            }
            visited.add(node.val);
        }
        return result;
    }

    static int[] restoreArray2(int[][] adjacentPairs) {
        Map<Integer, ListNode> map = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int one = adjacentPairs[i][0];
            int two = adjacentPairs[i][1];
            //building map with frequencies
            if (!freq.containsKey(one)) {
                freq.put(one, 1);
            } else {
                freq.put(one, 2);
            }
            if (!freq.containsKey(two)) {
                freq.put(two, 1);
            } else {
                freq.put(two, 2);
            }
            //building map of listnodes
            if (!map.containsKey(one)) {
                map.put(one, new ListNode(one));
            }
            if (!map.containsKey(two)) {
                map.put(two, new ListNode(two));
            }
        }

        for (int i = 0; i < adjacentPairs.length; i++) {
            int one = adjacentPairs[i][0];
            int two = adjacentPairs[i][1];
            ListNode node = map.get(one);
            if (node.next == null) {
                node.next = map.get(two);
            } else {
                ListNode node2 = map.get(two);
                node2.next = node;
            }
        }

        int start = 0;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                start = key;
                break;
            }
        }

        int[] result = new int[adjacentPairs.length + 1];
        int count = 0;
        while (map.containsKey(start)) {
            ListNode node = map.get(start);
            result[count++] = node.val;
            if (node.next != null){
                start = node.next.val;
            }
        }
        return result;
    }

    static int[] restoreArray1(int[][] adjacentPairs) {
        Map<Integer, ListNode> map = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int one = adjacentPairs[i][0];
            int two = adjacentPairs[i][1];
            if (!map.containsKey(one)) {
                ListNode node = new ListNode(one);
                if (!map.containsKey(two)) {
                    node.next = new ListNode(two);
                    map.put(two, node.next);
                } else {
                    node.next = map.get(two);
                }
                map.put(one, node);
            } else {
                ListNode node = map.get(one);
                if (!map.containsKey(two)) {
                    node.next = new ListNode(two);
                    map.put(two, node.next);
                } else {
                    node.next = map.get(two);
                }
            }

            if (map.containsKey(two)) {
                ListNode node = map.get(two);
                if (!map.containsKey(one)) {
                    node.next = new ListNode(one);
                    map.put(one, node.next);
                } else {
                    node.next = map.get(one);
                }
            }

            if (!freq.containsKey(one)) {
                freq.put(one, 1);
            } else {
                freq.put(one, 2);
            }
            if (!freq.containsKey(two)) {
                freq.put(two, 1);
            } else {
                freq.put(two, 2);
            }
        }
        int start = 0;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                start = key;
                break;
            }
        }
        int[] result = new int[adjacentPairs.length + 1];
        int count = 0;
        while (map.containsKey(start)) {
            ListNode node = map.get(start);
            result[count++] = node.val;
            if (node.next != null){
                start = node.next.val;
            }
        }
        return result;
    }


}
