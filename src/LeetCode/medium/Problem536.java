package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem536 {
    //https://leetcode.com/problems/construct-binary-tree-from-string/
    public static void main(String[] args) {
//        TreeNode n = str2tree("4(2(3))(6(5)(7))");
        TreeNode n = str2tree("51(232)(434)");
        System.out.println(n);
    }

    //https://leetcode.com/problems/construct-binary-tree-from-string/solutions/5323048/java-recursive-o-n-solution/
    //40-50min
    //Runtime
    //9
    //ms
    //Beats
    //54.97%
    //Analyze Complexity
    //Memory
    //45.96
    //MB
    //Beats
    //6.53%
    static TreeNode str2tree(String s) {
        if (s.length() == 0) return null;

        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        TreeNode root = new TreeNode(getNextNumber(q));
        goDFS(root, q);
        return root;
    }

    private static void goDFS(TreeNode node, Queue<Character> q) {
        if (node == null || q.isEmpty()) return;

        char c = q.poll();
        if (c == ')') return;

        if (c == '(') {//negative numbers as well
            if (node.left == null) {
                node.left = new TreeNode(getNextNumber(q));
                goDFS(node.left, q);
            }
        }
        if (!q.isEmpty()) {
            c = q.peek();
            if (c == '(') {//negative numbers as well
                q.poll();
                if (node.left != null) {
                    node.right = new TreeNode(getNextNumber(q));
                    goDFS(node.right, q);
                }
            }
        }
        if (!q.isEmpty())
            q.poll();
    }

    private static int getNextNumber(Queue<Character> q) {
        if (q.isEmpty()) {
            return 0;
        }

        char c = q.poll();
        int val = 0;
        if (c == '-') {
            while (Character.isDigit(q.peek())) {
                val = (val * 10) + (q.poll() - '0');
            }
            val = -val;
        } else {
            val = c - '0';
            while (Character.isDigit(q.peek())) {
                val = (val * 10) + (q.poll() - '0');
            }
        }
        return val;
    }
}
