package LeetCode.medium;

import java.util.*;

public class Problem2415 {
    //https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        reverseOddLevels(node1);
    }

    //https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/solutions/2890399/java-2-solutions-stack-vs-queue-o-n-n-dfs/
    //queue solution is best
    //Runtime
    //18 ms
    //Beats
    //45.58%
    //Memory
    //74.2 MB
    //Beats
    //32.9%

    static TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        traverseBSTWatchTwo(root, map, 0);
        traverseBSTInsertTwo(root, map, 0);
        return root;
    }

    private static void traverseBSTInsertTwo(TreeNode node, Map<Integer, Stack<Integer>> map, int lvl) {
        if (node == null) return;

        if (lvl % 2 == 1) {
            node.val = map.get(lvl).pop();
        }

        lvl++;
        traverseBSTInsertTwo(node.left, map, lvl);
        traverseBSTInsertTwo(node.right, map, lvl);
    }

    private static void traverseBSTWatchTwo(TreeNode node, Map<Integer, Stack<Integer>> map, int lvl) {
        if (node == null) return;

        if (lvl % 2 == 1) {
            Stack<Integer> stack = map.get(lvl);
            if (stack == null) {
                stack = new Stack<>();
                stack.push(node.val);
                map.put(lvl, stack);
            } else {
                stack.push(node.val);
            }
        }

        lvl++;
        traverseBSTWatchTwo(node.left, map, lvl);
        traverseBSTWatchTwo(node.right, map, lvl);
    }


    static TreeNode reverseOddLevels1(TreeNode root) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        traverseBSTLeft(root, map, 0);
        traverseBSTRight(root, map, 0);
        return root;
    }

    private static void traverseBSTRight(TreeNode node, Map<Integer, Queue<Integer>> map, int lvl) {
        if (node == null) return;

        if (lvl % 2 == 1) {
            Queue<Integer> queue = map.get(lvl);
            node.val = queue.poll();
        }
        lvl++;
        traverseBSTRight(node.right, map, lvl);
        traverseBSTRight(node.left, map, lvl);
    }

    private static void traverseBSTLeft(TreeNode node, Map<Integer, Queue<Integer>> map, int lvl) {
        if (node == null) return;

        if (lvl % 2 == 1) {
            Queue<Integer> queue = map.get(lvl);
            if (queue == null) {
                queue = new LinkedList<>();
                queue.add(node.val);
                map.put(lvl, queue);
            } else {
                queue.add(node.val);
            }
        }

        lvl++;
        traverseBSTLeft(node.left, map, lvl);
        traverseBSTLeft(node.right, map, lvl);
    }


}
