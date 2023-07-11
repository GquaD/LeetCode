package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem863 {
    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n0.left = n2;
        n0.right = n1;
        n1.left = n3;
        LeetCodeUtils.printList(distanceK(n0, n3, 3));
    }

    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solutions/3751130/java-dfs-bfs-solution/
    //30-40 min
    //Runtime
    //13 ms
    //Beats
    //45.52%
    //Memory
    //41.7 MB
    //Beats
    //80.75%
    static boolean isFound;

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //use stack to save parents in dfs
        //find the target's parents
        //then use bfs to calc distance
        List<Integer> res = new ArrayList<>();
        if (k == 0) {
            res.add(target.val);
            return res;
        }
        isFound = false;
        Stack<TreeNode> parents = new Stack<>();
        dfsToFind(root, target, parents);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(target.val);
        int count = 1;
        if (!parents.isEmpty()) queue.add(parents.pop());
        if (target.left != null) queue.add(target.left);
        if (target.right != null) queue.add(target.right);

        while (!queue.isEmpty()) {
            if (count++ == k) break;
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                set.add(node.val);
                if (node.left != null && !set.contains(node.left.val)) {
                    tempQueue.offer(node.left);
                }
                if (node.right != null && !set.contains(node.right.val)) {
                    tempQueue.offer(node.right);
                }
            }
            if (!parents.isEmpty()) tempQueue.add(parents.pop());
            queue = tempQueue;
        }
        while (!queue.isEmpty()) res.add(queue.poll().val);
        return res;
    }

    private static void dfsToFind(TreeNode node, TreeNode target, Stack<TreeNode> stack) {
        if (node == null) return;
        if (node == target) {
            isFound = true;
            return;
        }
        if (!isFound) stack.add(node);
        if (!isFound) dfsToFind(node.left, target, stack);
        if (!isFound) dfsToFind(node.right, target, stack);
        if (!isFound && !stack.isEmpty()) stack.pop();
    }

    private static void dfsToFind(TreeNode node, TreeNode target, Queue<TreeNode> queue) {
        if (node == null) return;
        if (node == target) {
            isFound = true;
            return;
        }
        if (!isFound) queue.offer(node);
        if (!isFound) dfsToFind(node.left, target, queue);
        if (!isFound) dfsToFind(node.right, target, queue);
        if (!isFound && !queue.isEmpty()) queue.poll();
    }
}
