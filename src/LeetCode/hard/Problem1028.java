package LeetCode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1028 {
    //https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
    public static void main(String[] args) {
//        TreeNode root = recoverFromPreorder("1-2--3--4-5--6--7");
//        TreeNode root = recoverFromPreorder("1-2--3---4-5--6---7");
        TreeNode root = recoverFromPreorder("1-401--349---90--88");
        System.out.println(root);
    }

    //https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/solutions/3389706/java-queue-dfs-solution/
    //40 min
    //Runtime
    //8 ms
    //Beats
    //36.71%
    //Memory
    //43.5 MB
    //Beats
    //14.35%
    static TreeNode recoverFromPreorder(String traversal) {
        Queue<Pair> queue = new LinkedList<>();
        int countLvl = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < traversal.length(); i++) {
            if (traversal.charAt(i) == '-') {
                countLvl++;
            } else {
                int start = i;
                while (start < traversal.length() && traversal.charAt(start) != '-')
                    sb.append(traversal.charAt(start++));

                int val = Integer.parseInt(sb.toString());
                sb.setLength(0);
                queue.add(new Pair(countLvl, val));
                countLvl = 0;
                i = start - 1;
            }
        }

        TreeNode curr = new TreeNode(queue.poll().val);
        buildTree(1, queue, curr);
        buildTree(1, queue, curr);
        return curr;
    }

    private static void buildTree(int lvl, Queue<Pair> queue, TreeNode parent) {
        if (queue.isEmpty()) return;

        Pair p = queue.peek();
        if (p == null) return;
        TreeNode left = null;
        if (p.lvl == lvl && parent != null) {
            left = new TreeNode(p.val);
            parent.left = left;
            queue.poll();
            buildTree(lvl + 1, queue, left);
        }

        if (left != null) {
            Pair p2 = queue.peek();
            if (p2 == null) return;
            TreeNode right = null;
            if (p2.lvl == lvl && parent != null) {
                right = new TreeNode(p2.val);
                parent.right = right;
                queue.poll();
                buildTree(lvl + 1, queue, right);
            }
        }
    }

    static class Pair {
        int lvl, val;

        public Pair(int lvl, int val) {
            this.lvl = lvl;
            this.val = val;
        }
    }
}
