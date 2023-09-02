package LeetCode.medium;

import java.util.*;

public class Problem2385 {
    //https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(6);
        n1.left = n2;
        n2.right = n3;
        n3.left = n4;
        n3.right = n5;
//        n1.right = n6;
        n6.left = n7;
        n6.right = n8;
        System.out.println(amountOfTime(new TreeNode(2), 2));
        System.out.println(amountOfTime(n1, 1));
    }

    //https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/solutions/3993404/java-dfs-bfs-solution/
    //1-2hrs
    //Runtime
    //99 ms
    //Beats
    //64.12%
    //Memory
    //129.1 MB
    //Beats
    //5.6%
    static int amountOfTime(TreeNode root, int start) {
        if (root.left == null && root.right == null) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, -1);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int time = 0;
        Queue<Integer> queueNext = new LinkedList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> l = map.get(curr);
            for (int i = 0; i < l.size(); i++) {
                if (!visited.contains(l.get(i))) {
                    queueNext.add(l.get(i));
                    visited.add(l.get(i));
                }
            }
            if (queue.isEmpty()) {
                queue = queueNext;
                queueNext = new LinkedList<>();
                time++;
            }
        }
        return time;
    }

    private static void dfs(TreeNode node, Map<Integer, List<Integer>> map, int parent) {
        if (node == null) return;

        List<Integer> list = new ArrayList<>();
        if (parent > 0) list.add(parent);
        if (node.left != null) list.add(node.left.val);
        if (node.right != null) list.add(node.right.val);
        map.put(node.val, list);

        dfs(node.left, map, node.val);
        dfs(node.right, map, node.val);
    }

    //Wrong Answer
    //73 / 80 testcases passed
    //data[0] - is max level, data[1] is level of start
    static int amountOfTime1(TreeNode root, int start) {
        if (root.left == null && root.right == null) return 0;
        int[] dataLeft = new int[]{0, -1}, dataRight = new int[]{0, -1};
        if (root.val == start) {
            dataLeft[1] = 0;
            dataRight[1] = 0;
        }
        dfs(root.left, 1, start, dataLeft);
        dfs(root.right, 1, start, dataRight);
        if (dataLeft[1] > 0) {
            return Math.max(dataRight[0] + dataLeft[1], dataLeft[0] - dataLeft[1]);
        } else {
            return Math.max(dataRight[1] + dataLeft[0], dataRight[0] - dataRight[1]);
        }
        //return dataLeft[1] > 0 ? dataRight[0] + dataLeft[1] + 2 : dataRight[1] + dataLeft[0] + 2;
    }

    private static void dfs(TreeNode node, int lvl, int start, int[] data) {
        if (node == null) return;

        if (lvl > data[0]) data[0] = lvl;
        if (node.val == start) data[1] = lvl;

        dfs(node.left, lvl + 1, start, data);
        dfs(node.right, lvl + 1, start, data);
    }
}
